package Client;

import DAO.HistoryDao;
import DAO.UserDao;
import Model.History;
import Model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toshiko Kuno
 * Date: 2020-12-04
 * Time: 08:30
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class UserUtil {
    public static UserDao userDao = new UserDao();
    public static HistoryDao historyDao = new HistoryDao();

    //Hämta ut alla användare list
    public static List<User> getUserList() {
        return userDao.getAll();
    }

    //Hämta ut den aktuella histori lista
    public static List<History> getLoggedInUserHistory(User loggedInUser) {
        List<History> histories = new ArrayList<>();
        for (History history : historyDao.getAll()) {
            if(history.getUser().equals(loggedInUser)) {
                histories.add(history);
            }
        }
        return histories;
    }

    //Hämta ut en användare
    public static User getUser(String ssn) {
        return userDao.getAll().stream()
                .filter(user -> user.getSsn().equals(ssn))
                .findFirst()
                .orElse(null);
    }

    public static void registerUser() {

        //userDao.save(user);
    }
}
