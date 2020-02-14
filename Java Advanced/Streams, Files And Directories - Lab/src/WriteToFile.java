import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {

        String path = System.getProperty("user.dir") + "/res/input.txt";
        String output = System.getProperty("user.dir") + "/res/02.WriteToFileOutput.txt";

        try (FileInputStream inputStream = new FileInputStream(path);FileOutputStream outputStream = new FileOutputStream(output)) {

            int oneByte = inputStream.read();

            while (oneByte>=0){

                if (oneByte!='!'&&oneByte!='?'&&oneByte!=','&&oneByte!='.'){
                    outputStream.write(oneByte);
                }

                oneByte=inputStream.read();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
