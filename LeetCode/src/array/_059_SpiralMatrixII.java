package array;

/**
 * 
 * Problem:
 * 
 * Given an integer n, generate res square matrix filled with elements from 1 to
 * n2 in spiral order.
 * 
 * For example, Given n = 3,
 * 
 * You should return the following matrix:
 * 
 * [[ 1, 2, 3 ],
 * 
 * [ 8, 9, 4 ],
 * 
 * [ 7, 6, 5] ]
 *
 * 
 */
public class _059_SpiralMatrixII {

	public int[][] generateMatrix(int n) {
		if (n == 1) {
			return new int[][] { { 1 } };
		}
		int rowStart = 0;
		int rowEnd = n - 1;
		int colStart = 0;
		int colEnd = n - 1;
		int num = 1;
		int[][] res = new int[n][n];
		while (rowStart <= rowEnd && colStart <= colEnd) {
			// go right
			for (int i = colStart; i <= colEnd; i++) {
				res[rowStart][i] = num++;
			}
			rowStart++;
			// go down
			for (int i = rowStart; i <= rowEnd; i++) {
				res[i][colEnd] = num++;
			}
			colEnd--;
			// go left
			if (rowStart <= rowEnd) {
				for (int i = colEnd; i >= colStart; i--) {
					res[rowEnd][i] = num++;
				}
				rowEnd--;
			}
			// go up
			if (colStart <= colEnd) {
				for (int i = rowEnd; i >= rowStart; i--) {
					res[i][colStart] = num++;
				}
				colStart++;
			}
		}
		return res;
	}
}
