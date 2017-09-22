package array;

/**
 * 
 * Problem:
 * 
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2
 * 
 * 3,2,1 → 1,2,3
 * 
 * 1,1,5 → 1,5,1
 *
 */
public class _031_NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		int i;
		for (i = nums.length - 1; i >= 1; i--) {
			if (nums[i] > nums[i - 1]) { // find first number which is smaller
				break;
			}
		}
		if (i != 0) {
			swap(nums, i - 1); // if the number exist,which means that the nums
								// not like{5,4,3,2,1}
		}
		reverse(nums, i);
	}

	private void swap(int[] nums, int i) {
		for (int j = nums.length - 1; j > i; j--) {
			if (nums[j] > nums[i]) {
				int tmp = nums[j];
				nums[j] = nums[i];
				nums[i] = tmp;
				break;
			}
		}
	}

	// reverse the subarray after i
	private void reverse(int[] nums, int i) {
		int first = i;
		int last = nums.length - 1;
		while (first < last) {
			int tmp = nums[first];
			nums[first] = nums[last];
			nums[last] = tmp;
			first++;
			last--;
		}
	}
}
