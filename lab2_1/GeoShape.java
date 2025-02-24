class GeoShape {
    protected double dim1, dim2;

    public GeoShape(double dim1, double dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    public double getArea() {
        return 0; 
    }

 
    public static double sumAreas(GeoShape s1, GeoShape s2, GeoShape s3) {
        return s1.getArea() + s2.getArea() + s3.getArea();
    }
}


class Rectangle extends GeoShape {
    public Rectangle(double width, double height) {
        super(width, height);
    }


    public double getArea() {
        return dim1 * dim2; 
    }
}

class Triangle extends GeoShape {
    public Triangle(double base, double height) {
        super(base, height);
    }

 
    public double getArea() {
        return 0.5 * dim1 * dim2; 
    }
}


class Circle extends GeoShape {
    public Circle(double radius) {
        super(radius, radius); 
    }

  
    public double getArea() {
        return 3.14 * dim1 * dim1; 
    }
}



public class Main {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 10);
        GeoShape tri = new Triangle(4, 6);
        GeoShape circ = new Circle(3);

        double totalArea = GeoShape.sumAreas(rect, tri, circ);

        System.out.println("Total Sum of Areas: " + totalArea);
    }
}