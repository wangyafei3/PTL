package fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ReadAndWriteFile {

    public void writeToFile(String filename, Object object) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(filename));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (fos != null) {
                fos.close();
            }
        }


    }

    public Object readFromFile(String filename) throws IOException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Object object = null;
        try {
            fis = new FileInputStream(new File(filename));
            ois = new ObjectInputStream(fis);
            object = ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                ois.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return object;
    }
}
