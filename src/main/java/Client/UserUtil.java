package Client;

import Model.History;
import Model.User;
import Model.UserTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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
    public static List<UserTest> getUserList() {

    /*------------------------TEST----------------------------------*/
    List<UserTest> userList = new ArrayList<>();
    UserTest u1 = new UserTest("Toshiko", "8811072886", "1111", false);
    UserTest u2 = new UserTest("Miwa", "0000000000", "2222", false);
    UserTest u3 = new UserTest("Maxim", "1111111111", "3333", false);
    UserTest u4 = new UserTest("Yohannes", "2222222222", "4444", false);


    /**-----------------Test lägga History i UserTest klassen----------------------**/
    LocalDate lendOutDay = LocalDate.now();
    LocalDate returnDay = lendOutDay.plusDays(14); //Efter 2 veckor

       History h1 = new History(u1, BookUtil.getBook("123434"), returnDay, lendOutDay);
       History h2 = new History(u1, BookUtil.getBook("32343"), returnDay, lendOutDay);

        u1.addHistory(h1);
        u1.addHistory(h2);


    /*----------------------------------------------------------------*/

        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);

        return userList;
    }

    //Hämta ut den aktuella histori lista
    public static List<History> getLoggedInUserHistory(UserTest loggedInUser) {
        List<UserTest> userList = getUserList();

        return userList.stream()
                .filter(user -> user.getSsn().equals(loggedInUser.getSsn()))
                .map(user -> user.getHistories())
                .findFirst()
                .orElse(null);
    }
}
