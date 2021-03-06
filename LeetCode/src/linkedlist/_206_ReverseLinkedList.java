package linkedlist;

/**
 * 
 * Problem: Reverse a singly linked list.
 * 
 */
public class _206_ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}
}
