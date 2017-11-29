package linkedlist;

/**
 * 
 * Problem:
 * 
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 */
public class _002_AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode res = null;
		ListNode result = null;
		ListNode newNode = null;
		while (l1 != null || l2 != null) {
			int num1 = 0;
			int num2 = 0;
			if (l1 != null)
				num1 = l1.val;
			if (l2 != null)
				num2 = l2.val;
			newNode = new ListNode((num1 + num2 + carry) % 10);
			if (res == null) {
				res = newNode;
				result = res;
			} else {
				res.next = newNode;
				res = res.next;
			}
			carry = (num1 + num2 + carry) / 10;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		// check if we still need to add one more node
		if (carry != 0) {
			ListNode one = new ListNode(carry);
			res.next = one;
		}
		return result;
	}
}
