package array;

/**
 * 
 * Problem:
 * 
 * Given two sparse matrices A and B, return the result of AB.
 * 
 * You may assume that A's column number is equal to B's row number.
 *
 */
public class _311_SparseMatrixMultiplication {
	public int[][] multiply(int[][] A, int[][] B) {
		int rowA = A.length;
		int colA = A[0].length;
		int colB = B[0].length;
		int[][] res = new int[rowA][colB];
		for (int i = 0; i < rowA; i++) {
			for (int j = 0; j < colA; j++) {
				if (A[i][j] != 0) {
					for (int k = 0; k < colB; k++) {
						if (B[j][k] != 0) {
							res[i][k] += A[i][j] * B[j][k];
						}
					}
				}
			}
		}
		return res;
	}
}
