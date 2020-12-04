package Model;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Toshiko Kuno
 * Date: 2020-12-03
 * Time: 16:12
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class History {
    private UserTest user;
    private Book book;
    private LocalDate returnDate;
    private LocalDate lendOutDate;

    public History(UserTest user, Book book, LocalDate returnDate, LocalDate lendOutDate) {
        this.user = user;
        this.book = book;
        this.returnDate = returnDate;
        this.lendOutDate = lendOutDate;
    }

    public LocalDate getLendOutDate() {
        return lendOutDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public Book getBook() {
        return book;
    }
}
