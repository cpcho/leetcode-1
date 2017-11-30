package string;

/**
 * 
 * Problem:
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P   A   H   N
 * 
 * A P L S I I G
 * 
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR" Write the code that will take a
 * string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should
 * return "PAHNAPLSIIGYIR".
 * 
 */
public class _006_ZigZagConversion {
	public String convert(String s, int numRows) {
		if (s == null || s.length() == 0 || numRows <= 0) {
			return "";
		}
		char[] c = s.toCharArray();
		int len = c.length;
		StringBuilder[] sbs = new StringBuilder[numRows];
		for (int i = 0; i < sbs.length; i++) {
			sbs[i] = new StringBuilder();
		}
		int i = 0;
		while (i < len) {
			// Vertically Down
			for (int j = 0; j < numRows && i < len; j++) {
				sbs[j].append(c[i++]);
			}
			// obliquely up
			for (int j = numRows - 2; j >= 1 && i < len; j--) {
				sbs[j].append(c[i++]);
			}
		}
		for (int j = 1; j < sbs.length; j++) {
			sbs[0].append(sbs[j]);
		}
		return sbs[0].toString();
	}
}
