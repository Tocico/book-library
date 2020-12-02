package Model;  /**
   * Created by Toshiko Kuno
   * Date: 2020-11-30
   * Time: 15:52
   * Project: IntelliJ IDEA
   * Copyright: MIT
   */ 
    
    
    
    public class Book {
    protected int isbn;
    protected String title;
    protected String description;
    protected int numberOfBooks;
    protected String author;
    protected Category category;// enum
    protected String publisher;
    protected String edition;
    protected int releaseDate;
    protected Language language;//enum
    protected String numberOfPages;
    protected Library location;// other klass

    // I think that we need to use setter and need to use a builder pattern...

    public Book(int isbn, String title, String description, int numberOfBooks, String author, Category category, String publisher, String edition, int releaseDate, Language language, String numberOfPages, Library location) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.numberOfBooks = numberOfBooks;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
        this.edition = edition;
        this.releaseDate = releaseDate;
        this.language = language;
        this.numberOfPages = numberOfPages;
        this.location = location;
    }


    //Or We can use fluent builder (do not make constructor)


    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(String numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Library getLocation() {
        return location;
    }

    public void setLocation(Library location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", numberOfBooks=" + numberOfBooks +
                ", author='" + author + '\'' +
                ", category=" + category +
                ", publisher='" + publisher + '\'' +
                ", edition='" + edition + '\'' +
                ", releaseDate=" + releaseDate +
                ", language=" + language +
                ", numberOfPages='" + numberOfPages + '\'' +
                ", location=" + location +
                '}';
    }
}