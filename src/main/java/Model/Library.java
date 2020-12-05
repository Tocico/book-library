package Model;

import java.util.List;

/**
   * Created by Toshiko Kuno
   * Date: 2020-11-30
   * Time: 15:52
   * Project: IntelliJ IDEA
   * Copyright: MIT
   */ 

    
    public class Library {
        protected List<Book> books;
        protected int count;

    public List<Book> getBooks() {
        return books;
    }

    public Library setBooks(List<Book> books) {
        this.books = books;
        return this;
    }

    public int getCount() {
        return count;
    }

    public Library setCount(int count) {
        this.count = count;
        return this;
    }
}
