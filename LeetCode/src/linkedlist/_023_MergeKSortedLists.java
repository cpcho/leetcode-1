package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * Problem: Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * 
 * Algorithm:
 *
 * Time Complexity:
 *
 * Space Complexity:
 *
 */
public class _023_MergeKSortedLists {
	private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
		public int compare(ListNode left, ListNode right) {
			if (left == null) {
				return 1;
			} else if (right == null) {
				return -1;
			}
			return left.val - right.val;
		}
	};

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, ListNodeComparator);
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				heap.add(lists[i]);
			}
		}
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (!heap.isEmpty()) {
			ListNode head = heap.poll();
			tail.next = head;
			tail = head;
			if (head.next != null) {
				heap.add(head.next);
			}
		}
		return dummy.next;
	}
}
