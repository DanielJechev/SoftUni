import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> items = new LinkedHashMap<>();
        Map<String, Integer> junk = new TreeMap<>();

        items.put("shards", 0);
        items.put("fragments", 0);
        items.put("motes", 0);

        String data = read.readLine();

        try {
            while (!data.equals("")) {
                List<String> input = Arrays.stream(data.toLowerCase().split("\\s+")).filter(e -> !e.equals(" ")).collect(Collectors.toList());
                boolean isMax = false;

                for (int i = 0; i < input.size(); i += 2) {

                    int count = Integer.parseInt(input.get(i));
                    String element = input.get(i + 1);

                    if (items.get("shards") >= 250 || items.get("fragments") >= 250 || items.get("motes") >= 250) {
                        isMax = true;
                        break;
                    }
                    switch (element) {
                        case "shards":
                            items.put("shards", items.get("shards") + count);
                            break;
                        case "fragments":
                            items.put("fragments", items.get("fragments") + count);
                            break;
                        case "motes":
                            items.put("motes", items.get("motes") + count);
                            break;
                        default:
                            junk.putIfAbsent(element, 0);
                            junk.put(element, junk.get(element) + count);
                            break;
                    }
                }
                if (isMax) {
                    break;
                }
                data = read.readLine();
            }

        } catch (Exception e) {
        }


        if (items.get("shards") >= 250) {
            items.put("shards", items.get("shards") - 250);
            System.out.println("Shadowmourne obtained!");
        } else if (items.get("fragments") >= 250) {
            items.put("fragments", items.get("fragments") - 250);
            System.out.println("Valanyr obtained!");
        } else {
            items.put("motes", items.get("motes") - 250);
            System.out.println("Dragonwrath obtained!");

        }


        items.entrySet().stream().sorted((e1, e2) -> {
            int com = e2.getValue().compareTo(e1.getValue());
            if (com == 0) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return com;
        }).forEach(e -> System.out.println(String.format("%s: %d", e.getKey(), e.getValue())));

        junk.forEach((key, value) -> System.out.println(String.format("%s: %d", key, value)));
    }
}