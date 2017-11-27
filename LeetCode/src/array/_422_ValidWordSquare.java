package array;

import java.util.List;

/**
 * Problem:
 * 
 * Given a sequence of words, check whether it forms a valid word square.
 * 
 * A sequence of words forms a valid word square if the kth row and column read
 * the exact same string, where 0 ≤ k < max(numRows, numColumns).
 * 
 * Note: The number of words given is at least 1 and does not exceed 500. Word
 * length will be at least 1 and does not exceed 500. Each word contains only
 * lowercase English alphabet a-z. Example 1:
 * 
 * Input: [ "abcd", "bnrt", "crmy", "dtye" ]
 * 
 * Output: true
 * 
 * Explanation: The first row and first column both read "abcd". The second row
 * and second column both read "bnrt". The third row and third column both read
 * "crmy". The fourth row and fourth column both read "dtye".
 * 
 * Therefore, it is a valid word square. Example 2:
 * 
 * Input: [ "abcd", "bnrt", "crm", "dt" ]
 * 
 * Output: true
 * 
 * Explanation: The first row and first column both read "abcd". The second row
 * and second column both read "bnrt". The third row and third column both read
 * "crm". The fourth row and fourth column both read "dt".
 * 
 * Therefore, it is a valid word square.
 *
 */
public class _422_ValidWordSquare {
	public boolean validWordSquare(List<String> words) {
		if (words.size() == 0) {
			return true;
		}
		int len = words.size();
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < words.get(i).length(); j++) {
				if (j >= len || i >= words.get(j).length() || words.get(j).charAt(i) != words.get(i).charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
}
