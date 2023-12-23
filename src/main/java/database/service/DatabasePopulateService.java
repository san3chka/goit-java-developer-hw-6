package database.service;

import database.Database;
import database.service.Service;
import prefs.Prefs;

@Deprecated
public class DatabasePopulateService {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        Service service = new Service();

        String populateDbSqlFilePath = new Prefs().getString(Prefs.POPULATE_DB_SQL_FILE_PATH);
        service.executeUpdate(database, populateDbSqlFilePath);
    }
}
