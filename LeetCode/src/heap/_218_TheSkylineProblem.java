package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * Problem:
 *
 * Solution: Sweep line + Max-Heap 
 * 1. sort the buildings 
 * 2. max-heap iteration
 * 
 */
public class _218_TheSkylineProblem {
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> res = new ArrayList<>();
		List<int[]> list = new ArrayList<>();
		for (int[] nums : buildings) {
			list.add(new int[] { nums[0], -nums[2] }); // start
			list.add(new int[] { nums[1], nums[2] }); // end
		}
		// Ascending order
		Collections.sort(list, (a, b) -> {
			if (a[0] != b[0]) {
				return a[0] - b[0];
			} else {
				return a[1] - b[1];
			}
		});
		// store the height, max-heap
		Queue<Integer> heap = new PriorityQueue<>((a, b) -> (b - a));
		heap.offer(0);
		int pre = 0;
		for (int[] height : list) {
			if (height[1] < 0) {
				heap.offer(-height[1]); // start
			} else {
				heap.remove(height[1]); // end
			}
			int cur = heap.peek();
			if (cur != pre) {
				res.add(new int[] { height[0], cur });
				pre = cur;
			}
		}
		return res;
	}
}
