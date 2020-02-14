import java.io.*;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        String pathFileOne = System.getProperty("user.dir")+"/res/inputOne.txt";
        String pathFileTwo = System.getProperty("user.dir")+"/res/inputTwo.txt";

        BufferedReader read = new BufferedReader(new FileReader(pathFileOne));
        BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir")+"/res/MergeTwoFilesOutput.txt"));

        String line;

        while ((line = read.readLine())!=null){
            writer.write(line);
            writer.newLine();
            writer.flush();
        }

        read = new BufferedReader(new FileReader(pathFileTwo));

        while ((line = read.readLine())!=null){
            writer.append(line);
            writer.newLine();
            writer.flush();
        }

    }
}
