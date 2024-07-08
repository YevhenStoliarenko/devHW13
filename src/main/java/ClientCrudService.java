
import model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClientCrudService {
    SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();


    public boolean deleteClientById(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.remove(client);
            transaction.commit();
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public void createClient(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            System.out.println(client.getId());
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

    public Client getClientById(int id) {
        Client client = null;
        try (Session session = sessionFactory.openSession();){
            client = session.get(Client.class, id);
        }
        if (client == null) {
            throw new RuntimeException("Wrong id");
        }
        return client;
    }

}
