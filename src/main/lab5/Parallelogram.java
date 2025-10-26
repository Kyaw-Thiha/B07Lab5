package lab5;

public class Parallelogram {
  Point A;
  Point B;
  Point C;
  Point D;

  public Parallelogram(Point A, Point B, Point C, Point D) {
    this.A = A;
    this.B = B;
    this.C = C;
    this.D = D;
  }

  public double perimeter() {
    double side1 = A.distance(B);
    double side2 = B.distance(C);
    return 2 * (side1 + side2);
  }

  public double area() {
    double ABx = B.x - A.x;
    double ABy = B.y - A.y;
    double ADx = D.x - A.x;
    double ADy = D.y - A.y;

    return Math.abs(ABx * ADy - ABy * ADx);
  }
}
