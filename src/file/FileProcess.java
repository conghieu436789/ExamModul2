package file;

import java.io.*;

public class FileProcess {
    public static Object getFile(String filepath) {
        try {
            File file = new File(filepath);
            if (file.length()>0) {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                Object obj = objectIn.readObject();
                objectIn.close();
                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public static void writeFile(Object serObj, String path) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
            output.writeObject(serObj);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
