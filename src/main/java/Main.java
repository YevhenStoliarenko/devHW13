

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
//        Client newClient = Client.builder()
//                .name("Nik")
//                .build();
//        clientCrudService.deleteClientById(7);
//        clientCrudService.createClient(newClient);
//        clientCrudService.updateClient(6, "Martin");
//        Client clientById = clientCrudService.getClientById(8);
//        System.out.println(clientById);
//
//        Ticket newTicket = new Ticket().builder()
//                .createdTime("2013-01-09 07:15:00")
//                .client(clientById)
//                .fromPlanet("MRS")
//                .toPlanet("URN")
//                .build();
//
//        ticketCrudService.createTicket(newTicket);
//        ticketCrudService.updateTicket(6, newTicket);
//        ticketCrudService.deleteTicket(8);


        ticketCrudService.getTicketById(1);



    }
}
