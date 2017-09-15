package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Problem: Design and implement a TwoSum class. It should support the following
 * operations: add and find.
 * 
 * add - Add the number to an internal data structure. find - Find if there
 * exists any pair of numbers which sum is equal to the value.
 * 
 * For example, add(1); add(3); add(5); find(4) -> true find(7) -> false
 *
 */
public class _170_TwoSumIIIDataStructureDesign {
	private List<Integer> list;
	private Map<Integer, Integer> map;

	public _170_TwoSumIIIDataStructureDesign() {
		list = new ArrayList<Integer>();
		map = new HashMap<>();
	}

	public void add(int number) {
		if (!map.containsKey(number)) {
			map.put(number, 1);
			list.add(number);
		} else {
			map.put(number, map.get(number) + 1);
		}
	}

	public boolean find(int value) {
		for (int i = 0; i < list.size(); i++) {
			int num1 = list.get(i);
			int num2 = value - num1;
			if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) {
				return true;
			}
		}
		return false;
	}
}
