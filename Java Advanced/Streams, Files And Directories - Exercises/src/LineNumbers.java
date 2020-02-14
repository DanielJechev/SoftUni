import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) {

        Path pathIn = Paths.get(System.getProperty("user.dir")+"/res/inputLineNumbers.txt");
        Path pathOut = Paths.get(System.getProperty("user.dir")+"/res/outputLineNumbers.txt");

        try {
            List<String> lines = Files.readAllLines(pathIn);

            for (int i = 0; i < lines.size(); i++) {
                lines.set(i,i+1+". "+lines.get(i));
            }

            Files.write(pathOut,lines);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
