import java.io.*;

public class SumLines {
    public static void main(String[] args) {

        String path = System.getProperty("user.dir")+"/res/input.txt";

        try (BufferedReader read =new BufferedReader(new FileReader(path))){
            String line;

            while((line=read.readLine())!=null){

                long sum = 0;

                for (int i = 0; i < line.length(); i++) {
                    sum+=line.charAt(i);
                }
                System.out.println(sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
