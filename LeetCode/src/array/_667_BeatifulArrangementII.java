package array;

/**
 * 
 * Problem:
 *
 * Given two integers n and k, you need to construct a list which contains n
 * different positive integers ranging from 1 to n and obeys the following
 * requirement: Suppose this list is [a1, a2, a3, ... , an], then the list [|a1
 * - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct
 * integers.
 * 
 * If there are multiple answers, print any of them.
 * 
 * Example 1: Input: n = 3, k = 1 Output: [1, 2, 3] Explanation: The [1, 2, 3]
 * has three different positive integers ranging from 1 to 3, and the [1, 1] has
 * exactly 1 distinct integer: 1. Example 2: Input: n = 3, k = 2 Output: [1, 3,
 * 2] Explanation: The [1, 3, 2] has three different positive integers ranging
 * from 1 to 3, and the [2, 1] has exactly 2 distinct integers: 1 and 2. Note:
 * The n and k are in the range 1 <= k < n <= 104.
 * 
 * Solution:
 * 
 * As before, write {[1, 2, ..., n-k-1]}[1, 2, ..., n-k-1] first. The remaining
 * {k+1}k+1 elements to be written are {[n-k, n-k+1, ..., n]}[n-k, n-k+1, ...,
 * n], and we'll write them in alternating head and tail order.
 * 
 * When we are writing the i^{th}i ​th ​​ element from the remaining {k+1}k+1,
 * every even ii is going to be chosen from the head, and will have value {n-k +
 * i//2}n-k + i//2. Every odd ii is going to be chosen from the tail, and will
 * have value {n - i//2}n - i//2.
 * 
 */
public class _667_BeatifulArrangementII {
	public int[] constructArray(int n, int k) {
		int[] res = new int[n];
		int index = 0;
		for (int i = 1; i < n - k; i++) {
			res[index++] = i;
		}
		for (int i = 0; i <= k; i++) {
			res[index++] = (i % 2 == 0) ? (n - k + i / 2) : (n - i / 2);
		}
		return res;
	}
}
