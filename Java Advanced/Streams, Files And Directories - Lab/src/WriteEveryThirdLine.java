import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args){

        String path = System.getProperty("user.dir") + "/res/input.txt";
        String output = System.getProperty("user.dir") + "/res/05.WriteEveryThirdLineOutput.txt";
        try (BufferedReader read =new BufferedReader(new FileReader(path));
             BufferedWriter writer = new BufferedWriter(new PrintWriter(output))){

            int count = 1;

            String input;

            while((input=read.readLine())!=null){

                if (count%3==0){
                    writer.write(input);
                    writer.newLine();
                }
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
