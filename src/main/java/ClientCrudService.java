
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import model.Client;
import model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientCrudService {
    SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();


    public void deleteClientById(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.remove(client);
            transaction.commit();
        }
    }

    public void createClient(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }

    }

        public boolean updateClient(int id, String newName) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Client clientById = session.get(Client.class, id);
            clientById.setName(newName);
            session.merge(clientById);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /*
    коли намагаюся вивести в консоль квиток, або кліента, помилка stackoverflow
     */
        public Client getClientById(int id) {
        Client client = null;
        Session session = sessionFactory.openSession();
            client = session.get(Client.class, id);
            session.close();

        if (client == null) {
            throw new RuntimeException("Wrong id");
        }
        return client;
    }



}
