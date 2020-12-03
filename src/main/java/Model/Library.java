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


/*
    public Library(int libraryID, String libraryName, String location, String libraryAddress, String libraryPhone, String libraryEmail) {
        this.libraryID = libraryID;
        this.libraryName = libraryName;
        this.location = location; //Stockholm, Huddinge,
        this.libraryAddress = libraryAddress;
        this.libraryPhone = libraryPhone;
        this.libraryEmail = libraryEmail;
    }
 */

    public int getLibraryID() {
        return libraryID;
    }

    public Library setLibraryID(int libraryID) {
        this.libraryID = libraryID;
        return this;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public Library setLibraryName(String libraryName) {
        this.libraryName = libraryName;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Library setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getLibraryAddress() {
        return libraryAddress;
    }

    public Library setLibraryAddress(String libraryAddress) {
        this.libraryAddress = libraryAddress;
        return this;
    }

    public String getLibraryPhone() {
        return libraryPhone;
    }

    public Library setLibraryPhone(String libraryPhone) {
        this.libraryPhone = libraryPhone;
        return this;
    }

    public String getLibraryEmail() {
        return libraryEmail;
    }

    public Library setLibraryEmail(String libraryEmail) {
        this.libraryEmail = libraryEmail;
        return this;
    }
}
