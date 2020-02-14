import java.io.*;
import java.math.BigInteger;

public class SumBytes {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir")+"/res/input.txt";

        try(BufferedReader read =new BufferedReader(new FileReader(path))) {

            String line;

            BigInteger sum = new BigInteger(String.valueOf(0));

            while((line=read.readLine())!=null){

                for (char ch : line.toCharArray()) {
                    sum = sum.add(BigInteger.valueOf(ch));
                }

            }

            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
