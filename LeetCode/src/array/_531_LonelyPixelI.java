package array;

/**
 * 
 * Problem:
 * 
 * Given a picture consisting of black and white pixels, find the number of
 * black lonely pixels.
 * 
 * The picture is represented by a 2D char array consisting of 'B' and 'W',
 * which means black and white pixels respectively.
 * 
 * A black lonely pixel is character 'B' that located at a specific position
 * where the same row and same column don't have any other black pixels.
 * 
 * Example: Input: [['W', 'W', 'B'], ['W', 'B', 'W'], ['B', 'W', 'W']]
 * 
 * Output: 3 Explanation: All the three 'B's are black lonely pixels. Note: The
 * range of width and height of the input 2D array is [1,500].
 *
 */
public class _531_LonelyPixelI {
	public int findLonelyPixel(char[][] picture) {
		if (picture == null) {
			return 0;
		}
		int res = 0;
		int rows = picture.length;
		int cols = picture[0].length;
		int[] rowCount = new int[rows];
		int[] colCount = new int[cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (picture[i][j] == 'B') {
					rowCount[i]++;
					colCount[j]++;
				}
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (picture[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1) {
					res++;
				}
			}
		}
		return res;
	}
}
