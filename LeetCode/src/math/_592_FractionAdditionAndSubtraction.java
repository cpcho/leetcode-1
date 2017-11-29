package math;

import java.util.Arrays;

/**
 * 
 * Problem:
 * 
 * Given a string representing an expression of fraction addition and
 * subtraction, you need to return the calculation result in string format. The
 * final result should be irreducible fraction. If your final result is an
 * integer, say 2, you need to change it to the format of fraction that has
 * denominator 1. So in this case, 2 should be converted to 2/1.
 * 
 * Example 1: Input:"-1/2+1/2" Output: "0/1" Example 2: Input:"-1/2+1/2+1/3"
 * Output: "1/3" Example 3: Input:"1/3-1/2" Output: "-1/6" Example 4:
 * Input:"5/3+1/3" Output: "2/1" Note: The input string only contains '0' to
 * '9', '/', '+' and '-'. So does the output. Each fraction (input and output)
 * has format ±numerator/denominator. If the first input fraction or the output
 * is positive, then '+' will be omitted. The input only contains valid
 * irreducible fractions, where the numerator and denominator of each fraction
 * will always be in the range [1,10]. If the denominator is 1, it means this
 * fraction is actually an integer in a fraction format defined above. The
 * number of given fractions will be in the range [1,10]. The numerator and
 * denominator of the final result are guaranteed to be valid and in the range
 * of 32-bit int.
 *
 * 
 * Solution: Four sides and two diagonals
 *
 */
public class _592_FractionAdditionAndSubtraction {
	public double dist(int[] p1, int[] p2) {
		return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
	}

	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		int[][] p = { p1, p2, p3, p4 };
		Arrays.sort(p, (l1, l2) -> l1[0] == l2[0] ? l1[1] - l2[1] : l1[0] - l2[0]);
		return dist(p[0], p[1]) != 0 && dist(p[0], p[1]) == dist(p[1], p[3]) && dist(p[1], p[3]) == dist(p[3], p[2])
				&& dist(p[3], p[2]) == dist(p[2], p[0]) && dist(p[0], p[3]) == dist(p[1], p[2]);
	}
}
