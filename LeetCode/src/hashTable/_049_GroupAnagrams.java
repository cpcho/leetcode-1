package hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Problem:
 * 
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 
 * Return: [ ["ate", "eat","tea"], ["nat","tan"], ["bat"] ] Note: All inputs
 * will be in lower-case.
 *
 */
public class _049_GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList<List<String>>();
		}
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String s : strs) {
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String key = new String(chars);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(s);
		}
		for (String key : map.keySet()) {
			Collections.sort(map.get(key));
		}
		return new ArrayList<List<String>>(map.values());
	}
}
