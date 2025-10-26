package lab5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/*
 * This file is responsible for testing the Circle.java file
 *
 * Note that this file assumes Point.java's programs are correct
*/
class CircleTests {

    @Test
    void testConstructure1() {

        Point p = new Point(0, 0);
        Circle c = new Circle(p, 5);

        assertTrue(c.center.x == 0 && c.center.y == 0 && c.radius == 5);
    }

    @Test
    void testConstructure2() {

        Point p = new Point(3, -2);
        Circle c = new Circle(p, 5);

        assertTrue(c.center.x == 3 && c.center.y == -2 && c.radius == 5);
    }

    @Test
    void testConstructure3() {

        Point p = new Point(8, 0);
        Circle c = new Circle(p, 3);

        assertTrue(c.center.x == 8 && c.center.y == 0 && c.radius == 3);
    }

    @Test
    void testConstructure4() {

        Point p = null;
        Circle c = new Circle(p, -1);

        assertTrue(c.center == null && c.radius == -1);
    }

    @Test
    void testCircumference1() {

        Point p = new Point(0, 1);
        Circle c = new Circle(p, 3);

        assertTrue(c.circumference() == 6 * Math.PI);
    }

    @Test
    void testCircumference2() {

        Point p = new Point(-1, 1);
        Circle c = new Circle(p, 0);

        assertTrue(c.circumference() == 0);
    }

    @Test
    void testCircumference3() {

        Point p = new Point(3, -2);
        Circle c = new Circle(p, 9);

        assertTrue(c.circumference() == 18 * Math.PI);
    }

    @Test
    void testArea1() {

        Point p = new Point(0, 1);
        Circle c = new Circle(p, 3);

        assertTrue(c.area() == 9 * Math.PI);
    }

    @Test
    void testArea2() {

        Point p = new Point(-1, 1);
        Circle c = new Circle(p, 0);

        assertTrue(c.area() == 0);
    }

    @Test
    void testArea3() {

        Point p = new Point(3, -2);
        Circle c = new Circle(p, 9);

        assertTrue(c.area() == 81 * Math.PI);
    }
}
