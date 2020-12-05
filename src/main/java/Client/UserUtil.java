package Client;

import DAO.UserDao;
import Model.History;
import Model.User;

import java.util.List;

/**
 * Created by Toshiko Kuno
 * Date: 2020-12-04
 * Time: 08:30
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class UserUtil {

    //Hämta ut alla användare list
    public static List<User> getUserList() {
        return new UserDao().getAll();
    }

    //Hämta ut den aktuella histori lista
    public static List<History> getLoggedInUserHistory(User loggedInUser) {
        List<User> userList = getUserList();

        return userList.stream()
                .filter(user -> user.getSsn().equals(loggedInUser.getSsn()))
                .map(user -> user.getHistories())
                .findFirst()
                .orElse(null);
    }
}
