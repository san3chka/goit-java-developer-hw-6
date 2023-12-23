package database.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class DatabaseUpdateService {
    private PreparedStatement insertIntoWorkerSt;
    private PreparedStatement insertIntoClientSt;
    private PreparedStatement insertIntoProjectSt;
    private PreparedStatement insertIntoProjectWorkerSt;

    private Connection connection;

    public DatabaseUpdateService(Connection connection) {
        this.connection = connection;

        try {
            insertIntoWorkerSt = this.connection.prepareStatement(
                    "INSERT INTO worker (name, birthday, level, salary) VALUES (?, ?, ?, ?)"
            );

            insertIntoClientSt = this.connection.prepareStatement(
                    "INSERT INTO client (name) VALUES (?)"
            );

            insertIntoProjectSt = this.connection.prepareStatement(
                    "INSERT INTO project(client_id, start_date, finish_date) VALUES (?, ?, ?)"
            );

            insertIntoProjectWorkerSt = this.connection.prepareStatement(
                    "INSERT INTO project_worker(project_id, worker_id) VALUES (?, ?)"
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean addNewWorker(String name, LocalDate birthday, String level, int salary)  {
        try {
            insertIntoWorkerSt.setString(1, name);
            insertIntoWorkerSt.setDate(2, Date.valueOf(birthday));
            insertIntoWorkerSt.setString(3, level);
            insertIntoWorkerSt.setInt(4, salary);
            return insertIntoWorkerSt.executeUpdate() == 1;
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean addNewClient(String name) {
        try {
            insertIntoClientSt.setString(1, name);
            return insertIntoClientSt.executeUpdate() == 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean addNewProject(int clientId, LocalDate startDate, LocalDate finishDate) {
        try {
            insertIntoProjectSt.setInt(1, clientId);
            insertIntoProjectSt.setDate(2, Date.valueOf(startDate));
            insertIntoProjectSt.setDate(3, Date.valueOf(finishDate));
            return insertIntoProjectSt.executeUpdate() == 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean addNewProjectWorker(int projectId, int workerId) {
        try {
            insertIntoProjectWorkerSt.setInt(1, projectId);
            insertIntoProjectWorkerSt.setInt(2, workerId);
            return insertIntoProjectWorkerSt.executeUpdate() == 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
