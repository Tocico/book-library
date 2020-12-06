package Model;

import java.io.*;
import java.util.List;

public class StorageUtil {
    FileOutputStream fileOutput;
    ObjectOutputStream objOutput;
    FileInputStream fileInput;
    ObjectInputStream objInput;
    String path;

    public StorageUtil(String dbName) throws FileNotFoundException, IOException {
        path = "..Data/" + dbName + ".ser";
        fileOutput = new FileOutputStream(path);
        objOutput = new ObjectOutputStream(fileOutput);
        fileInput = new FileInputStream(path);
        objInput = new ObjectInputStream(fileInput);
    }

    public void serializeStoreObj(Object obj) throws IOException {
        objOutput.writeObject(obj);
        objOutput.close();
        fileOutput.close();
        System.out.println("Object serialization and store success!");
    }

    public void serializeStoreList(List list) throws IOException {
        objOutput.writeObject(list);
        objOutput.close();
        fileOutput.close();
        System.out.println("List serialization and store success!");
    }

    public Object deserializeReadObj() throws ClassNotFoundException, IOException {
        Object readObject = objInput.readObject();
        objInput.close();
        fileInput.close();
        System.out.println("Object deserialization and read success!");
        return readObject;
    }

    public Object deserializeReadList() throws ClassNotFoundException, IOException {
        List readList = (List) objInput.readObject();
        objInput.close();
        fileInput.close();
        System.out.println("List deserialization and read success!");
        return readList;
    }

}
