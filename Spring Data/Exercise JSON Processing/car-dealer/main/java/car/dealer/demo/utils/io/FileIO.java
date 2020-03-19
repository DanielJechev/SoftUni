package car.dealer.demo.utils.io;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileIO {

    public String read (String fileName) throws IOException {
        StringBuilder builder = new StringBuilder();
        InputStream inputStream = this.getClass().getResourceAsStream(fileName);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                //Log here..
            }
        }

        return builder.toString();
    }

    public void write (String content, String fileName) throws IOException {
        OutputStream outputStream = new FileOutputStream(fileName);
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(content);
            writer.flush();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                //log here...
            }
        }
    }
}
