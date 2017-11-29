package linkedlist;

/**
 * 
 * Problem:
 * 
 * Sort a linked list using insertion sort.
 * 
 *
 */
public class _147_InsertionSorList {
	public static ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		ListNode cur = head;
		ListNode pre = dummy;
		ListNode next = null;
		while (cur != null) {
			next = cur.next;
			while ((pre.next != null) && (pre.next.val < cur.val)) {

				pre = pre.next;
				System.out.println("pre" + pre.val);
			}
			// insert between pre and pre.next
			cur.next = pre.next;
			pre.next = cur;
			pre = dummy;
			cur = next;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(2);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		node.next = node2;
		node2.next = node3;

		ListNode res = insertionSortList(node);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}

	}
}
