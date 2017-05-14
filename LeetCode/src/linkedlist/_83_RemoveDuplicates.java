package linkedlist;

/**
 * 
 * Problem: Given a sorted linked list, delete all duplicates such that each element appear only once.
For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 * 
 * Algorithm: 
 * 
 * Time Complexity: 
 *
 * Spcace Complexity: 
 *
 */
public class _83_RemoveDuplicates {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pointer = head;
		while (pointer.next != null) {
			if (pointer.val == pointer.next.val) {
				pointer.next = pointer.next.next;
			} else {
				pointer = pointer.next;
			}
		}
		return head;
	}
}
