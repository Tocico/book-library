package Model;

import java.io.*;

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

    public void serializeStore(Object obj) throws IOException {
        objOutput.writeObject(obj);
        objOutput.close();
        fileOutput.close();
        System.out.println("Serialization and store success!");
    }

    public Object deserializeRead() throws ClassNotFoundException, IOException {
        Object readData = objInput.readObject();
        objInput.close();
        fileInput.close();
        System.out.println("Deserialization and read success!");
        return readData;
    }

}
