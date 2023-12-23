package client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private PreparedStatement createClient;
    private PreparedStatement getClientByID;
    private PreparedStatement setClientName;
    private PreparedStatement deleteClientById;
    private PreparedStatement getAllClient;

    private Connection connection;

    public ClientService(Connection connection) {
        this.connection = connection;

        try {
            createClient = this.connection.prepareStatement(
                    "INSERT INTO client (name) VALUES (?)"
            );

            getClientByID = this.connection.prepareStatement(
                    "SELECT name FROM client WHERE id = ?"
            );

            setClientName = this.connection.prepareStatement(
                    "UPDATE client SET name = ? WHERE id = ?"
            );

            deleteClientById = this.connection.prepareStatement(
                    "DELETE FROM client WHERE id = ?"
            );

            getAllClient = this.connection.prepareStatement(
                    "SELECT * FROM client"
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public long create(String name) {
        try {
            createClient.setString(1, name);
            return createClient.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public String getById(long id) {
        String result = null;
        try {
            getClientByID.setLong(1, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (ResultSet rs = getClientByID.executeQuery()) {


            while (rs.next()) {
                result = rs.getString("name");
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public void setName(String name, long id) {
        try {
            setClientName.setString(1, name);
            setClientName.setLong(2, id);
            setClientName.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteById(long id) {
        try {
            deleteClientById.setLong(1, id);
            deleteClientById.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Client> listAll() {
        List<Client> result = new ArrayList<>();

        try (ResultSet rs = getAllClient.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                long id = rs.getLong("id");

                Client var = new Client(
                        id,
                        name
                );

                result.add(var);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }
}
