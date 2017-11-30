package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Problem:
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 */
public class _015_3Sum {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 3) {
			return res;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int left = i + 1;
			int right = nums.length - 1;
			int target = -1 * nums[i];
			twoSum(nums, left, right, target, res);
		}
		return res;
	}

	private static void twoSum(int[] nums, int left, int right, int target, List<List<Integer>> res) {
		while (left < right) {
			if (nums[left] + nums[right] == target) {
				ArrayList<Integer> array = new ArrayList<>();
				// need to time -1
				array.add(target * (-1));
				array.add(nums[left]);
				array.add(nums[right]);
				res.add(array);
				left++;
				right--;
				// duplicate
				while (left < right && nums[left] == nums[left - 1]) {
					left++;
				}
				while (left < right && nums[right] == nums[right + 1]) {
					right--;
				}
			} else if (nums[left] + nums[right] > target) {
				right--;
			} else {
				left++;
			}
		}
	}
}