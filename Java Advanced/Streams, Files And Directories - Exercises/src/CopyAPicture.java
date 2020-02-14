import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyAPicture {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"/res/image.jpg");
        FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir")+"/res/copyImage.jpg");

        outputStream.write(inputStream.readAllBytes());

    }
}
