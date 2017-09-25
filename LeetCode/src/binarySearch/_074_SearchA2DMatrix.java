package binarySearch;

/**
 * 
 * Problem:
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row. For example,
 * 
 * Consider the following matrix:
 * 
 * [ [1, 3, 5, 7],
 * 
 * [10, 11, 16, 20],
 * 
 * [23, 30, 34, 50] ]
 * 
 * Given target = 3, return true.
 *
 * Solution:Take it as one dimensional array
 * 
 * Time Complexity: O(log(M * N))
 * 
 */
public class _074_SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int start = 0;
		int end = rows * cols - 1;
		int mid = 0;
		int midVal = 0;
		while (start <= end) {
			mid = start + (end - start) / 2;
			midVal = matrix[mid / cols][mid % cols];
			if (midVal == target) {
				return true;
			} else if (midVal > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}
}
