package array;

/**
 * 
 * Problem: You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Note: You have to rotate the image in-place, which means you have to modify
 * the input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 *
 */
public class _048_RotateImage {
	public void rotate1(int[][] matrix) {
		// transpose
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[0].length; j++) {
				int temp = 0;
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		// flip horizontally
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length / 2; j++) {
				int temp = 0;
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
				matrix[i][matrix[0].length - 1 - j] = temp;
			}
		}
	}

	public void rotate2(int[][] matrix) {
		int len = matrix.length;
		for (int layer = 0; layer < len / 2; layer++) {
			int first = layer;
			int last = len - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i];
				// left -> top
				matrix[first][i] = matrix[last - offset][first];
				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];
				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				// top -> right
				matrix[i][last] = top;
			}
		}
	}
}
