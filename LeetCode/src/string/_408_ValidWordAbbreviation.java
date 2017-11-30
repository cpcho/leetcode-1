package string;

/**
 * 
 * Problem:
 * 
 * Given a non-empty string s and an abbreviation abbr, return whether the
 * string matches with the given abbreviation.
 * 
 * A string such as "word" contains only the following valid abbreviations:
 * 
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1",
 * "w1r1", "1o2", "2r1", "3d", "w3", "4"] Notice that only the above
 * abbreviations are valid abbreviations of the string "word". Any other string
 * is not a valid abbreviation of "word".
 * 
 * Note: Assume s contains only lowercase letters and abbr contains only
 * lowercase letters and digits.
 * 
 * Example 1: Given s = "internationalization", abbr = "i12iz4n":
 * 
 * Return true. Example 2: Given s = "apple", abbr = "a2e":
 * 
 * Return false.
 *
 */
public class _408_ValidWordAbbreviation {
	public boolean validWordAbbreviation(String word, String abbr) {
		if (word == null || abbr == null) {
			return false;
		}
		int index1 = 0;
		int index2 = 0;
		int count = 0;
		while (index1 < word.length() && index2 < abbr.length()) {
			if (word.charAt(index1) == abbr.charAt(index2)) {
				index1++;
				index2++;
				continue;
			}
			// "01" != "1"
			if (!Character.isDigit(abbr.charAt(index2)) || abbr.charAt(index2) == '0') {
				return false;
			}
			count = abbr.charAt(index2) - '0';
			index2++;
			while (index2 < abbr.length() && Character.isDigit(abbr.charAt(index2))) {
				count = count * 10 + abbr.charAt(index2) - '0';
				index2++;
			}
			index1 += count;
		}
		return index1 == word.length() && index2 == abbr.length();
	}
}
