package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbTableCreator {

    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;
        String sql = "";
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/books",
                            "postgres", "12345");

            stmt = c.createStatement();

            sql = "CREATE SCHEMA IF NOT EXISTS JAVA_BOOKS ";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS JAVA_BOOKS.BOOK "
                    + " ( "
                    + " ID                      SERIAL PRIMARY KEY     NOT NULL, "
                    + " NAME                    CHAR(100)              NOT NULL, "
                    + " PRICE                   INT                    NOT NULL,  "
                    + " AUTHOR_ID               INT                    NOT NULL,   "
                    + " REVIEWS                 CHAR(500)              NOT NULL,"
                    + " RATING                  INT                    NOT NULL"
                    + " ) ";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS JAVA_BOOKS.AUTHOR "
                    + " ( "
                    + " ID                      SERIAL PRIMARY KEY     NOT NULL, "
                    + " FIRST_NAME                    CHAR(100)              NOT NULL, "
                    + " LAST_NAME                     CHAR(100)              NOT NULL "
                    + " ) ";
            stmt.executeUpdate(sql);

//            sql = "CREATE TABLE IF NOT EXISTS JAVA_BOOKS.REVIEWS "
//                    + " ( "
//                    + " ID                      SERIAL PRIMARY KEY     NOT NULL, "
//                    + " BOOK_ID                 INT             NOT NULL, "
//                    + " REVIEW                  CHAR(1000)       NOT NULL"
//                    + " ) ";
//            stmt.executeUpdate(sql);

//            sql = "ALTER TABLE JAVA_BOOKS.AUTHOR "
//                    + " ADD CONSTRAINT FK_BOOK "
//                    + " FOREIGN KEY (BOOK_ID) REFERENCES JAVA_BOOKS.BOOK (ID) MATCH FULL "
//                    + " ";
//            stmt.executeUpdate(sql);

            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}

