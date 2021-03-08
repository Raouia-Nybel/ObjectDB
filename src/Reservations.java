import javax.persistence.*;

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
    @ManyToOne
    private Member member;
//    private int adminID;
    @ManyToOne
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

    public int getReservationNo() {
        return reservationNo;
    }

    public int getReserveDate() {
        return reserveDate;
    }

    public int getReturnDate() {
        return returnDate;
    }

    public int getDuration() {
        return duration;
    }

    public double getFees() {
        return fees;
    }

    public Items getItem() {
        return item;
    }

    public Member getMember() {
        return member;
    }

    public Librarian getLibrarian() {
        return librarian;
    }
}
