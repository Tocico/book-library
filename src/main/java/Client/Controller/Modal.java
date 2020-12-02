package Client.Controller;

import Client.BookUtil;
import Model.Book;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Toshiko Kuno
 * Date: 2020-12-02
 * Time: 14:13
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class Modal {

    public AnchorPane modalPane;

    public static void displayBook(String isbn) {
        final Label ISBN = new Label("ISBN");
        final Label TITLE = new Label("Title");
        final Label AUTHOR = new Label("Author");
        final Label CATEGORY = new Label("Category");
        final Label LANGUAGE = new Label("Language");
        final Label DESCRIPTION = new Label("Description");
        final Label NUMBEROFBOOKS = new Label("Number of books");
        final Label PUBLISHER = new Label("Publisher");
        final Label EDITION = new Label("Edition");
        final Label RELEASEDATE = new Label("Release Date");
        final Label NUMBEROFPAGES = new Label("Number of Pages");
        final Label LOCATION = new Label("Location");
        final Button closeBtn = new Button("CLOSE");

        //Hämta bok som klickat
        Book selectedBook = BookUtil.getBook(isbn);

        Text isbnT = new Text(selectedBook.getIsbn());
        Text titleT = new Text(selectedBook.getTitle());
        Text authorT = new Text(selectedBook.getAuthor());
        Text categoryT = new Text(selectedBook.getCategory().getCategory());
        Text languageT = new Text(selectedBook.getLanguage().toString());
        Text descriptionT = new Text(selectedBook.getDescription());
        Text numberOfBooksT = new Text(String.valueOf(selectedBook.getNumberOfBooks()));
        Text numberOfPagesT = new Text(String.valueOf(selectedBook.getNumberOfPages()));
        Text publisherT = new Text(selectedBook.getPublisher());
        Text editionT = new Text(selectedBook.getEdition());
        Text releaseDateT = new Text(String.valueOf(selectedBook.getReleaseDate()));
        //Text locationT = new Text(selectedBook.getLocation().getLibraryName());



        Stage popupwindow = new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        //Stänga fönstret
        closeBtn.setOnAction(e -> popupwindow.close());

        GridPane gridPane = new GridPane();

        gridPane.add(ISBN, 0, 0);
        gridPane.add(TITLE, 0, 1);
        gridPane.add(AUTHOR, 0, 2);
        gridPane.add(CATEGORY, 0, 3);
        gridPane.add(LANGUAGE, 0, 4);
        gridPane.add(DESCRIPTION, 0, 5);
        gridPane.add(NUMBEROFBOOKS, 0, 6);
        gridPane.add(NUMBEROFPAGES, 0, 7);
        gridPane.add(PUBLISHER, 0, 8);
        gridPane.add(EDITION, 0, 9);
        gridPane.add(RELEASEDATE, 0, 10);
        gridPane.add(LOCATION, 0, 11);
        gridPane.add(isbnT, 1, 0);
        gridPane.add(titleT, 1, 1);
        gridPane.add(authorT, 1, 2);
        gridPane.add(categoryT, 1, 3);
        gridPane.add(languageT, 1, 4);
        gridPane.add(descriptionT, 1, 5);
        gridPane.add(numberOfBooksT, 1, 6);
        gridPane.add(numberOfPagesT, 1, 7);
        gridPane.add(publisherT, 1, 8);
        gridPane.add(editionT, 1, 9);
        gridPane.add(releaseDateT, 1, 10);
        //gridPane.add(locationT, 1, 11);


        VBox layout = new VBox(10);


        gridPane.getChildren().addAll(closeBtn);

        gridPane.setAlignment(Pos.CENTER);

        Scene scene1 = new Scene(gridPane);

        popupwindow.setScene(scene1);

        popupwindow.show();


    }

    public void closeModal(ActionEvent actionEvent) {
    }

}
