package Model;

/**
 * Created by Toshiko Kuno
 * Date: 2020-12-01
 * Time: 10:44
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class BookTest {
    public String title;
    public String isbn;
    public String language;
    public String category;
    public String author;

    public BookTest(String title, String isbn, String language, String category, String author) {
        this.title = title;
        this.isbn = isbn;
        this.language = language;
        this.category = category;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getLanguage() {
        return language;
    }

    public String getAuthor() {
        return author;
    }
}
