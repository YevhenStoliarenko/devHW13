import model.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PlanetCrudService {
    SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();


    public Planet getPlanetById(String id) {
        Planet planet = null;
        try (Session session = sessionFactory.openSession()) {
            planet = session.find(Planet.class, id);
        }
        if (planet == null) {
            throw new RuntimeException("Wrong id");
        }
        return planet;
    }

    public void createPlanet(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        }
    }

    public boolean updatePlanet(String id, String newName) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet planetById = getPlanetById(id);
            planetById.setName(newName);
            session.merge(planetById);
            transaction.commit();
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
