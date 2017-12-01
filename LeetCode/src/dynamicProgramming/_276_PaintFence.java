package dynamicProgramming;

/**
 * 
 * Problem:
 * 
 * There is a fence with n posts, each post can be painted with one of the k
 * colors.
 * 
 * You have to paint all the posts such that no more than two adjacent fence
 * posts have the same color.
 * 
 * Return the total number of ways you can paint the fence.
 * 
 * Note: n and k are non-negative integers.
 *
 */
public class _276_PaintFence {
	public class Solution {
		public int numWays(int n, int k) {
			if (n == 0) {
				return 0;
			}
			if (n == 1) {
				return k;
			}
			int diffColor = k * (k - 1);
			int sameColor = k;
			for (int i = 2; i < n; i++) {
				int tmp = diffColor;
				diffColor = (diffColor + sameColor) * (k - 1);
				sameColor = tmp;
			}
			return diffColor + sameColor;
		}
	}
}