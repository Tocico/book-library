package Model;

import java.util.ArrayList;
import java.util.List;

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
    private List<History> histories;

    public UserTest(String name, String ssn, String passwd, boolean isStaff) {
        this.name = name;
        this.ssn = ssn;
        this.passwd = passwd;
        this.isStaff = isStaff;
        this.histories = new ArrayList<>();
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

    public void addHistory(History history) {
        histories.add(history);
    }

    public List<History> getHistories() {
        return histories;
    }
}
