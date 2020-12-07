package DAO;

import Client.BookUtil;
import Client.UserUtil;
import Model.History;
import Model.StorageUtil;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toshiko Kuno
 * Date: 2020-12-05
 * Time: 10:39
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class HistoryDao implements Dao<History> {

    //Spara data som hämtar från textfil i lista
    private List<History> historyList = new ArrayList<>();
    private StorageUtil db;

    //Hämta data från textfil?
    public HistoryDao() {

            //Throw dummy elements
            historyList.add(new History(UserUtil.getUser("8811072886"),
                    BookUtil.getBook("123434"),
                    LocalDate.of(2020, 12, 01),
                    LocalDate.of(2020, 12, 13)));
            historyList.add(new History(UserUtil.getUser("8811072886"),
                    BookUtil.getBook("32343"),
                    LocalDate.of(2020, 12, 05),
                    LocalDate.of(2020, 12, 17)));
            historyList.add(new History(UserUtil.getUser("8811072886"),
                    BookUtil.getBook("32343"),
                    LocalDate.of(2020, 12, 05),
                    LocalDate.of(2020, 12, 17)));
            historyList.add(new History(UserUtil.getUser("8811072886"),
                    BookUtil.getBook("32343"),
                    LocalDate.of(2020, 12, 05),
                    LocalDate.of(2020, 12, 17)));


            try {
                db = new StorageUtil("history");
                //saveAll();
                historyList = getAll(); //Overwrite current history list with the fetched deserialized data

                System.out.println("Loaded data" + historyList);
            } catch (ClassNotFoundException | IOException e) {
                System.out.println("Error: " + e.getMessage());
            }

            //Iteration tests
            for (Object e : historyList) {
                if(e instanceof History) {
                    System.out.println("Element: " + ((History) e).getBook().getAuthor());
                }
            }
    }

    @Override
    public List<History> getAll() throws IOException, ClassNotFoundException {
        return db.deserializeReadList();
    }

    @Override
    public void saveAll() throws IOException{
        db.serializeStoreList(historyList);
    }

    //Register history
    @Override
    public void save(History history) throws IOException{
        historyList.add(history);
        //TODO: Updatera db? Deserialize?
    }

    //Update history
    @Override
    public void update(History history) {
        historyList.get(historyList.indexOf(history));
        //TODO: Updatera db? Deserialize?
    }

    //Remove history
    @Override
    public void delete(History history) {
        historyList.remove(historyList.indexOf(history));
        //TODO: Updatera db? Deserialize?
    }

}
