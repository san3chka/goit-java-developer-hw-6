package database.service;

import org.flywaydb.core.Flyway;
import prefs.Prefs;

public class DatabaseMigrationService {
    public static void main(String[] args) {
        Flyway flyway = Flyway
                .configure()
                .dataSource(
                        new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL),
                        new Prefs().getString(Prefs.DB_JDBC_CONNECTION_USER),
                        new Prefs().getString(Prefs.DB_JDBC_CONNECTION_PASSWORD)
                ).load();

        flyway.migrate();
    }
}
