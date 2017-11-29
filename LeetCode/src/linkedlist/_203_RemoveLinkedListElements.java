package linkedlist;

/**
 * 
 * Problem:
 * 
 * Remove all elements from a linked list of integers that have value val.
 * Example Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 Return: 1 --> 2
 * --> 3 --> 4 --> 5
 * 
 */
public class _203_RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int x) {
		if (head == null) {
			return null;
		}
		head.next = removeElements(head.next, x);
		if (head.val == x) {
			return head.next;
		} else
			return head;
	}
}
