package sort;

/**
 * 
 * Problem:
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Time Complexity: O(NlogN)
 * 
 * Space Complexity: O(1)
 *
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

// merger sort
public class _148_SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// step1. cut the list to two havles
		ListNode pre = null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		pre.next = null;
		// step2. sort each half
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);
		// step3. merge sort
		return merge(l1, l2);
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if (l1 != null) {
			p.next = l1;
		}
		if (l2 != null) {
			p.next = l2;
		}
		return dummy.next;
	}
}