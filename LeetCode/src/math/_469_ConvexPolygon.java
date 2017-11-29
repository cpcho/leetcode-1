package math;

import java.util.List;

/**
 * 
 * Problem:
 * 
 * Given a list of points that form a polygon when joined sequentially, find if
 * this polygon is convex (Convex polygon definition).
 * 
 * Note:
 * 
 * There are at least 3 and at most 10,000 points. Coordinates are in the range
 * -10,000 to 10,000. You may assume the polygon formed by given points is
 * always a simple polygon (Simple polygon definition). In other words, we
 * ensure that exactly two edges intersect at each vertex, and that edges
 * otherwise don't intersect each other.
 *
 */
public class _469_ConvexPolygon {
	public boolean isConvex(List<List<Integer>> points) {
		// For each set of three adjacent points A, B, C, find the cross product
		// AB · BC. If the sign of
		// all the cross products is the same, the angles are all positive or
		// negative (depending on the
		// order in which we visit them) so the polygon is convex.
		boolean gotNegative = false;
		boolean gotPositive = false;
		int numPoints = points.size();
		int B, C;
		for (int A = 0; A < numPoints; A++) {
			// Trick to cal the last 3 points: n - 1, 0 and 1.
			B = (A + 1) % numPoints;
			C = (B + 1) % numPoints;

			int crossProduct = crossProductLength(points.get(A).get(0), points.get(A).get(1), points.get(B).get(0),
					points.get(B).get(1), points.get(C).get(0), points.get(C).get(1));
			if (crossProduct < 0) {
				gotNegative = true;
			} else if (crossProduct > 0) {
				gotPositive = true;
			}
			if (gotNegative && gotPositive)
				return false;
		}
		return true;
	}

	private int crossProductLength(int Ax, int Ay, int Bx, int By, int Cx, int Cy) {
		int BAx = Ax - Bx;
		int BAy = Ay - By;
		int BCx = Cx - Bx;
		int BCy = Cy - By;
		return (BAx * BCy - BAy * BCx);
	}
}
