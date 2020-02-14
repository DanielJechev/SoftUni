import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {

        File file = new File(System.getProperty("user.dir") + "/res/Exercises Resources");

        File[] files = file.listFiles();

        long sum =0;

        if (files != null) {
            for (File f : files) {
                sum+=f.length();
            }
        }

        System.out.println("Folder size: "+sum);

    }
}
