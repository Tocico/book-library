package Client;

import DAO.HistoryDao;
import DAO.UserDao;
import Model.History;
import Model.UserEntities.Employee;
import Model.UserEntities.User;
import Model.UserEntities.Visitor;

import java.io.IOException;
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

    public static void registerUser(String firstName, String lastName, String sSN,String passwd, String tel, String address, String email, String userCategory) throws IOException {
        User user;
        if(userCategory.equalsIgnoreCase("Visitor")) {
            user = new Visitor(firstName,lastName,sSN,address,email,passwd, tel,false);
        }else {
            user = new Employee(firstName,lastName,sSN,address,email,passwd, tel,true);
        }

        userDao.save(user);
    }
}
