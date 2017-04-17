package interfaceData;


import org.apache.commons.lang3.builder.ToStringBuilder;

public class AuthorPageData {
    private String firstName;
    private String lastName;
    private String books;

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("first_name", firstName)
                .append("last_name", lastName)
                .append("books",books)
                .toString();
    }
}
