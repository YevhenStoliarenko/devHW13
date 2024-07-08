import model.Client;
import model.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketCrudServiceTest {
    TicketCrudService ticketCrudService;
    ClientCrudService clientCrudService = new ClientCrudService();

    @BeforeEach
    public void beforeEach() {
        ticketCrudService = new TicketCrudService();
    }

    @Test
    void createTicket() {
        Ticket ticket = new Ticket();
        ticketCrudService.createTicket(ticket);
        assertNotNull(ticket);

    }

    @Test
    void updateTicket() {
        Ticket newTicket = new Ticket().builder()
                .createdTime("2013-01-09 07:15:00")
                .client(clientCrudService.getClientById(2))
                .fromPlanet("JPT1")
                .toPlanet("URN")
                .build();
        boolean result = ticketCrudService.updateTicket(4, newTicket);
        assertEquals(true, result);
    }

    @Test
    void deleteTicket() {
        boolean result = ticketCrudService.deleteTicket(3);
        assertEquals(true, result);
    }

    @Test
    void getTicketById() {
        int ticket = ticketCrudService.getTicketById(4).getId();
        int expected = 4;
        assertEquals(expected, ticket);
    }
}