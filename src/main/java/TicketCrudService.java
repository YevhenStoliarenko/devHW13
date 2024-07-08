
import model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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


    public boolean updateTicket(int id, Ticket newTicket) {
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
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean deleteTicket(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            session.remove(ticket);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }


    public Ticket getTicketById(int id) {
        Ticket ticket = null;
        try (Session session = sessionFactory.openSession()) {
            ticket = session.get(Ticket.class, id);
        }
        if (ticket == null) {
            throw new RuntimeException("Wrong id");
        }
        return ticket;
    }

}
