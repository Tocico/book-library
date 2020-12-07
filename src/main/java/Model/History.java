package Model;

import java.io.Serializable;
import java.time.LocalDate;
import Model.UserEntities.User;
import java.util.List;

/**
 * Created by Toshiko Kuno
 * Date: 2020-12-03
 * Time: 16:12
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class History implements Serializable {
    private User user;
    private Book book;
    private LocalDate returnDate;
    private LocalDate lendOutDate;

    public History(User user, Book book, LocalDate lendOutDate, LocalDate returnDate) {
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

    public User getUser() {
        return user;
    }
}
