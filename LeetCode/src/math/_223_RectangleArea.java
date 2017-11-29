package math;

/**
 * 
 * Problem:
 * 
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * 
 * Each rectangle is defined by its bottom left corner and top right corner as
 * shown in the figure. Assume that the total area is never beyond the maximum
 * possible value of int.
 *
 */
public class _223_RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int area1 = (C - A) * (D - B);
		int area2 = (G - E) * (H - F);
		int left = Math.max(A, E);
		int right = Math.min(G, C);
		int bottom = Math.max(F, B);
		int top = Math.min(D, H);
		int overlap = 0;
		if (right > left && top > bottom) {
			overlap = (right - left) * (top - bottom);
		}
		return area1 + area2 - overlap;
	}
}
