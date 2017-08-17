package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * Problem: You are given two integer arrays nums1 and nums2 sorted in ascending
 * order and an integer k.
 * 
 * Define a pair (u,v) which consists of one element from the first array and
 * one element from the second array.
 * 
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * 
 * Example 1: Given nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 
 * Return: [1,2],[1,4],[1,6]
 * 
 * The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 *
 */
public class _373_FindKPairsWithSmallestSums {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

		List<int[]> res = new ArrayList<>();
		if (nums1.length == 0 || nums2.length == 0 || k == 0) {
			return res;
		}
		// Min-Heap int[]{e1, e2, e3}
		Queue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
		// all eles in nums1 and smallest ele in nums2
		for (int i = 0; i < nums1.length && i < k; i++) {
			heap.offer(new int[] { nums1[i], nums2[0], 0 });
		}
		while (k-- > 0 && !heap.isEmpty()) {
			int[] cur = heap.poll();
			res.add(new int[] { cur[0], cur[1] });
			if (cur[2] == nums2.length - 1) {
				heap.offer(new int[] { cur[0], nums2[cur[2] + 1], cur[2] + 1 });
			}
		}
		return res;
	}
}
