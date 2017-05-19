package linkedlist;

/**
 * 
 * Problem: Reverse a linked list from position m to n. Do it in-place and in
 * one-pass. For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4, return
 * 1->4->3->2->5->NULL. Note: Given m, n satisfy the following condition: 1 ≤ m
 * ≤ n ≤ length of list.
 * 
 * Algorithm:
 *
 * Time Complexity:
 *
 * Space Complexity:
 *
 */
public class _092_ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode left = dummy;
		ListNode right = dummy;
		int gap = n - m + 1;
		while (gap > 0) {
			right = right.next;
			gap--;
		}
		int move = m - 1;
		while (move > 0) {
			left = left.next;
			right = right.next;
			move--;
		}
		ListNode newHead = null;
		right = right.next;
		ListNode newleft = left.next;
		ListNode newleft1 = left.next;
		gap = n - m + 1;
		while (gap > 0 && newleft != null) {
			ListNode next = newleft.next;
			newleft.next = newHead;
			newHead = newleft;
			newleft = next;
			gap--;
		}
		left.next = newHead;
		newleft1.next = right;
		return dummy.next;
	}
}
