package Client;

import Model.BookTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toshiko Kuno
 * Date: 2020-12-01
 * Time: 13:36
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class BookUtil {

    /**
     * Ta bort white space
     * @param text t.ex Harry Potter
     * @return harrypotter
     */
    public static String removeWhiteSpace(String text) {
        String[] split = text.split(" ");
        text = "";
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() != 0)
                text = text.concat(split[i]).toLowerCase();
        }
        return text;
    }

    //Boksök funktion
    public static List<BookTest> searchBook(String searchWord) {

        /*---------------- TEST --------------------*/
        BookTest b1 = new BookTest("Harry Potter", "123434", "Svenska", "Fantasy", "JK.Rolling");
        BookTest b2 = new BookTest("Load of the rings", "22343", "English", "Adventure", "J. R. R. Tolkien");
        BookTest b3 = new BookTest("Gozilla", "32343", "Japanese", "Action", "Tomoyuki Tanaka");

        List<BookTest> bookList = new ArrayList<>();
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);


        List<BookTest> hitSearchBookList = new ArrayList<>();
        searchWord = removeWhiteSpace(searchWord);

        for (BookTest book : bookList) {
            String title = removeWhiteSpace(book.getTitle());
            String isbn = book.getIsbn();
            if (title.contains(searchWord) || isbn.contains(searchWord)) {
                hitSearchBookList.add(book);
            }
        }
        return hitSearchBookList;
    }
}
