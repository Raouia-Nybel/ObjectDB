import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.TypedQuery;
import java.util.List;

@Entity
public class Librarian {
    @Id
    private int adminID;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private double phoneNo;
   // Library_Sys_JDBC lsj=new Library_Sys_JDBC();
    @Transient ObjectDB objectDB;

    public Librarian(int adminID, String password, String firstName, String lastName, String address, double phoneNo) {
        objectDB=new ObjectDB();
        AuthentificationSystem authSys=new AuthentificationSystem(adminID,password);
        authSys.add(authSys, objectDB);
        this.adminID = adminID;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNo = phoneNo;
      //  lsj.connection();
       // lsj.insertion(add());

    }

    public Librarian() {

    }
    public void connectObjectDB(ObjectDB objectDB)
    {
        this.objectDB=objectDB;
    }

    public void addMember(Member member)
    {
        objectDB.entityManager.persist(member);
    }
    public void addItem(Items item)
    {
        objectDB.entityManager.persist(item);
    }
    public void viewMembers()
    {
        int number=0;
        TypedQuery<Member> query=this.objectDB.entityManager.createQuery("SELECT m FROM Member m",Member.class);
        List<Member> results=query.getResultList();
        for(Member m : results)
        {
            number++;
            System.out.println("Member "+ number);
            System.out.println("First Name : "+m.getFirstName()
            +" \n Last Name : "+m.getLastName()
            +" \n User ID : "+m.getUserID()
            +" \n Profession : "+m.getProfession()
            +" \n Address : "+m.getAddress());
        }
    }
    public void viewItems()
    {
        int number=0;
        TypedQuery<Items> query=this.objectDB.entityManager.createQuery("SELECT i FROM Items i",Items.class);
        List<Items> results=query.getResultList();
        for(Items i : results)
        {
            number++;
            System.out.println("Item "+ number);
            System.out.println("ISBN : "+i.getISBN()
            +" \n Title : "+i.getTitle()
            +" \n Edition : "+i.getEdition()
            +" \n Category : "+i.getCategory()
            +" \n Price : "+i.getPrice());
        }
    }
}
