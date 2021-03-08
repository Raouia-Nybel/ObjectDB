import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {

    public static void main(String[] args){
        ObjectDB objectDB;
        AuthentificationSystem authSys;
        Librarian librarian;
        Member member;
        Items item;
        Author author;
        objectDB=new ObjectDB();


        objectDB.entityManager.getTransaction().begin();

            //authSys=new AuthentificationSystem(45,"ADMIN4545");
            librarian=new Librarian(85,"ADMIN8585","Eniko","Hanak","3529 Miskolc",7852);
            objectDB.entityManager.persist(librarian);
           // librarian.connectObjectDB(objectDB);

            member=new Member(42,"najib42080814","3527 Miskolc","Najib","Ajir",4523,"Student");
            librarian.addMember(member);

            librarian.viewItems();
            librarian.viewMembers();
            member.viewItems();




        objectDB.entityManager.getTransaction().commit();

    }
}
