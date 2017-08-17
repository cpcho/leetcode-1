package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * Problem: Given a string, sort it in decreasing order based on the frequency
 * of characters.
 * 
 * Example 1:
 * 
 * Input: "tree"
 * 
 * Output: "eert"
 * 
 * Explanation: 'e' appears twice while 'r' and 't' both appear once. So 'e'
 * must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 */
public class _451_SortCharactersByFrequency {
	public String frequencySort(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			int count = map.getOrDefault(c, 0);
			map.put(c, count + 1);
		}
		Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		pq.addAll(map.entrySet());
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Map.Entry e = pq.poll();
			for (int i = 0; i < (int) e.getValue(); i++) {
				sb.append(e.getKey());
			}
		}
		return sb.toString();
	}
}
