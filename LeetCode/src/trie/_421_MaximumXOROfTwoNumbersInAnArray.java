package trie;

/**
 * 
 * Problem:
 * 
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 * 
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * 
 * Could you do this in O(n) runtime?
 * 
 * Example:
 * 
 * Input: [3, 10, 5, 25, 2, 8]
 * 
 * Output: 28
 * 
 * Explanation: The maximum result is 5 ^ 25 = 28.
 *
 */
class Trie {
	Trie[] children;

	public Trie() {
		children = new Trie[2];
	}
}

public class _421_MaximumXOROfTwoNumbersInAnArray {
	public int findMaximumXOR(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		// initialize the trie
		Trie root = new Trie();
		for (int num : nums) {
			Trie curNode = root;
			for (int i = 31; i >= 0; i--) {
				int curBit = (num >>> i) & 1;
				if (curNode.children[curBit] == null) {
					curNode.children[curBit] = new Trie();
				}
				// go to the next children
				curNode = curNode.children[curBit];
			}
		}
		// compare each num
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			Trie curNode = root;
			int curSum = 0;
			for (int i = 31; i >= 0; i--) {
				int curBit = (num >>> i) & 1;
				if (curNode.children[curBit ^ 1] != null) {
					curSum += (1 << i);
					curNode = curNode.children[curBit ^ 1];
				} else {
					curNode = curNode.children[curBit];
				}
			}
			max = Math.max(curSum, max);
		}
		return max;
	}
}