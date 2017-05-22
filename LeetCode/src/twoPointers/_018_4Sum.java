package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Problem: Given an array S of n integers, are there elements a, b, c, and d in
 * S such that a + b + c + d = target? Find all unique quadruplets in the array
 * which gives the sum of target.
 * 
 * Note: The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 * 
 * 
 * Algorithm:
 *
 * Time Complexity:
 *
 * Space Complexity:
 *
 */
public class _018_4Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 4) {
			return res;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			// duplicates
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 2; j++) {
				// duplicates
				if (j != i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int sum = target - nums[i] - nums[j];
				int start = j + 1;
				List<Integer> list = new ArrayList<>();
				list.add(nums[i]);
				list.add(nums[j]);
				twoSum(res, list, nums, sum, start);
			}
		}
		return res;
	}

	private void twoSum(List<List<Integer>> res, List<Integer> list1, int[] nums, int sum, int left) {
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] == sum) {
				// new array , there might be multiple results
				List<Integer> list = new ArrayList<>(list1);
				list.add(nums[left]);
				list.add(nums[right]);
				res.add(list);
				left++;
				right--;
				// duplicates in array
				while (left < right && nums[left - 1] == nums[left]) {
					left++;
				}
				while (left < right && nums[right] == nums[right + 1]) {
					right--;
				}
			} else if (nums[left] + nums[right] < sum) {
				left++;
			} else {
				right--;
			}
		}
	}
}