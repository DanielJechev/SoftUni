import java.io.File;

public class ListFiles {
    public static void main(String[] args) {

        String path = System.getProperty("user.dir")+"/Files-and-Streams";

        File f = new File(path);

        File[] dirs = f.listFiles();

        if (dirs!=null){
            for (File file : dirs) {
                if (!file.isDirectory()){
                    System.out.println(String.format("%s: [%d]",file.getName(),file.length()));
                }
            }
        }

    }
}
