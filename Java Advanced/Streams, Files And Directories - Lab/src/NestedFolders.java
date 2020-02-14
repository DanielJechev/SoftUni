import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) {

        String path = System.getProperty("user.dir") + "/Files-and-Streams";

        File root = new File(path);

        Deque<File> dirs = new ArrayDeque<>();

        dirs.offer(root);

        int count = 0;

        while (!dirs.isEmpty()) {

            File current = dirs.poll();

            File[] nestedFiles = current.listFiles();

            assert nestedFiles != null;
            for (File nestedFile : nestedFiles)

                if (nestedFile.isDirectory())

                    dirs.offer(nestedFile);

            count++;

            System.out.println(current.getName());

        }

        System.out.println(count + " folders");

    }
}
