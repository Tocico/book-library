package DAO;

import Client.BookUtil;
import Client.UserUtil;
import Model.History;

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

    //Hämta data från textfil?
    public HistoryDao() {
        historyList.add(new History(UserUtil.getUser("8811072886"),
                        BookUtil.getBook("123434"),
                        LocalDate.of(2020, 12, 01),
                        LocalDate.of(2020, 12, 13)));
                historyList.add(new History(UserUtil.getUser("8811072886"),
                        BookUtil.getBook("32343"),
                        LocalDate.of(2020, 12, 05),
                        LocalDate.of(2020, 12, 17)));

    }

    @Override
    public List<History> getAll() {
        return historyList;
    }

    //Register history
    @Override
    public void save(History history) {
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
