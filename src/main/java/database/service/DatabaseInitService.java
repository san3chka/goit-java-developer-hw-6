package database.service;

import database.Database;
import database.service.Service;
import org.flywaydb.core.Flyway;
import prefs.Prefs;

@Deprecated
public class DatabaseInitService {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        Service service = new Service();

        String initDbSqlFilePath = new Prefs().getString(Prefs.INIT_DB_SQL_FILE_PATH);
        service.executeUpdate(database, initDbSqlFilePath);
    }
}
