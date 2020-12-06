package DAO;

import Model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toshiko Kuno
 * Date: 2020-12-05
 * Time: 10:39
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class UserDao implements Dao<User> {

    //Spara data som hämtar från textfil i lista
    private List<User> userList = new ArrayList<>();

    //Hämta data från textfil?
    public UserDao() {
        /*------------------------TEST----------------------------------*/
        userList.add(new User("Toshiko", "8811072886", "1111", false));
        userList.add(new User("Miwa", "0000000000", "2222", true));
        userList.add(new User("Maxim", "1111111111", "3333", true));
        userList.add(new User("Yohannes", "2222222222", "4444", true));
    }
    

    @Override
    public List<User> getAll() {
        return userList;
    }

    //Register user
    @Override
    public void save(User user) {
        userList.add(user);
        //TODO: Updatera db? Deserialize?
    }

    //Update user
    @Override
    public void update(User user) {
        userList.get(userList.indexOf(user));
        //TODO: Updatera db? Deserialize?
    }

    //Remove user
    @Override
    public void delete(User user) {
        userList.remove(userList.indexOf(user));
        //TODO: Updatera db? Deserialize?
    }
}
