package Model.UserEntities;  /**
   * Created by Toshiko Kuno
   * Date: 2020-11-30
   * Time: 15:51
   * Project: IntelliJ IDEA
   * Copyright: MIT
   */ 
    
    
    
    public abstract class User {
        protected String firstName;
        protected String lastName;
        protected String sSN;
        protected String address;
        protected String email;
        protected String passwd;
        protected boolean isAdmin;

    public User(String firstName, String lastName, String sSN, String address, String email, String passwd, boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sSN = sSN;
        this.address = address;
        this.email = email;
        this.passwd = passwd;
        this.isAdmin = isAdmin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getsSN() {
        return sSN;
    }

    public void setsSN(String sSN) {
        this.sSN = sSN;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

}
