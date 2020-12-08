package DAO;

import Model.StorageUtil;
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
    private StorageUtil db;

    //Hämta data från textfil?
    public UserDao() {

        /*------------------------TEST----------------------------------*/
        userList.add(new Employee("Toshiko", "Kuno", "8811072886", "Enskede", "kuno@gmail.com", "1111", "11111111", false));
        userList.add(new Employee("Miwa", "", "0000000000", "", "miwa@gmail.com", "2222","11111111",true));
        userList.add(new Visitor("Yohannes", "", "1111111111", "", "yohannes@gmail.com", "3333" ,"11111111",false));
        userList.add(new Visitor("Maxim", "", "2222222222", "", "maxim@gmail.com", "4444", "11111111",true));
        /*------------------------------------------*/

        try {
            db = new StorageUtil("users");
            saveAll();
            userList = getAll(); //Overwrite current history list with the fetched deserialized data
            System.out.println("Loaded data" + userList);
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    @Override
    public List<User> getAll() throws IOException, ClassNotFoundException {
        return db.deserializeReadList();
    }

    @Override
    public void saveAll() throws IOException {
        db.serializeStoreList(userList);
    }

    //Register user
    @Override
    public void save(User user) throws IOException {
        userList.add(user);
        saveAll();
    }

    //Update user
    @Override
    public void update(User user) throws IOException {
        userList.get(userList.indexOf(user));
        saveAll();
    }

    //Remove user
    @Override
    public void delete(User user) throws IOException {
        userList.remove(userList.indexOf(user));
        saveAll();
    }

    public User getById(String id) {
        for (Object e : userList) {
            if (e instanceof User) {
                if(((User) e).getsSN().equals(id)) return (User) e;
            }
        }
        return null;
    }

    public List<User> getByName(String name) {
        List<User> foundUsers = new ArrayList<>();
        for (Object e : userList) {
            if (e instanceof User) {
                if((((User) e).getFirstName() + " " + ((User) e).getFirstName()).equals(name)) foundUsers.add((User) e);
            }
        }
        return foundUsers;
    }
}
