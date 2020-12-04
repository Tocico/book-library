package Model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class StorageUtil {
    public StorageUtil(String path) throws IOException {
        FileWriter dbWrite = new FileWriter(path);
        FileReader dbRead = new FileReader(path);
    }

    public String selectFrom(Integer index, String where) {
        return "";
        //new JSONArray();

    }

    public void insertTo(Integer index, String where) {

    }

    public void createEntry(Object obj) {

    }

    public void deleteEntry(String where) {


    }


}
