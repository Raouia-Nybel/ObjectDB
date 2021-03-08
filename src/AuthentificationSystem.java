import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class AuthentificationSystem {
    @Id @GeneratedValue
    private int ID;
    private int loginID;
    private String password;
@Transient
private ObjectDB objectDB;

    public AuthentificationSystem() {
    }

    public AuthentificationSystem(int loginID, String password) {

        this.loginID = loginID;
        this.password = password;
    }
    public void connectObjectDB(ObjectDB objectDB)
    {
        this.objectDB=objectDB;
    }
    public void add(AuthentificationSystem authSys,ObjectDB objectDB)
    {
        this.connectObjectDB(objectDB);
        objectDB.entityManager.persist(authSys);
    }
}
