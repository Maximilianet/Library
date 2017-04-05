package dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BOOK", schema = "java_books")
public class Book {
    private long id;
    private String name;
    private int price;
    private int authorId;
    private String review;
    private int rating;

    public Book(){

    }

    public Book(long id, String name, int price, int authorId, String review, int rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.authorId = authorId;
        this.review = review;
        this.rating = rating;
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

    @Column(name = "AUTHOR_ID", nullable = false, unique = false)
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Column(name = "REVIEW", nullable = false, unique = false)
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Column(name = "RATING", nullable = false, unique = false)
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name",name)
                .append("author_id",authorId)
                .append("reviews",review)
                .append("rating",rating)
                .append("price",price)
                .toString();
    }
}
