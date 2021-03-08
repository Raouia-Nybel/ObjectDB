import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Items {
@Id
    private int ISBN;
   // private int authNo;
    @ManyToMany
    private Author author;
    private String title;
    private String edition;
    private String category;
    private float price;

    public Items() {
    }

    public Items(int ISBN, Author author, String title, String edition, String category, float price) {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.edition = edition;
        this.category = category;
        this.price = price;
    }

    public int getISBN() {
        return ISBN;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getEdition() {
        return edition;
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }
}
