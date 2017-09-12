package bfs;

import java.util.*;

/**
 * 
 * Problem: There are a total of n courses you have to take, labeled from 0 to n
 * - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. If
 * it is impossible to finish all courses, return an empty array.
 * 
 * For example:
 * 
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So the correct course order is [0,1]
 * 
 * 4, [[1,0],[2,0],[3,1],[3,2]] There are a total of 4 courses to take. To take
 * course 3 you should have finished both courses 1 and 2. Both courses 1 and 2
 * should be taken after you finished course 0. So one correct course order is
 * [0,1,2,3]. Another correct ordering is[0,2,1,3].
 * 
 * Note: The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented. You may
 * assume that there are no duplicate edges in the input prerequisites.
 * 
 */
class _210_CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];
		// indegree means the number of prerequisites
		int[] indegree = new int[numCourses];
		List<List<Integer>> edges = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			edges.add(new ArrayList<Integer>());
		}
		// initialize indegree
		// initialize edges
		for (int i = 0; i < prerequisites.length; i++) {
			indegree[prerequisites[i][0]]++;
			edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		// bfs
		// indegree=0 means the course doesn't have any pre
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		int count = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			// finish the course
			res[count++] = cur;
			int edgeNum = edges.get(cur).size();
			for (int i = 0; i < edgeNum; i++) {
				int pointer = (int) edges.get(cur).get(i);
				indegree[pointer]--;
				if (indegree[pointer] == 0) {
					queue.add(pointer);
				}
			}
		}
		if (count == numCourses) {
			return res;
		} else {
			return new int[0];
		}
	}
}