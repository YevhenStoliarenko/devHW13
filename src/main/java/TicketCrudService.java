import model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class TicketCrudService {
    SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();


    public boolean createTicket(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            return false;
        }

    }


    public boolean updateTicket(int id, Ticket newTicket){
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            ticket.setCreatedTime(newTicket.getCreatedTime());
            ticket.setClient(newTicket.getClient());
            ticket.setFromPlanet(newTicket.getFromPlanet());
            ticket.setToPlanet(newTicket.getToPlanet());
            session.merge(ticket);
            transaction.commit();
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean deleteTicket(int id){
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            session.remove(ticket);
            transaction.commit();
            return true;
        }catch (Exception ex){
            return false;
        }
    }


/*
коли намагаюся вивести в консоль квиток, або кліента, помилка stackoverflow
 */
    public void getTicketById(int id){
        try (Session session = sessionFactory.openSession()) {
            Ticket ticket = session.get(Ticket.class, id);
            System.out.println(ticket);

        }

    }

}
