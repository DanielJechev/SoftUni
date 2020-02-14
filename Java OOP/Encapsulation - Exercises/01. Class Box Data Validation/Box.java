package box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if (length<=0){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width<=0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height<=0){
            throw new IllegalArgumentException("Height cannot be zero or negative.");

        }

        this.height = height;
    }
    public double calculateSurfaceArea (){
       double surface=0;
       surface=(2*length*width) + (2*length*height) +( 2*width*height);
       return surface;
    }
    public double calculateLateralSurfaceArea (){
        double lateral=0;
        lateral=(2*length*height) + (2*width*height);
        return lateral;
    }
    public  double calculateVolume (){
        double volume=0;
        volume=length*width*height;
        return volume;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %f%nLateral Surface Area - %f%nVolume – %f",calculateSurfaceArea(),calculateLateralSurfaceArea(),calculateVolume());

    }
}
