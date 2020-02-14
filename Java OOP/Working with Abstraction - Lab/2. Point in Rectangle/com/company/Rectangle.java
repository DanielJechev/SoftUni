package com.company;

public class Rectangle {
    private Point bottomLeft;
    private  Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }
    public  boolean contains(Point point){
        boolean checkX=point.getCordinateX()>=this.bottomLeft.getCordinateX()&&point.getCordinateX()<=this.topRight.getCordinateX();
        boolean checkY=point.getCordinateY()>=this.bottomLeft.getCordinateY()&&point.getCordinateY()<=this.topRight.getCordinateY();
        return checkX&&checkY;
    }
}
