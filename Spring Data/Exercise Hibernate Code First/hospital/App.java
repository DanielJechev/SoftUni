package entities.gringotts;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    private  static final String Gringotts="gringotts";
    private static final String Sales="sales";
    private static final String UniversitySystem="university_system";
    private static final String Hospital="hospital";
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=
                Persistence.createEntityManagerFactory(Hospital);
    //    EntityManager entityManager=entityManagerFactory.createEntityManager();
    //entities.gringotts.Engine engine=new entities.gringotts.Engine(entityManager);
    //engine.run();
    }
}
