import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializeArrayList {
    public static void main(String[] args) {

        ArrayList<String> namesList = new ArrayList<>();

        namesList.add("test1");
        namesList.add("test2");
        namesList.add("test3");

        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir")+"/res/list.ser"));
            oos.writeObject(namesList);
            oos.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
