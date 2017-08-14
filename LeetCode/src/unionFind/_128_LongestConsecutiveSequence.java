package unionFind;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Problem: Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 *
 */
public class _128_LongestConsecutiveSequence {

	/**
	 * Method 1:HashMap<K,V>. Key: element, Value: current longest sequence.
	 * keep track of the current length of sequence in the most left and most
	 * right
	 * 
	 */
	public int longestConsecutive1(int[] nums) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums) {
			if (!map.containsKey(num)) {
				int left = (map.containsKey(num - 1)) ? map.get(num - 1) : 0;
				int right = (map.containsKey(num + 1)) ? map.get(num + 1) : 0;
				int count = left + 1 + right;
				res = Math.max(count, res);
				map.put(num, count);
				/**
				 * store the current length of sequence in the most left and
				 * most right {1, 2, 3, 4, 5}, map.get(1) and map.get(5) should
				 * both return 5.
				 */
				map.put(num - left, count);
				map.put(num + right, count);
			} else {
				continue;
			}
		}
		return res;

	}

	/**
	 * Method 2: union find
	 * 
	 */
	public int longestConsecutive2(int[] nums) {
		UnionFind uf = new UnionFind(nums.length);
		// Key: element, Value: index
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				continue;
			}
			map.put(nums[i], i);
			if (map.containsKey(nums[i] + 1)) {
				uf.union(i, map.get(nums[i] + 1));
			}
			if (map.containsKey(nums[i] - 1)) {
				uf.union(i, map.get(nums[i] - 1));
			}
		}
		return uf.max();
	}

	class UnionFind {
		// union find the indexes
		private int[] parent;

		UnionFind(int n) {
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
		}

		private int find(int node) {
			if (parent[node] == node) {
				return node;
			}
			// path compression
			parent[node] = find(parent[node]);
			return parent[node];
		}

		private void union(int node1, int node2) {
			int father1 = find(node1);
			int father2 = find(node2);
			if (father1 != father2) {
				parent[father1] = father2;
			}
		}

		public int max() {
			int[] count = new int[parent.length];
			int max = 0;
			for (int i = 0; i < parent.length; i++) {
				int root = find(i);
				count[root]++;
				max = Math.max(max, count[root]);
			}
			return max;
		}
	}
}
