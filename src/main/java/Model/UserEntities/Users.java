package Model.UserEntities;  /**
   * Created by Toshiko Kuno
   * Date: 2020-11-30
   * Time: 15:51
   * Project: IntelliJ IDEA
   * Copyright: MIT
   */ 
    
    
    
    public abstract class Users {
        protected String firstName;
        protected String lastName;
        protected String sSN;
        protected String address;
        protected String email;
        protected boolean isAdmin;

    public Users(String firstName, String lastName, String sSN, String address, String email, boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sSN = sSN;
        this.address = address;
        this.email = email;
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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

}
