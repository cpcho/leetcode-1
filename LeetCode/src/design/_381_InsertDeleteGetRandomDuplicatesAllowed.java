package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 
 * Problem:
 * 
 * Design a data structure that supports all following operations in average
 * O(1) time.
 * 
 * Note: Duplicate elements are allowed. insert(val): Inserts an item val to the
 * collection. remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. The
 * probability of each element being returned is linearly related to the number
 * of same value the collection contains.
 *
 */
public class _381_InsertDeleteGetRandomDuplicatesAllowed {
	List<Integer> nums;
	// key: the inserted value, value: the indices in nums
	HashMap<Integer, Set<Integer>> map;
	Random rand = new Random();

	public _381_InsertDeleteGetRandomDuplicatesAllowed() {
		nums = new ArrayList<>();
		map = new HashMap<>();
	}

	public boolean insert(int val) {
		boolean contain = map.containsKey(val);
		if (!contain) {
			map.put(val, new HashSet<Integer>());
		}
		map.get(val).add(nums.size());
		nums.add(val);
		return !contain;
	}

	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		int numIndex = map.get(val).iterator().next();
		map.get(val).remove(numIndex);
		// not the last ele in arrayList
		// put last ele on the val's position
		if (numIndex < nums.size() - 1) {
			int lastNum = nums.get(nums.size() - 1);
			nums.set(numIndex, lastNum);
			map.get(lastNum).remove(nums.size() - 1);
			map.get(lastNum).add(numIndex);
		}
		// delete last one
		nums.remove(nums.size() - 1);
		if (map.get(val).isEmpty()) {
			map.remove(val);
		}
		return true;
	}

	public int getRandom() {
		return nums.get(rand.nextInt(nums.size()));
	}
}
