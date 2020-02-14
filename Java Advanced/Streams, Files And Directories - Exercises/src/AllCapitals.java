import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AllCapitals {
    public static void main(String[] args) {

        Path pathIn = Paths.get(System.getProperty("user.dir")+"/res/input.txt");
        Path pathOut = Paths.get(System.getProperty("user.dir")+"/res/outputAllCapitals.txt");

        try {
            List<String> strings = Files.readAllLines(pathIn);

            for (int i = 0; i < strings.size(); i++) {
                strings.set(i,strings.get(i).toUpperCase());
            }

            Files.write(pathOut,strings);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
