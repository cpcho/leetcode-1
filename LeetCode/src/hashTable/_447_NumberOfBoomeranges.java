package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Problem: Given n points in the plane that are all pairwise distinct, a
 * "boomerang" is a tuple of points (i, j, k) such that the distance between i
 * and j equals the distance between i and k (the order of the tuple matters).
 * 
 * Find the number of boomerangs. You may assume that n will be at most 500 and
 * coordinates of points are all in the range [-10000, 10000] (inclusive).
 * 
 * Example: Input: [[0,0],[1,0],[2,0]]
 * 
 * Output: 2
 * 
 * Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and
 * [[1,0],[2,0],[0,0]]
 *
 */
public class _447_NumberOfBoomeranges {
	public int numberOfBoomerangs(int[][] points) {
		if (points == null || points.length == 0) {
			return 0;
		}
		int res = 0;
		for (int i = 0; i < points.length; i++) {
			//distance -> count
			Map<Integer, Integer> map = new HashMap<>();
			for (int j = 0; j < points.length; j++) {
				if (i == j) {
					continue;
				}
				int dis = getDistance(points[i], points[j]);
				map.put(dis, map.getOrDefault(dis, 0) + 1);
			}

			for (int val : map.values()) {
				res += val * (val - 1);
			}
		}
		return res;
	}

	private int getDistance(int[] p1, int[] p2) {
		int x = p1[0] - p2[0];
		int y = p1[1] - p2[1];
		return x * x + y * y;
	}
}
