package dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BOOK", schema = "java_books")
public class Book {
    private Long authorId;
    private long id;
    private String name;
    private int price;
    private String reviews;
    private int rating;
    private Author author = null;

    public Book(){

    }

    public Book(long id, String name, int price,  String reviews, int rating, Author author, long authorId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.reviews = reviews;
        this.rating = rating;
        this.author = author;
        this.authorId = authorId;
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

    @Column(name = "NAME", nullable = false, unique = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "PRICE", nullable = false, unique = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "REVIEWS", nullable = false, unique = false)
    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    @Column(name = "RATING", nullable = false, unique = false)
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AUTHOR_ID", nullable = false)
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Transient
    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name",name)
                .append("reviews",reviews)
                .append("rating",rating)
                .append("price",price)
                .append("authorId",authorId)
                .toString();
    }
}
