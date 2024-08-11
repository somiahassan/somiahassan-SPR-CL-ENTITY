package Lab.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Spring uses Object Relational Mapping (ORM) to provide an easy way to interact with the database. Most of the time,
 * database tables directly match model classes used in Java. Therefore, it is possible to dynamically generate
 * SQL statements based on the contents of an object. ORM allows us to interact with
 * the database by directly retrieving and manipulating special objects called Entities, without the
 * need to write SQL statements.
 *
 * This class is marked as an Entity using the @Entity annotation. The field marked with the @Id annotation
 * establishes the primary key of the database table. All other fields of the class automatically become columns
 * of the database table.
 *
 * Hibernate is the default "ORM provider" used in Spring Data, and you may see it mentioned in exceptions and documentation.
 *
 * You can read Spring's documentation on Spring Data JPA & Entities here: https://spring.io/guides/gs/accessing-data-jpa/
 */
@Entity
public class Product {

    @Id
    private long productID;
    private String name;
    private String description;

    public Product(long productID, String name, String description) {
        this.productID = productID;
        this.name = name;
        this.description = description;
    }

    public Product() {
        // Default constructor required by JPA
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productID == product.productID &&
               Objects.equals(name, product.name) &&
               Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, name, description);
    }

    @Override
    public String toString() {
        return "Product{" +
               "productID=" + productID +
               ", name='" + name + '\'' +
               ", description='" + description + '\'' +
               '}';
    }
}
