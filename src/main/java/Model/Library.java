package Model;  /**
   * Created by Toshiko Kuno
   * Date: 2020-11-30
   * Time: 15:52
   * Project: IntelliJ IDEA
   * Copyright: MIT
   */ 
    
    // I made Section also( Which should we use???)
    
    public class Library {
        protected int libraryID;
        protected String libraryName;
        protected String location;
        protected String libraryAddress;
        protected String libraryPhone;
        protected String libraryEmail;


        // for example,  make a constructor with most useful variables??
     //May be it is
    public Library(int libraryID, String libraryName, String location, String libraryAddress, String libraryPhone, String libraryEmail) {
        this.libraryID = libraryID;
        this.libraryName = libraryName;
        this.location = location; //Stockholm, Huddinge,
        this.libraryAddress = libraryAddress;
        this.libraryPhone = libraryPhone;
        this.libraryEmail = libraryEmail;
    }

    public int getLibraryID() {
        return libraryID;
    }

    public void setLibraryID(int libraryID) {
        this.libraryID = libraryID;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLibraryAddress() {
        return libraryAddress;
    }

    public void setLibraryAddress(String libraryAddress) {
        this.libraryAddress = libraryAddress;
    }

    public String getLibraryPhone() {
        return libraryPhone;
    }

    public void setLibraryPhone(String libraryPhone) {
        this.libraryPhone = libraryPhone;
    }

    public String getLibraryEmail() {
        return libraryEmail;
    }

    public void setLibraryEmail(String libraryEmail) {
        this.libraryEmail = libraryEmail;
    }
}
