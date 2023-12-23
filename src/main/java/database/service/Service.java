package database.service;

import database.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Service {

    public String readSqlAndReturnString(String filePath) {
        try {
            return Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeUpdate(Database database, String filePath) {
        String sql = readSqlAndReturnString(filePath);

        database.executeUpdate(sql);
    }
}
