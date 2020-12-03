package Model;  /**
   * Created by Toshiko Kuno
   * Date: 2020-11-30
   * Time: 15:52
   * Project: IntelliJ IDEA
   * Copyright: MIT
   */ 
    
    
    
    public class Book {
    protected String isbn;
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

   /* public Book(String isbn, String title, String description, int numberOfBooks, String author, Category category, String publisher, String edition, int releaseDate, Language language, String numberOfPages, Library location) {
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
    }*/



    //Or We can use fluent builder (do not make constructor)


    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
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

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Book setCategory(Category category) {
        this.category = category;
        return this;
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

    public Book setLanguage(Language language) {
        this.language = language;
        return this;
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
        return isbn;
    }
}