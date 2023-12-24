package client;

import container.PostgresContainer;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ClientServiceTest {

    private static ClientService clientService;
    static PostgresContainer postgresContainer = new PostgresContainer();

    @BeforeEach
    void setUp() throws SQLException {
        postgresContainer.start();
        clientService = new ClientService(postgresContainer.getConnection());
    }

    @AfterEach
    void tearDown() {
        postgresContainer.stop();
    }

    @Test
    public void getByIdTest() {
        long id = 1;
        String expected = "Client 1";

        String actual = clientService.getById(id);

        assertEquals(actual, expected);
    }

    @Test
    public void createClientTest() {
        String expected = "test";

        clientService.create(expected);
        String actual = clientService.getById(6);

        assertEquals(actual, expected);
    }

    @Test
    public void setNameTest() {
        String expected = "new name";
        long id = 1;

        clientService.setName(expected, id);
        String actual = clientService.getById(id);
        assertEquals(actual, expected);
    }

    @Test
    public void deleteByIdTest() {
        long id = 1;

        clientService.deleteById(id);
        String actual = clientService.getById(id);

        assertNull(actual); //null - expected
    }

    @Test
    public void listAllTest() {
        List<Client> actual = clientService.listAll();
        List<Client> expected = new ArrayList<>();
        expected.add(new Client(1, "Client 1"));
        expected.add(new Client(2, "Client 2"));
        expected.add(new Client(3, "Client 3"));
        expected.add(new Client(4, "Client 4"));
        expected.add(new Client(5, "Client 5"));

        assertEquals(actual, expected);
    }
}
