package Client;

import DAO.HistoryDao;
import DAO.UserDao;
import Model.History;
import Model.UserEntities.Employee;
import Model.UserEntities.User;
import Model.UserEntities.Visitor;

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
                .filter(user -> user.getsSN().equals(ssn))
                .findFirst()
                .orElse(null);
    }

    public static void registerUser(String firstName, String lastName, String sSN,String passwd, String tel, String address, String email, String userCategory) {
        User user;
        if(userCategory.equalsIgnoreCase("Visitor")) {
            user = new Visitor(firstName,lastName,sSN,address,email,passwd, tel,false);
        }else {
            user = new Employee(firstName,lastName,sSN,address,email,passwd, tel,true);
        }

        userDao.save(user);
    }
}
