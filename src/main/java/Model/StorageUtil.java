package Model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StorageUtil {

    public StorageUtil(String path) throws IOException {
        FileWriter dbWrite = new FileWriter(path);
        FileReader dbRead = new FileReader(path);
    }

    public String selectWhere(String key) {
        return "";
        //new JSONArray();
    }

    public void insertWhere(String key) {

    }

}
