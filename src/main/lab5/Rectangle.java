package lab5;

public class Rectangle {
    Point A;
    Point B;
    Point C;
    Point D;

    // Small tolerance to forgive floating-point rounding errors.
    private static final double EPS = 1e-6;

    public Rectangle(Point A, Point B, Point C, Point D) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
    }

    /** Returns the total length of all four sides. */
    public double perimeter() {
        return A.distance(B) + B.distance(C) + C.distance(D) + D.distance(A);
    }

    /**
     * Returns true if the four points form a rectangle.
     * We require:
     *   1) AB is perpendicular to BC (a right corner at B)
     *   2) AB is parallel and equal in length to CD
     *   3) BC is parallel and equal in length to AD
     */
    public boolean isRectangle() {
        double ab2 = len2(A, B);
        double bc2 = len2(B, C);
        double cd2 = len2(C, D);
        double da2 = len2(D, A);

        // If any edge has (almost) zero length, it cannot be a rectangle.
        if (almostZero(ab2) || almostZero(bc2) || almostZero(cd2) || almostZero(da2)) {
            return false;
        }

        boolean rightAngle = isPerp(A, B, B, C);
        boolean oppSides1 = isParallel(A, B, C, D) && almostEq(ab2, cd2);
        boolean oppSides2 = isParallel(B, C, D, A) && almostEq(bc2, da2);

        return rightAngle && oppSides1 && oppSides2;
    }

    /**
     * Returns true if it is a rectangle and the two neighboring sides
     * are equal in length (which makes it a square).
     */
    public boolean isSquare() {
        if (!isRectangle()) return false;
        double ab2 = len2(A, B);
        double bc2 = len2(B, C);
        return almostEq(ab2, bc2);
    }

    // ----------------- Small, local math helpers -----------------

    /** Squared length of segment PQ. Using squared length avoids extra sqrt calls. */
    private static double len2(Point P, Point Q) {
        double dx = Q.x - P.x;
        double dy = Q.y - P.y;
        return dx * dx + dy * dy;
    }

    /** Dot product of vectors (P1->P2) · (Q1->Q2). */
    private static double dot(Point P1, Point P2, Point Q1, Point Q2) {
        double ux = P2.x - P1.x, uy = P2.y - P1.y;
        double vx = Q2.x - Q1.x, vy = Q2.y - Q1.y;
        return ux * vx + uy * vy;
    }

    /**
     * 2D cross product (as a scalar) of vectors (P1->P2) × (Q1->Q2).
     * If this value is near zero, the vectors are nearly parallel.
     */
    private static double cross(Point P1, Point P2, Point Q1, Point Q2) {
        double ux = P2.x - P1.x, uy = P2.y - P1.y;
        double vx = Q2.x - Q1.x, vy = Q2.y - Q1.y;
        return ux * vy - uy * vx;
    }

    /** True if the two segments are (almost) parallel. */
    private static boolean isParallel(Point P1, Point P2, Point Q1, Point Q2) {
        return almostZero(cross(P1, P2, Q1, Q2));
    }

    /** True if the two segments are (almost) perpendicular. */
    private static boolean isPerp(Point P1, Point P2, Point Q1, Point Q2) {
        return almostZero(dot(P1, P2, Q1, Q2));
    }

    /** Treats tiny values as zero. */
    private static boolean almostZero(double v) {
        return Math.abs(v) <= EPS;
    }

    /**
     * “Almost equal” for doubles using a relative check.
     * This is safer than comparing with == because of rounding noise.
     */
    private static boolean almostEq(double a, double b) {
        double diff = Math.abs(a - b);
        double scale = Math.max(1.0, Math.max(Math.abs(a), Math.abs(b)));
        return diff <= EPS * scale;
    }
}
