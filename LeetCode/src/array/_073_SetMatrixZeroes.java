package array;

/**
 * 
 * Problem:
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * Follow up: Did you use extra space? A straight forward solution using O(mn)
 * space is probably a bad idea. A simple improvement uses O(m + n) space, but
 * still not the best solution. Could you devise a constant space solution?
 * 
 */
public class _073_SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		boolean firstCol = false;
		for (int i = 0; i < matrix.length; i++) {
			// only need to store the status of the fist column
			if (matrix[i][0] == 0) {
				firstCol = true;
			}
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		// use the state to set the whole matrix from bottom to top
		// should not from top to bottom
		// It can cause all the elements in the first row to be zero
		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[0].length - 1; j >= 1; j--) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
			if (firstCol) {
				matrix[i][0] = 0;
			}
		}
	}
}
