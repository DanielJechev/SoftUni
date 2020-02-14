import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {

        Path inPathWords = Path.of(System.getProperty("user.dir")+"/res/words.txt");
        Path inPathText = Path.of(System.getProperty("user.dir")+"/res/text.txt");

        Path pathOut = Path.of(System.getProperty("user.dir")+"/res/WordCountOutput.txt");

        try {
            List<String> words = Files.readAllLines(inPathWords);
            List<String> text = Files.readAllLines(inPathText);

            Set<String> clearWords = new HashSet<>(fillCollection(words));
            List<String> clearText = fillCollection(text);

            Map<String,Integer> counts = new LinkedHashMap<>();

            clearWords.forEach(e->counts.put(e,0));

            for (String word : clearText) {
                if (clearWords.contains(word)){
                    counts.put(word,counts.get(word)+1);
                }
            }

            BufferedWriter writer = Files.newBufferedWriter(pathOut);

            counts.entrySet().stream().sorted((e1,e2)->Integer.compare(e2.getValue(),e1.getValue()))
                    .forEach(e->{
                        String pattern = e.getKey()+" - "+e.getValue()+System.lineSeparator();
                        try {
                            writer.write(pattern);
                            writer.flush();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static List<String> fillCollection(List<String> strings) {

        List<String> words = new ArrayList<>();

        for (String string : strings) {
            String[] splitWord = string.split("\\s+");
            for (String element : splitWord) {
                if (element.endsWith(",") || element.endsWith(".") || element.endsWith("?") || element.endsWith("!")) {
                    words.add(element.substring(0, element.length() - 1));
                } else {
                    words.add(element);
                }
            }
        }
        return words;
    }
}
