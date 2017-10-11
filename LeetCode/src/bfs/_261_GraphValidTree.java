package bfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Problem: Given n nodes labeled from 0 to n - 1 and a list of undirected edges
 * (each edge is a pair of nodes), write a function to check whether these edges
 * make up a valid tree.
 * 
 * Notice: You can assume that no duplicate edges will appear in edges. Since
 * all edges are undirected, [0, 1] is the same as [1, 0] and thus will not
 * appear together in edges.
 * 
 * Example Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return
 * true.
 * 
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return
 * false.
 *
 * Solution: Graph: 1. n nodes and (n - 1) edges; 2. all nodes are connected.
 * --> Tree
 *
 */
public class _261_GraphValidTree {
	/**
	 * Method 1: BFS
	 */
	public boolean validTree1(int n, int[][] edges) {
		if (n == 0 || edges == null) {
			return false;
		}
		if (edges.length != n - 1) {
			return false;
		}
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new HashSet<Integer>());
		}
		for (int i = 0; i < edges.length; i++) {
			map.get(edges[i][0]).add(edges[i][1]);
			map.get(edges[i][1]).add(edges[i][0]);
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		HashSet<Integer> visited = new HashSet<>();
		visited.add(0);
		while (queue.size() > 0) {
			int p = queue.poll();
			for (int nei : map.get(p)) {
				if (visited.contains(nei)) {
					continue;
				}
				visited.add(nei);
				queue.add(nei);
			}
		}
		return visited.size() == n;
	}

	/**
	 * Method 2: Union Find
	 */
	public boolean validTree2(int n, int[][] edges) {
		int[] nums = new int[n];
		Arrays.fill(nums, -1);
		for (int i = 0; i < edges.length; i++) {
			int x = find(nums, edges[i][0]);
			int y = find(nums, edges[i][1]);
			// there's a cycle
			if (x == y) {
				return false;
			}
			// union
			nums[x] = y;
		}
		return edges.length == n - 1;
	}

	private int find(int nums[], int i) {
		if (nums[i] == -1) {
			return i;
		}
		nums[i] = find(nums, nums[i]);
		return nums[i];
	}
}
