package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RectangleTest {

	@Test
	void testPointConstructor() {
		 Point a = new Point(2,0);
		 Point b = new Point(3,0);
		 Point c = new Point(5,0);
		 Point d = new Point(4,0);
		 Rectangle r = new Rectangle(a,b,c,d);
		 assertEquals(2,r.A.x);
		 assertEquals(3,r.B.x);
		 assertEquals(5,r.C.x);
		 assertEquals(4,r.D.x);
	}
	
	@Test
	void testPerimeter() {
		 Point a = new Point(2,0);
		 Point b = new Point(3,0);
		 Point c = new Point(5,0);
		 Point d = new Point(4,0);
		 Rectangle r = new Rectangle(a,b,c,d);
		 double p = r.perimeter();
		 assertEquals(p,a.distance(b) + b.distance(c) + c.distance(d) + d.distance(a)); 
	}
	@Test
	void testisRectangleTrue() {
		Point a = new Point(0,0);
		Point b = new Point(4,0);
		Point c = new Point(4,3);
		Point d = new Point(0,3);
		Rectangle r = new Rectangle(a,b,c,d);
		assertTrue(r.isRectangle());
		
	}
	
	@Test
	void testisRectangleFalse() {
		Point a = new Point(0.1,0);
		Point b = new Point(0.2,0);
		Point c = new Point(0.3,0);
		Point d = new Point(0.1,0);
		Rectangle r = new Rectangle(a,b,c,d);
		assertFalse(r.isRectangle());
		
	}
	
	
	@Test
	void testisSquareFalse() {
		Point a = new Point(0,0);
		Point b = new Point(3,0);
		Point c = new Point(2,3);
		Point d = new Point(0,2);
		Rectangle r = new Rectangle(a,b,c,d);
		assertFalse(r.isSquare());
	}

	@Test
	void testisSquareTrue() {
		Point a = new Point(0,0);
		Point b = new Point(2,0);
		Point c = new Point(2,2);
		Point d = new Point(0,2);
		Rectangle r = new Rectangle(a,b,c,d);
		assertTrue(r.isSquare());
	}
	
	@Test 
	void testEqualTrue(){
		assertTrue(Rectangle.almostEq(5.0,5.0));
	}
	
	@Test 
	void testEqualFalse(){
		assertFalse(Rectangle.almostEq(5.0,5.1));
	}
	
	
	

}
