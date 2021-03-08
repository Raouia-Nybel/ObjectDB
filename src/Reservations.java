import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Reservations {
    @Id
    private int reservationNo;
    private int reserveDate;
    private int returnDate;
    private int duration;
    private double fees;
    @OneToOne
    private Items item;
    //private int ISBN;
    //private int userID;
    @OneToMany
    private Member member;
//    private int adminID;
    @OneToMany
    private Librarian librarian;

    public Reservations() {
    }

    public Reservations(int reservationNo, int reserveDate, int returnDate, int duration, double fees, Items item, Member member, Librarian librarian) {
        this.reservationNo = reservationNo;
        this.reserveDate = reserveDate;
        this.returnDate = returnDate;
        this.duration = duration;
        this.fees = fees;
        this.item = item;
        this.member = member;
        this.librarian = librarian;
    }
}
