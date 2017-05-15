package linkedlist;

/**
 * 
 * Problem:
 * Given a linked list, swap every two adjacent nodes and return its head.
For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * 
 * Algorithm: 
 * 
 * Time Complexity: 
 *
 * Spcace Complexity: 
 *
 */
public class _024_SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		while (cur.next != null && cur.next.next != null) {
			ListNode first = cur.next;
			ListNode second = cur.next.next;
			first.next = second.next;
			cur.next = second;
			cur.next.next = first;
			cur = cur.next.next;
		}
		return dummy.next;
	}
}
