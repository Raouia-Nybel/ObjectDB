import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Author {
    @Id
    private int authorID;
    private int yearOfPub;
    private String name;

    public Author(int authorID, int yearOfPub, String name) {
        this.authorID = authorID;
        this.yearOfPub = yearOfPub;
        this.name = name;
    }
}
