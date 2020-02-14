import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeCustomObject {
    public static void main(String[] args) {

        String dir = System.getProperty("user.dir")+"/res/result.res";

        Cube cube = new Cube("green",15.3,12.4,3.0);

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(dir));) {
            outputStream.writeObject(cube);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static class Cube implements Serializable {
        private String color;
        private double width;
        private double height;
        private double depth;

        public Cube(String color ,double width,double height,double depth){
            this.color = color;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }

        public String getColor() {
            return color;
        }

        public double getWidth() {
            return width;
        }

        public double getHeight() {
            return height;
        }

        public double getDepth() {
            return depth;
        }
    }
}
