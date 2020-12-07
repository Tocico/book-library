package DAO;

import Model.UserEntities.Employee;
import Model.UserEntities.User;
import Model.UserEntities.Visitor;

import java.io.IOException;
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
        userList.add(new Employee("Toshiko", "Kuno", "8811072886", "Enskede", "kuno@gmail.com", "1111", true));
        userList.add(new Employee("Miwa", "", "0000000000", "", "miwa@gmail.com", "2222",true));
        userList.add(new Visitor("Yohannes", "", "1111111111", "", "yohannes@gmail.com", "3333" ,false));
        userList.add(new Visitor("Maxim", "", "2222222222", "", "maxim@gmail.com", "4444", false));
    }
    

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public void saveAll() throws IOException {

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
