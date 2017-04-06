package dao;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "AUTHOR", schema = "java_books")
public class Author {
    private Set<Book> books;
    private long id;
    private String firstName;
    private String lastName;


    public Author(){

    }

    public Author(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "FIRST_NAME", nullable = false, unique = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    @Column(name = "LAST_NAME", nullable = false, unique = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book>books) {
        this.books = books;
    }
}
