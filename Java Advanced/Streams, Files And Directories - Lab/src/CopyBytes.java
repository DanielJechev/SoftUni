import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyBytes {
    public static void main(String[] args) {

        String path = System.getProperty("user.dir") + "/res/input.txt";
        String output = System.getProperty("user.dir") + "/res/03.CopyBytesOutput.txt";

        try (BufferedReader read = Files.newBufferedReader(Path.of(path));FileOutputStream outputStream = new FileOutputStream(output)){

            int oneByte = read.read();

            while (oneByte>=0){

                if (oneByte==10||oneByte==32){
                    outputStream.write(oneByte);
                }else {
                    String text = String.valueOf(oneByte);
                    for (int i = 0; i < text.length(); i++) {
                        outputStream.write(text.charAt(i));
                    }
                }

                oneByte = read.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
