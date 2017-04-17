package interfaceData;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class BookPageData {
    private String name;
    private String authorFullName;
    private int rating;
    private int price;
    private String reviews;
    private String genre;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("authorFullName", authorFullName)
                .append("rating", rating)
                .append("price", price)
                .append("reviews",reviews)
                .append("genre",genre)
                .append("name",name)
                .toString();
    }
}
