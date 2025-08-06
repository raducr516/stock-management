package application.stock.data;
import jakarta.persistence.*;

@Entity
@Table(name = "objects")
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nume", nullable = false, unique = true)
    private String name;

    @Column(name = "stock", nullable = false)
    private int stock;
    public Object() {
    }
    public Object(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }


}
