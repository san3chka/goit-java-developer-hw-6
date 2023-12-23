package database;

import prefs.Prefs;

import java.sql.*;

public class Database {
    private static final Database INSTANCE = new Database();
    private Connection connection;

    private Database() {
        try {
            String connectionUrl = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL);
            String userDb = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_USER);
            String passwordDb = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_PASSWORD);
            connection = DriverManager.getConnection(connectionUrl, userDb, passwordDb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public int executeUpdate(String sql) {
        try (PreparedStatement st = connection.prepareStatement(sql)){
            return st.executeUpdate();
        }catch (Exception ex) {
            ex.printStackTrace();

            return -1;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
