package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem: 
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 *
 * [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * 
 */
public class _118_PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		if (numRows <= 0) {
			return res;
		}
		for (int i = 0; i < numRows; i++) {
			cur.add(0, 1);
			// left most and right most => 1
			for (int j = 1; j < cur.size() - 1; j++) {
				cur.set(j, cur.get(j) + cur.get(j + 1));
			}
			res.add(new ArrayList<Integer>(cur));
		}
		return res;
	}
}
