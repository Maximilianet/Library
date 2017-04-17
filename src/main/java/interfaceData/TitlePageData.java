package interfaceData;


import org.apache.commons.lang3.builder.ToStringBuilder;

public class TitlePageData {
    private String name;
    private String authorFullName;
    private int rating;
    private int price;
    private String genre;

    public TitlePageData() {
    }

    public TitlePageData(String name, String authorFullName, int rating, int price, String genre) {
        this.name = name;
        this.authorFullName = authorFullName;
        this.rating = rating;
        this.price = price;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("authorFullName", authorFullName)
                .append("rating", rating)
                .append("price", price)
                .append("genre", genre)
                .toString();
    }
}
