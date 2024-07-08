

import model.Client;
import model.Ticket;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
//        Connection connection = Database.getInstance().getConnection();
        ClientCrudService clientCrudService = new ClientCrudService();
        TicketCrudService ticketCrudService = new TicketCrudService();
        Client newClient = Client.builder()
                .name("Miro")
                .build();
//        clientCrudService.createClient(newClient);
//        System.out.println(clientCrudService.getClientById(17));
//        clientCrudService.updateClient(6, "Martin");
//        clientCrudService.deleteClientById(1);

        Ticket newTicket = new Ticket().builder()
                .createdTime("2013-01-09 07:15:00")
                .client(newClient)
                .fromPlanet("JPT1")
                .toPlanet("URN")
                .build();

//        ticketCrudService.createTicket(newTicket);
//        System.out.println(ticketCrudService.getTicketById(13));
//        ticketCrudService.updateTicket(4, newTicket);
//        ticketCrudService.deleteTicket(13);






    }
}
