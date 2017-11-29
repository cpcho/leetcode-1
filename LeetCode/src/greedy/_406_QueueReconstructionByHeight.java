package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

/**
 * 
 * Problem:
 * 
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct the queue.
 * 
 * Note: The number of people is less than 1,100.
 * 
 * Example
 * 
 * Input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 * Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * Solution:
 * 
 * pick up the tallest guy first when insert the next tall guy, just need to
 * insert him into kth position repeat until all people are inserted into list
 *
 */
public class _406_QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0]) {
					return a[1] - b[1];
				} else {
					return b[0] - a[0];
				}
			}
		});
		List<int[]> res = new ArrayList<>();
		for (int[] p : people) {
			res.add(p[1], p);
		}
		return res.toArray(new int[people.length][]);
	}
}
