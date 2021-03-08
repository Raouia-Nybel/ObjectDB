import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObjectDB {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public ObjectDB() {
        this.entityManagerFactory=Persistence.createEntityManagerFactory("$objectdb/db/library_sys.odb");
        this.entityManager=this.entityManagerFactory.createEntityManager();
    }



}
