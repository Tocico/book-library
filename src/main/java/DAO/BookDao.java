package DAO;

import Model.Book;
import Model.Category;
import Model.Language;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toshiko Kuno
 * Date: 2020-12-05
 * Time: 10:39
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class BookDao implements Dao<Book> {

    //Spara data som hämtar från textfil i lista
    private List<Book> bookList = new ArrayList<>();

    //Hämta data från textfil?
    public BookDao() {
        /*---------------- TEST --------------------*/
        bookList.add(new Book().setTitle("Harry Potter").setIsbn("123434").setCategory(Category.FANTASY).setLanguage(Language.Svenska).setAuthor("JK.Rolling").setNumberOfBooks(2));
        bookList.add(new Book().setTitle("Load of the rings").setIsbn("22343").setCategory(Category.FANTASY).setLanguage(Language.Engelska).setAuthor("J. R. R. Tolkien").setNumberOfBooks(4));
        bookList.add(new Book().setTitle("Gozilla").setIsbn("32343").setCategory(Category.SCIENCE_FICTION).setLanguage(Language.Engelska).setAuthor("Tomoyuki Tanaka").setNumberOfBooks(1));
        /*------------------------------------------*/
    }

    @Override
    public List<Book> getAll() {
        return bookList;
    }

    //Register book
    @Override
    public void save(Book book) {
        bookList.add(book);
        //TODO: Updatera db? Deserialize?
    }

    //Update book
    @Override
    public void update(Book book) {
        bookList.get(bookList.indexOf(book));
        //TODO: Updatera db? Deserialize?
    }

    //Remove book
    @Override
    public void delete(Book book) {
       bookList.remove(bookList.indexOf(book));
       //TODO: Updatera db? Deserialize?
    }

}
