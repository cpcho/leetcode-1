package design;

import java.util.Iterator;
import java.util.List;

/**
 * 
 * Problem: Implement an iterator to flatten a 2d vector.
 * 
 * For example, Given 2d vector =
 * 
 * [ [1,2], [3], [4,5,6] ] By calling next repeatedly until hasNext returns
 * false, the order of elements returned by next should be: [1,2,3,4,5,6].
 *
 *
 */
public class _251_Flatten2DVector implements Iterator<Integer> {

	private Iterator<List<Integer>> iter1;
	private Iterator<Integer> iter2;

	public void Vector2D(List<List<Integer>> vec2d) {
		iter1 = vec2d.iterator();
	}

	@Override
	public Integer next() {
		helper();
		return iter2.next();
	}

	@Override
	public boolean hasNext() {
		helper();
		return iter2 != null && iter2.hasNext();
	}

	private void helper() {
		while ((iter2 == null || !iter2.hasNext()) && iter1.hasNext()) {
			iter2 = iter1.next().iterator();
		}
	}
}
