package Model.UserEntities;


import java.io.Serializable;

/**
   * Created by Toshiko Kuno
   * Date: 2020-11-30
   * Time: 15:52
   * Project: IntelliJ IDEA
   * Copyright: MIT
   */ 
    
    
    
    public class Visitor extends Users implements Serializable {

    public Visitor(String firstName, String lastName, String sSN, String address, String email, boolean isAdmin) {
        super(firstName, lastName, sSN, address, email, isAdmin);
    }


}
