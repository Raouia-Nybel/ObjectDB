import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.TypedQuery;
import java.util.List;

@Entity
public class Member {
    @Id
    private int userID;
    private String password;
    private String address;
    private String firstName;
    private String lastName;
    private double phoneNo;
    private String profession;
    @Transient ObjectDB objectDB;
    //Library_Sys_JDBC lsj=new Library_Sys_JDBC();


    public Member(int userID, String password, String address, String firstName, String lastName, double phoneNo, String profession) {
      objectDB=new ObjectDB();
        AuthentificationSystem authSys=new AuthentificationSystem(userID,password);
        authSys.add(authSys,objectDB);
        this.userID = userID;
        this.password = password;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.profession = profession;

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
    public void reserveItem(Reservations reservation)
    {
        objectDB.entityManager.persist(reservation);
    }

    public int getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getPhoneNo() {
        return phoneNo;
    }

    public String getProfession() {
        return profession;
    }

}
