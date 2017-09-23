package dfs;

/**
 * 
 * Problem:
 * 
 * Follow up for H-Index: What if the citations array is sorted in ascending
 * order? Could you optimize your algorithm?
 *
 */
public class _275_HIndexII {
	public int hIndex(int[] citations) {
		int len = citations.length;
		int left = 0;
		int right = len - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (citations[mid] == len - mid) {
				return len - mid;
			} else if (citations[mid] < len - mid) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return len - left;
	}
}
