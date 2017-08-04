package greedy;

import java.util.Arrays;

/**
 * 
 * Problem: There are N children standing in a line. Each child is assigned a
 * rating value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors. What is the minimum candies you must give?
 *
 */
public class _135_Candy {
	/**
	 * Solution: two array. two for loops
	 * 
	 * Time Complexity: O(N)
	 * 
	 * Space Complexity: O(N)
	 */
	public int candy1(int[] ratings) {
		int len = ratings.length;
		int[] left2right = new int[len];
		int[] right2left = new int[len];
		Arrays.fill(left2right, 1);
		Arrays.fill(right2left, 1);
		for (int i = 0; i < len - 1; i++) {
			if (ratings[i] < ratings[i + 1]) {
				left2right[i + 1] = left2right[i] + 1;
			}
		}
		for (int i = len - 2; i >= 0; i--) {
			if (ratings[i + 1] < ratings[i]) {
				right2left[i] = right2left[i + 1] + 1;
			}
		}

		System.out.println(Arrays.toString(left2right));

		System.out.println(Arrays.toString(right2left));
		int res = 0;
		for (int i = 0; i < len; i++) {
			res += Math.max(left2right[i], right2left[i]);
		}
		return res;
	}

	/**
	 * Solution: one array. two for loops
	 * 
	 * Time Complexity: O(N)
	 * 
	 * Space Complexity: O(N)
	 */
	public int candy2(int[] ratings) {
		int len = ratings.length;
		int[] max = new int[len];
		Arrays.fill(max, 1);
		for (int i = 0; i < len - 1; i++) {
			if (ratings[i] < ratings[i + 1]) {
				max[i + 1] = max[i] + 1;
			}
		}
		for (int i = len - 2; i >= 0; i--) {
			if (ratings[i + 1] < ratings[i]) {
				max[i] = Math.max(max[i], max[i + 1] + 1);
			}
		}

		int res = 0;
		for (int i = 0; i < len; i++) {
			res += max[i];
		}
		return res;
	}

	/**
	 * Solution: Peak and valley
	 * 
	 * Time Complexity: O(N)
	 * 
	 * Space Complexity: O(1)
	 */
	private int count(int n) {
		return (n * (n + 1)) / 2;
	}

	public int candy3(int[] ratings) {
		if (ratings.length <= 1) {
			return ratings.length;
		}
		int candies = 0;
		int up = 0;
		int down = 0;
		int old_slope = 0;
		for (int i = 1; i < ratings.length; i++) {
			int new_slope = (ratings[i] > ratings[i - 1]) ? 1 : (ratings[i] < ratings[i - 1] ? -1 : 0);
			if ((old_slope > 0 && new_slope == 0) || (old_slope < 0 && new_slope >= 0)) {
				candies += count(up) + count(down) + Math.max(up, down);
				up = 0;
				down = 0;
			}
			if (new_slope > 0)
				up++;
			if (new_slope < 0)
				down++;
			if (new_slope == 0)
				candies++;

			old_slope = new_slope;
		}
		candies += count(up) + count(down) + Math.max(up, down) + 1;
		return candies;
	}
}
