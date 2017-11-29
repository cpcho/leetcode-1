package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * Problem:
 * 
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example, Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * Note: You may assume k is always valid, 1 ? k ? number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 */
public class _347_TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> list = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return list;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			int count = map.getOrDefault(num, 0);
			map.put(num, count + 1);
		}
		Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> map1, Map.Entry<Integer, Integer> map2) {
				return map2.getValue() - map1.getValue();
			}
		});
		// PriorityQueue<Map.Entry<Integer, Integer>> pq = new
		// PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
		pq.addAll(map.entrySet());
		while (k-- > 0 && !pq.isEmpty()) {
			Entry<Integer, Integer> m = pq.poll();
			// m.getValue() is Object
			list.add((Integer) m.getKey());
		}
		return list;
	}
}
