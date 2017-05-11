package bfs;

import java.util.*;

/**
 * 
 * Problem: Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
 * 
 * 
 * Algorithm: 
 *  1.use BFS to get all nodes, put them in a set
 *  2.use HashMap to code node
 *  3.for each node, copy neighbors
 *
 * Time Complexity: 
 *
 * Space Complexity:
 */

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	
	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}

public class _133_CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return node;
		}
		ArrayList<UndirectedGraphNode> nodes = getALlNodes(node);
		// copy nodes, store the old->new mapping information in a hash map
		HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
		for (UndirectedGraphNode n : nodes) {
			mapping.put(n, new UndirectedGraphNode(n.label));
		}
		// copy neighbors(edges)
		for (UndirectedGraphNode n : nodes) {
			UndirectedGraphNode newNode = mapping.get(n);
			for (UndirectedGraphNode neighbors : n.neighbors) {
				UndirectedGraphNode newNeighbor = mapping.get(neighbors);
				newNode.neighbors.add(newNeighbor);
			}
		}
		return mapping.get(node);
	}

	// use bfs to traverse the graph and get all nodes
	public ArrayList<UndirectedGraphNode> getALlNodes(UndirectedGraphNode node) {
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		Set<UndirectedGraphNode> set = new HashSet<>();
		queue.offer(node);
		set.add(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode head = queue.poll();
			for (UndirectedGraphNode neighbor : head.neighbors) {
				if (!set.contains(neighbor)) {
					queue.offer(neighbor);
					set.add(neighbor);
				}
			}
		}
		return new ArrayList<UndirectedGraphNode>(set);
	}
}