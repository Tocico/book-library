package DAO;

import Model.Book;
import Model.StorageUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    private StorageUtil db;

    //Hämta data från textfil?
    public BookDao() {
       /* *//*---------------- TEST --------------------*//*
        bookList.add(new Book().setTitle("Harry Potter").setIsbn("123434").setCategory(Category.FANTASY).setLanguage(Language.Svenska).setAuthor("JK.Rolling").setNumberOfBooks(2));
        bookList.add(new Book().setTitle("Load of the rings").setIsbn("22343").setCategory(Category.FANTASY).setLanguage(Language.Engelska).setAuthor("J. R. R. Tolkien").setNumberOfBooks(4));
        bookList.add(new Book().setTitle("Gozilla").setIsbn("32343").setCategory(Category.SCIENCE_FICTION).setLanguage(Language.Engelska).setAuthor("Tomoyuki Tanaka").setNumberOfBooks(1));
        *//*------------------------------------------*/


        try {
            db = new StorageUtil("books");
            //saveAll();
            bookList = getAll(); //Overwrite current history list with the fetched deserialized data

            System.out.println("Loaded data: " + bookList);
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Book> getAll() throws IOException, ClassNotFoundException {
        return db.deserializeReadList();
    }

    @Override
    public void saveAll() throws IOException {
        db.serializeStoreList(bookList);
    }

    //Register book
    @Override
    public void save(Book book) throws IOException {
        bookList.add(book);
        saveAll();
    }

    //Update book
    @Override
    public void update(Book book) throws IOException {
        bookList.get(bookList.indexOf(book));
        saveAll();
    }

    //Remove book
    @Override
    public void delete(Book book) throws IOException {
        bookList.remove(bookList.indexOf(book));
        saveAll();
    }

    public Book getByIsbn(String isbn) {
        return bookList.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .filter(book -> !book.getIsCheckOut())
                .findAny()
                .orElse(null);
    }

    public Book getById(String id) {
        for (Object e : bookList) {
            if (e instanceof Book) {
                if(((Book) e).getId().equals(id)) return (Book) e;
            }
        }
        return null;
    }

    public List<Book> getByName(String name) {
        List<Book> foundBooks = new ArrayList<>();
        for (Object e : bookList) {
            if (e instanceof Book) {
                if((((Book) e).getTitle().equals(name))) foundBooks.add((Book) e);
            }
        }
        return foundBooks;
    }

   public List<Book> removeDublicateBook() {
       Map<String, Book> map = new HashMap<>();
       for (Book book : bookList) {
           map.put(book.getIsbn(), book);
       }
       //Map -> List
       List<Book> filteredBookList = new ArrayList<>(map.values());

       return filteredBookList;
    }

}
