package linkedlist;

/**
 * 
 * Problem:
 * 
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once. For example, Given 1->1->2, return 1->2. Given
 * 1->1->2->3->3, return 1->2->3.
 * 
 */
public class _083_RemoveDuplicates {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return head;
	}
}
