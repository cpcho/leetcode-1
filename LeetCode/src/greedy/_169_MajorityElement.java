package greedy;

/**
 * 
 * Problem:
 * 
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array
 *
 */
public class _169_MajorityElement {
	public int majorityElement(int[] nums) {
		int majority = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (majority == nums[i]) {
				count++;
			} else if (count == 0) {
				majority = nums[i];
			} else {
				count--;
			}
		}
		return majority;
	}
}
