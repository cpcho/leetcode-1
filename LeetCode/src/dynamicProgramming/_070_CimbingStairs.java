package dynamicProgramming;

/**
 * 
 * Problem:
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 */
public class _070_CimbingStairs {
	public int climbStairs(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		int a = 1;
		int b = 1;
		int c;
		for (int i = 2; i <= n; i++) {
			c = b;
			b = a + b;
			a = c;
		}
		return b;
	}
}
