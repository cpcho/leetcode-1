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
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * For example:
 * 
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0, and to take course 0 you should also have
 * finished course 1. So it is impossible.
 * 
 * Note: The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented. You may
 * assume that there are no duplicate edges in the input prerequisites.
 * 
 * Algorithm:
 * 1. put all the courses do not have any pre in the queue.
 * 2. every course uses a list to store all the courses that take the cur course as a pre.
 * 3. when a course is finished, the indegree of the pointed courses should minus 1
 * 4. If there is any circle in the graph, the count will not equal to numCourses.
 *
 * Time Complexity:
 *
 * Space Complexity:
 */

public class _207_Coursechedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// indegree means the number of prerequisites
		int[] indegree = new int[numCourses];
		List[] edges = new ArrayList[numCourses];
   		for (int i = 0; i < numCourses; i++) {
			edges[i] = new ArrayList<Integer>();
		}
		// initialize indegree
		// initialize edges
		for (int i = 0; i < prerequisites.length; i++) {
			indegree[prerequisites[i][0]]++;
			edges[prerequisites[i][1]].add(prerequisites[i][0]);
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
			count++;
			int edgeNum = edges[cur].size();
			for (int i = 0; i < edgeNum; i++) {
				int pointer = (int) edges[cur].get(i);
				indegree[pointer]--;
				if (indegree[pointer] == 0) {
					queue.add(pointer);
				}
			}
		}
		return count == numCourses;
	}
}