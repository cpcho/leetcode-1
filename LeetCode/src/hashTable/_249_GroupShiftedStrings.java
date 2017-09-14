package hashTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Problem: Given a string, we can "shift" each of its letter to its successive
 * letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the
 * sequence:
 * 
 * "abc" -> "bcd" -> ... -> "xyz" Given a list of strings which contains only
 * lowercase alphabets, group all strings that belong to the same shifting
 * sequence.
 * 
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], A
 * solution is:
 * 
 * [ ["abc","bcd","xyz"], ["az","ba"], ["acef"], ["a","z"] ]
 *
 */
public class _249_GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
		if (strings == null || strings.length == 0) {
			return new ArrayList<List<String>>();
		}
		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < strings.length; i++) {
			String key = shift(strings[i]);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(strings[i]);
		}
		for (String key : map.keySet()) {
			Collections.sort(map.get(key));
		}
		return new ArrayList<List<String>>(map.values());
	}

	private String shift(String s) {
		char[] chars = s.toCharArray();
		int offset = chars[0] - 'a';
		for (int i = 0; i < chars.length; i++) {
			char cur = (char) (chars[i] - offset);
			if (cur < 'a') {
				chars[i] = (char) (cur + 26);
			} else {
				chars[i] = cur;
			}
		}
		return new String(chars);
	}
}
