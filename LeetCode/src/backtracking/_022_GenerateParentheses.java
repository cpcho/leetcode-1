package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem:
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 * Solution:
 * 
 * DFS, open and close variable. open < (number Of pairs) && close < open
 */
public class _022_GenerateParentheses {

	/**
	 * 
	 * With String
	 */
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		helper(res, "", 0, 0, n);
		return res;
	}

	public void helper(List<String> res, String s, int open, int close, int numberOfPairs) {
		if (s.length() == numberOfPairs * 2) {
			res.add(s);
			return;
		}
		if (open < numberOfPairs) {
			helper(res, s + "(", open + 1, close, numberOfPairs);
		}
		if (close < open) {
			helper(res, s + ")", open, close + 1, numberOfPairs);
		}
	}

	/**
	 * 
	 * With StringBuilder
	 */
	public List<String> generateParenthesis2(int n) {
		List<String> res = new ArrayList<>(0);
		if (n <= 0) {
			return res;
		}
		StringBuilder sb = new StringBuilder("");
		helper2(0, 0, n, sb, res);
		return res;
	}

	private void helper2(int open, int close, int num, StringBuilder s, List<String> res) {
		if (open + close == 2 * num) {
			res.add(s.toString());
			return;
		}
		if (open < num) {
			helper2(open + 1, close, num, s.append("("), res);
			s.deleteCharAt(s.length() - 1);
		}
		if (close < open) {
			helper2(open, close + 1, num, s.append(")"), res);
			s.deleteCharAt(s.length() - 1);
		}
	}
}
