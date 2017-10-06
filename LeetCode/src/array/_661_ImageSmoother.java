package array;

/**
 * 
 * Problem:
 *
 * Given a 2D integer matrix M representing the gray scale of an image, you need
 * to design a smoother to make the gray scale of each cell becomes the average
 * gray scale (rounding down) of all the 8 surrounding cells and itself. If a
 * cell has less than 8 surrounding cells, then use as many as you can.
 *
 */
public class _661_ImageSmoother {
	public int[][] imageSmoother(int[][] M) {
		int[] nei = { -1, 0, 1 };
		if (M == null || M.length == 0) {
			return new int[0][0];
		}
		int rows = M.length;
		int cols = M[0].length;
		int[][] res = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int curSum = 0;
				int curCount = 0;
				for (int k = 0; k < nei.length; k++) {
					for (int l = 0; l < nei.length; l++) {
						int newRow = i + nei[k];
						int newCol = j + nei[l];
						if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
							curSum += M[newRow][newCol];
							curCount++;
						}
					}
				}
				res[i][j] = curSum / curCount;
			}
		}
		return res;
	}
}
