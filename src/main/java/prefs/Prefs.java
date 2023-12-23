package prefs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Prefs {
    public static final String DB_JDBC_CONNECTION_URL = "dbUrl";
    public static final String DB_JDBC_CONNECTION_USER = "userDb";
    public static final String DB_JDBC_CONNECTION_PASSWORD = "passDb";
    public static final String INIT_DB_SQL_FILE_PATH = "initDb";
    public static final String POPULATE_DB_SQL_FILE_PATH = "populateDb";
    public static final String FIND_MAX_PROJECTS_CLIENT_DB_SQL_FILE_PATH = "findMaxProjectsClient";
    public static final String FIND_LONGEST_PROJECT_DB_SQL_FILE_PATH = "findLongestProject";
    public static final String FIND_YOUNGEST_ELDEST_WORKER_DB_SQL_FILE_PATH = "findYoungestEldestWorker";
    public static final String PRINT_PROJECT_PRICES_DB_SQL_FILE_PATH = "printProjectPrices";

    public static final String DEFAULT_PREFS_FILENAME = "prefs.json";
    private Map<String, Object> prefs = new HashMap<>();

    public Prefs() {
        this(DEFAULT_PREFS_FILENAME);
    }

    public Prefs(String filename) {
        try {
            String json = Files.readString(Paths.get(filename));

            TypeToken<?> typeToken = TypeToken.getParameterized(
                    Map.class,
                    String.class,
                    Object.class
            );
            prefs = new Gson().fromJson(json, typeToken.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getString(String key) {
        return getPref(key).toString();
    }

    public Object getPref(String key) {
        return prefs.get(key);
    }
}
