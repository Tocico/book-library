package Model;

/**
 * Created by Toshiko Kuno
 * Date: 2020-11-30
 * Time: 15:51
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class UserTest {
    private String name;
    private String ssn;
    private String passwd;
    private boolean isStaff;

    public UserTest(String name, String ssn, String passwd, boolean isStaff) {
        this.name = name;
        this.ssn = ssn;
        this.passwd = passwd;
        this.isStaff = isStaff;
    }

    public String getName() {
        return name;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getSsn() {
        return ssn;
    }

    public boolean isStaff() {
        return isStaff;
    }
}
