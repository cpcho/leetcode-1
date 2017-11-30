package twoPointers;

/**
 * 
 * Problem:
 * 
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array nums = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, with the first five elements of nums
 * being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new
 * length.
 *
 */
public class _080_Remove_Duplicates_FromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		int k = 0;
		for (int num : nums) {
			if (k < 2 || nums[k - 2] < num) {
				nums[k++] = num;
			}
		}
		return k;
	}
}