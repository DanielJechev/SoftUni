import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {

        Path pathIn = Paths.get(System.getProperty("user.dir") + "/res/input.txt");
        Path pathOut = Paths.get(System.getProperty("user.dir") + "/res/06.SortLinesOutput.txt");

        List<String> text = Files.readAllLines(pathIn);

        Collections.sort(text);

        System.out.println();
        Files.write(pathOut,text);

    }
}
