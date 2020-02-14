import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeCustomObject {
    public static class Course implements Serializable {
        private String name;
        private int count;

        public Course(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }
    }
    public static void main(String[] args) {

        String path = System.getProperty("user.dir")+"/res/course.ser";
        Course course = new Course("test",1);

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path));
            outputStream.writeObject(course);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
