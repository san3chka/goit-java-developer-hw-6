package container;

import org.flywaydb.core.Flyway;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Testcontainers
public class PostgresContainer {

    @Container
    private static final PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:latest");
    private Connection connection;

    public void start() throws SQLException {
        postgresContainer.start();
        String jdbcUrl = postgresContainer.getJdbcUrl();
        String username = postgresContainer.getUsername();
        String password = postgresContainer.getPassword();

        connection = DriverManager.getConnection(jdbcUrl, username, password);

        Flyway flyway = Flyway
                .configure()
                .dataSource(jdbcUrl, username, password)
                .load();

        flyway.migrate();
    }

    public PostgreSQLContainer<?> getPostgresContainer() {
        return postgresContainer;
    }

    public Connection getConnection() {
        return connection;
    }


    public void stop() {
        postgresContainer.stop();
    }
}
