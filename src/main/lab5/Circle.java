package lab5;

public class Circle {
    Point center;
    double radius;

    public Circle(Point c, double r) {
        this.center = c;
        this.radius = r;
    }

    public double circumference() {
        return 2 * (Math.PI) * this.radius;
    }

    public double area() {
        return (Math.PI) * Math.pow(radius, 2);
    }
}
