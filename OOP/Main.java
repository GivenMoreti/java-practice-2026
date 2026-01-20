package OOP;
public class Main{
    public static void main(String[] args) {

        Shape line = new Line(2);
        line.draw();

        Shape square = new Polygon(4);
        square.draw();

        Shape circle = new Ellipse(4,2,2);
        circle.draw();
    }
}

abstract class Shape{
    public abstract   void draw();
    int points;
    public Shape(int points){
        this.points = points;
    }

}

class Polygon extends Shape{

    public Polygon(int points){
        super(points);
    }
    @Override
    public void draw() {
        System.out.println("drawing a polygon");
    }
}

class Ellipse extends Shape{
    int radY,radX;// for a circle rad-x and rad-y are equal

    public Ellipse(int points,int radY,int radX){
        super(points);
        this.radY = radY;
        this.radX = radX;
    }

    public void draw(){
        System.out.println("drawing an ellipse");
    }
}

class Line extends  Shape{
    public Line(int points){
        super(points);
    }

    public void draw(){
        System.out.println("drawing a line");
    }
}