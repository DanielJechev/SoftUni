import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"/res/image.jpg");

        ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(System.getProperty("user.dir")+"/res/image.zip"));

        outputStream.putNextEntry(new ZipEntry("image.jpg"));

        outputStream.write(inputStream.readAllBytes());

        outputStream.close();

    }
}
