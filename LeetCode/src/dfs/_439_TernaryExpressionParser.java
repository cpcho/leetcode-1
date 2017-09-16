package dfs;

/**
 * 
 * Problem:
 * 
 * Given a string representing arbitrarily nested ternary expressions, calculate
 * the result of the expression. You can always assume that the given expression
 * is valid and only consists of digits 0-9, ?, :, T and F (T and F represent
 * True and False respectively).
 * 
 * Note:
 * 
 * The length of the given string is ≤ 10000. Each number will contain only one
 * digit. The conditional expressions group right-to-left (as usual in most
 * languages). The condition will always be either T or F. That is, the
 * condition will never be a digit. The result of the expression will always
 * evaluate to either a digit 0-9, T or F.
 *
 */
public class _439_TernaryExpressionParser {
	public String parseTernary(String expression) {
		if (expression == null || expression.length() == 0) {
			return expression;
		}
		char[] ch = expression.toCharArray();
		return dfs(ch, 0, ch.length - 1) + "";
	}

	private char dfs(char[] c, int start, int end) {
		if (start == end) {
			return c[start];
		}
		int count = 0;
		int i = start;
		for (; i <= end; i++) {
			if (c[i] == '?') {
				count++;
			} else if (c[i] == ':') {
				count--;
				if (count == 0) {
					break;
				}
			}
		}
		return c[start] == 'T' ? dfs(c, start + 2, i - 1) : dfs(c, i + 1, end);
	}
}
