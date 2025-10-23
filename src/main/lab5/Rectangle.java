package lab5;

public class Rectangle {
	Point A;
	Point B;
	Point C;
	Point D;

	public Rectangle(Point A, Point B, Point C, Point D) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.D = D;
	}
	
	public double perimeter() {
		return A.distance(B) + B.distance(C) + C.distance(D) + D.distance(A);
	}
	
	public boolean isRectangle() {
        Vec AB = Vec.of(A, B), BC = Vec.of(B, C), CD = Vec.of(C, D), AD = Vec.of(A, D);
        return isPerp(AB, BC) && isParallel(BC, AD) && isParallel(AB, CD);
    }

    public boolean isSquare() {
        if (!isRectangle()) return false;
        double ab = A.distance(B);
        double bc = B.distance(C);
        double cd = C.distance(D);
        double da = D.distance(A);
        return almostEq(ab, bc) && almostEq(bc, cd) && almostEq(cd, da);
    }
}
