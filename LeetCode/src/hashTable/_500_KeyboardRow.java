package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Problem: Given a List of words, return the words that can be typed using
 * letters of alphabet on only one row's of American keyboard like the image
 * below.
 *
 * Example 1: Input: ["Hello", "Alaska", "Dad", "Peace"]
 * 
 * Output: ["Alaska", "Dad"] Note: You may use one character in the keyboard
 * more than once. You may assume the input string will only contain letters of
 * alphabet.
 *
 */
public class _500_KeyboardRow {
	public String[] findWords(String[] words) {
		if (words == null || words.length == 0) {
			return new String[0];
		}
		String[] str = { "qwertyuiop", "asdfghjkl", "zxcvbnm" };
		List<String> res = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length; i++) {
			for (char c : str[i].toCharArray()) {
				map.put(c, i);
			}
		}
		for (String s : words) {
			if (s == null || s.length() == 0) {
				continue;
			}
			char[] ch = s.toLowerCase().toCharArray();
			int row = map.get(ch[0]);
			for (char c : ch) {
				if (row != map.get(c)) {
					row = -1;
					break;
				}
			}
			if (row != -1) {
				res.add(s);
			}
		}
		return res.toArray(new String[res.size()]);
	}
}
