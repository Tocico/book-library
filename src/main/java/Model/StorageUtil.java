package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StorageUtil {
    String path;

    public StorageUtil(String dbName) throws FileNotFoundException, IOException {
        path = "data/" + dbName + ".ser";
        File file = new File(path);
        file.createNewFile();
    }

    public void serializeStoreList(List<?> list) throws IOException {
        FileOutputStream fileOutput = new FileOutputStream(path);
        ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
        System.out.println("Recieved:" + list);
        objOutput.writeObject(list);
        System.out.println("List serialization and store success!");
        objOutput.close();
        fileOutput.close();
    }

    public <T> List<T> deserializeReadList() throws ClassNotFoundException, IOException {
        FileInputStream fileInput = new FileInputStream(path);
        ObjectInputStream objInput = new ObjectInputStream(fileInput);
        List<T> list = (List<T>) objInput.readObject();
        System.out.println("List deserialization and read success!");
        objInput.close();
        fileInput.close();
        return list;
    }
}
