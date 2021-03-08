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
            librarian=new Librarian(58,"ADMIN5858","Bjorn","Lothbrook","1458 Kattegat",6325);
            objectDB.entityManager.persist(librarian);
           // librarian.connectObjectDB(objectDB);

            member=new Member(62,"ShieldWarGun1452","1423 Homeland","Gunhild","Lagertha",4522,"Teacher");
            librarian.addMember(member);
            member.viewItems();
            /*
            librarian.viewItems();
            librarian.viewMembers();

            */
        Reservations reservation=new Reservations(1,80321,280321,20,0,librarian.getItems().get(0),member,librarian);
        member.reserveItem(reservation);

        librarian.viewReservations();


        objectDB.entityManager.getTransaction().commit();

    }
}
