package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Problem: Given a pattern and a string str, find if str follows the same
 * pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 * 
 * Examples: 
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false. 
 * pattern = "aaaa", str = "dog cat cat dog" should return false. 
 * pattern = "abba", str = "dog dog dog dog" should return false. 
 * 
 * Notes: 
 * You may assume pattern contains
 * only lowercase letters, and str contains lowercase letters separated by 
 * a single space.
 *
 */
public class _290_WordPattern {
	public boolean wordPattern(String pattern, String str) {
		if (pattern == null || str == null) {
			return false;
		}
		String[] strs = str.split(" ");
		if (pattern.length() != strs.length) {
			return false;
		}
		Map<Character, String> map = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			char key = pattern.charAt(i);
			if (map.containsKey(key)) {
				if (!map.get(key).equals(strs[i])) {
					return false;
				}
			} else {
				// abba a and b should be different
				if (map.containsValue(strs[i])) {
					return false;
				}
				map.put(key, strs[i]);
			}
		}
		return true;
	}
}
