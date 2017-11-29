package hashTable;

/**
 * 
 * Problem:
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Write a function to determine if a number is strobogrammatic. The number is
 * represented as a string.
 * 
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 *
 */
public class _246_StrobogrammaticNumber {
	public boolean isStrobogrammatic1(String num) {
		if (num == null || num == "") {
			return true;
		}
		int[] map = new int[10];
		map[1] = 1;
		map[6] = 9;
		map[8] = 8;
		map[9] = 6;
		int left = 0;
		int right = num.length() - 1;
		while (left < right) {
			if (map[num.charAt(left) - '0'] != num.charAt(right) - '0') {
				return false;
			}
			left++;
			right--;
		}

		if (left == right && "018".indexOf(num.charAt(left)) == -1) {
			return false;
		}
		return true;
	}

	public boolean isStrobogrammatic2(String num) {
		int left = 0;
		int right = num.length() - 1;
		while (left <= right) {
			if (!"00 11 88 696".contains(num.charAt(left) + "" + num.charAt(right))) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
