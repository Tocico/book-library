package DAO;

import Client.BookUtil;
import Client.UserUtil;
import Model.Book;
import Model.History;
import Model.StorageUtil;
import Model.UserEntities.User;

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

        try {
        /*---------------- TEST --------------------*/
       /* historyList.add(new History().setUser(UserUtil.userDao.getById("8811072886"))
                .setBook(BookUtil.bookDao.getById("123434"))
                .setLendOutDate(LocalDate.of(2020, 12, 01))
                .setReturnDate(LocalDate.of(2020, 12, 13)));
        historyList.add(new History().setUser(UserUtil.userDao.getById("8811072886"))
                .setBook(BookUtil.bookDao.getById("32343"))
                .setLendOutDate(LocalDate.of(2020, 12, 05)));
        historyList.add(new History().setUser(UserUtil.userDao.getById("8811072886"))
                .setBook(BookUtil.bookDao.getById("22343"))
                .setLendOutDate(LocalDate.of(2020, 12, 05)));
        historyList.add(new History().setUser(UserUtil.userDao.getById("8811072886"))
                .setBook(BookUtil.bookDao.getById("32343"))
                .setLendOutDate(LocalDate.of(2020, 12, 05)));*/
        /*------------------------------------------*/
            db = new StorageUtil("history");
            //saveAll();
            historyList = getAll(); //Overwrite current history list with the fetched deserialized data

            System.out.println("Loaded data: " + historyList);
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public List<History> getAll() throws IOException, ClassNotFoundException {
        return db.deserializeReadList();
    }

    @Override
    public void saveAll() throws IOException {
        db.serializeStoreList(historyList);
    }

    //Register history
    @Override
    public void save(History history) throws IOException {
        historyList.add(history);
        saveAll();
    }

    //Update history
    @Override
    public void update(History history) throws IOException {
        historyList.get(historyList.indexOf(history));
        saveAll();
    }

    //Remove history
    @Override
    public void delete(History history) throws IOException {
        historyList.remove(historyList.indexOf(history));
        saveAll();
    }


    public History getByIdAndIsbn(String userSsn, String isbn) {
        for (Object e : historyList) {
            if (e instanceof History) {
                if(((History) e).getBook().getIsbn().equals(isbn) &&
                        ((History) e).getUser().getsSN().equals(userSsn)) return (History) e;
            }
        }
        return null;
    }

    public List<History> getHistoryList(String userSSN) {
        List<History> foundHistory = new ArrayList<>();
        for(Object e: historyList) {
            if (e instanceof History) {
                 if(((History) e).getUser().getsSN().equals(userSSN)) foundHistory.add((History) e);
            }
        }
        return foundHistory;
    }
}
