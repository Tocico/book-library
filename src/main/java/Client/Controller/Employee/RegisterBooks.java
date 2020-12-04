package Client.Controller.Employee;

import javafx.event.ActionEvent;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Miwa Guhrés
 * Date: 2020-12-03
 * Time: 22:21
 * Project: Bibliotek
 * Copyright: MIT
 */
public class RegisterBooks {

//Måste scapa fxml
/*
    public void clickAdd(ActionEvent actionEvent){//Lägga till button
        Scanner scTitle=new Scanner(title.getText().trim());
        Scanner scIsbn=new Scanner(isbn.getText().trim());
        Scanner scAuthor=new Scanner(author.getText().trim());
        Scanner scCategory=new Scanner(category.getText().trim());
        Scanner scLanguage=new Scanner(language.getText().trim());
        Scanner scDescription=new Scanner(description.getText().trim());
        Scanner scPublisher=new Scanner(publisher.getText().trim());
        Scanner scEdition=new Scanner(edition.getText().trim());
        Scanner scReleaseDate=new Scanner(releaseDate.getText().trim());
        Scanner scNumberOfPages=new Scanner(numberOfPages.getText().trim());
        Scanner scLocation=new Scanner(location.getText().trim());
        Scanner scNumberOfBooks=new Scanner(numberOfBooks.getText().trim()); //  Is it needed to add this idem now?

        if(scTitle.hasNext()&&scIsbn.hasNext()&& scAuthor.hasNext()&& scCategory.hasNext()&& scLanguage.hasNext()&& scDescription.hasNext()&&scPublisher.hasNext()&&scEdition.hasNext()&& scReleaseDate.hasNext()&& scNumberOfPages.hasNext()&& scLocation.hasNext()&&scNumberOfBooks.hasNext()) {
            try {
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("RegisteredBooks.txt", true))); // true: append info need to make a file

                pw.println(scTitle.hasNext() + "," + scIsbn.hasNext() + "," + scAuthor.hasNext() + "," + scCategory.hasNext() + "," + scLanguage.hasNext() + "," + scDescription.hasNext() + "," + scPublisher.hasNext() + "," + scEdition.hasNext() + "," + scReleaseDate.hasNext() + "," + scNumberOfPages.hasNext() + "," + scLocation.hasNext() + "," + scNumberOfBooks.hasNext());
                pw.close();

                message.setText(title.getText() + "is registered");// Javafx make a textbox with a name of message
                // remove text
                title.setText("");
                isbn.setText("");
                author.setText("");
                category.setText("");
                language.setText("");
                description.setText("");
                publisher.setText("");
                edition.setText("");
                releaseDate.setText("");
                numberOfPages.setText("");
                location.setText("");
                numberOfBooks.setText("");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
              message.setText("Du måste lägga alla information");// Javafx make a textbox with a name of message
        }
    }

 */


}
