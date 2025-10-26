package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParallelogramTests {

  @Test
  void testConstructor() {
    Point pointA = new Point(0, 0);
    Point pointB = new Point(4, 0);
    Point pointC = new Point(6, 3);
    Point pointD = new Point(2, 3);

    Parallelogram p = new Parallelogram(pointA, pointB, pointC, pointD);

    assertEquals(0.0, p.A.x);
    assertEquals(4.0, p.B.x);
    assertEquals(6.0, p.C.x);
    assertEquals(2.0, p.D.x);
  }

  @Test
  void testPerimeter_TiltedParallelogram() {
    Point pointA = new Point(0, 0);
    Point pointB = new Point(4, 0);
    Point pointC = new Point(5, 3);
    Point pointD = new Point(1, 3);

    Parallelogram p = new Parallelogram(pointA, pointB, pointC, pointD);
    double perimeter = p.perimeter();

    double expected = 2 * (pointA.distance(pointB) + pointB.distance(pointC)); // 2 * (4 + sqrt(10))
    assertEquals(expected, perimeter, 1e-9);
  }

  @Test
  void testPerimeter_Rectangle() {
    Point pointA = new Point(0, 0);
    Point pointB = new Point(4, 0);
    Point pointC = new Point(4, 3);
    Point pointD = new Point(0, 3);

    Parallelogram p = new Parallelogram(pointA, pointB, pointC, pointD);
    double perimeter = p.perimeter();

    assertEquals(14.0, perimeter, 1e-9);
  }

  @Test
  void testArea_Rectangle() {
    Point pointA = new Point(0, 0);
    Point pointB = new Point(4, 0);
    Point pointC = new Point(4, 3);
    Point pointD = new Point(0, 3);

    Parallelogram p = new Parallelogram(pointA, pointB, pointC, pointD);
    double area = p.area();

    assertEquals(12.0, area, 1e-9);
  }
}
