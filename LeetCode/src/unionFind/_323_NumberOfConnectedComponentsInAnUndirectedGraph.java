package unionFind;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Problem: Given n nodes labeled from 0 to n - 1 and a list of undirected edges 
 * (each edge is a pair of nodes), write a function to find the number of connected 
 * components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] 
and thus will not appear together in edges.
 *
 */
public class _323_NumberOfConnectedComponentsInAnUndirectedGraph {
	// Union Find
	private int[] parent;

	private int find(int node) {
		if (parent[node] == node) {
			return node;
		}
		// path compassion
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

	public int countComponents(int n, int[][] edges) {
		Set<Integer> set = new HashSet<>();
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < edges.length; i++) {
			union(edges[i][0], edges[i][1]);
		}
		for (int i = 0; i < n; i++) {
			set.add(find(i));
		}
		return set.size();
	}
}
