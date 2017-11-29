package linkedlist;

/**
 * 
 * Problem:
 * 
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→… You must do this in-place without altering the nodes'
 * values. For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 */
public class _143_ReorderList {
	public void reorderList(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy;
		ListNode fast = dummy;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// reverse the second part
		// 1 -> 2 -> 3 -> 4 -> 5 ==> 1 -> 2 -> 3 -> 4 <- 5
		fast = reverseList(slow.next);
		// it is needed. otherwise there will a intersection of two lists
		// 1 -> 2 -> 3 -> 4 <- 5 ==> 1 -> 2 -> 3, 4 <- 5
		slow.next = null;
		slow = head;
		ListNode temp1;
		ListNode temp2;
		// two lists
		while (slow != null && fast != null) {
			temp1 = slow.next;
			slow.next = fast;
			slow = temp1;
			temp2 = fast.next;
			fast.next = slow;
			fast = temp2;
		}
	}

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
