import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CountCharacterTypes {
    public static void main(String[] args) {

        Path pathIn = Paths.get(System.getProperty("user.dir") + "/res/input.txt");

        Map<String, Integer> counts = new LinkedHashMap<>();

        counts.put("Vowels", 0);
        counts.put("Consonants", 0);
        counts.put("Punctuation", 0);

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'o', 'u', 'i'));
        Set<Character> punctuations = new HashSet<>(Arrays.asList('!','?','.',','));

        System.out.println();

        try {
            List<String> lines = Files.readAllLines(pathIn);

            for (String text : lines) {
                for (int j = 0; j < text.length(); j++) {
                    if (vowels.contains(text.charAt(j))) {
                        counts.put("Vowels", counts.get("Vowels") + 1);
                    } else if (punctuations.contains(text.charAt(j))) {
                        counts.put("Punctuation", counts.get("Punctuation") + 1);
                    } else if (text.charAt(j) != ' ') {
                        counts.put("Consonants", counts.get("Consonants") + 1);
                    }
                }
            }

            BufferedWriter writer = new BufferedWriter
                    (new FileWriter(System.getProperty("user.dir") + "/res/CountCharacterTypeOutput.txt"));

            writer.write(
                    "Vowels: " + counts.get("Vowels") + System.lineSeparator()
                    + "Consonants: " + counts.get("Consonants") + System.lineSeparator()
                    + "Punctuation: " + counts.get("Punctuation"));
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
