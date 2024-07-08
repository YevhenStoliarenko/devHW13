
import model.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientCrudServiceTest {
    ClientCrudService clientCrudService;

    @BeforeEach
    public void beforeEach() {
        clientCrudService = new ClientCrudService();
    }

    @Test
    void getClientById() {
        int clientById = clientCrudService.getClientById(2).getId();
        int expected = 2;
        assertEquals(expected, clientById);
    }

    @Test
    void createClient() {
        Client client = new Client();
        clientCrudService.createClient(client);
        assertNotNull(client.getId());
    }

    @Test
    void updateClient() {
        boolean result = clientCrudService.updateClient(2, "Olha");
        assertEquals(true, result);
    }

    @Test
    void deleteClientById() {
        boolean result = clientCrudService.deleteClientById(3);
        assertEquals(true, result);
    }


}
