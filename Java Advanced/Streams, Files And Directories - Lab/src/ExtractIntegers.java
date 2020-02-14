import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {

        String path = System.getProperty("user.dir") + "/res/input.txt";
        String output = System.getProperty("user.dir") + "/res/04.ExtractIntegersOutput.txt";
        try(Scanner read = new Scanner(new FileReader(path)); PrintWriter writer = new PrintWriter(output)) {
            while (read.hasNext()){
                read.next();
                if (read.hasNextInt()){
                    writer.println(read.nextInt());
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}