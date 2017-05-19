package linkedlist;

/**
 * 
 * Problem: Given a singly linked list, determine if it is a palindrome.
 *  Follow up: Could you do it in O(n) time and O(1) space?
 * 
 * Algorithm:
 *
 * Time Complexity:
 *
 * Space Complexity:
 *
 */

public class _234_PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// odd number nodes, ignore the middle node
		if (fast != null) {
			slow = slow.next;
		}
		// reverse the second part
		ListNode headSecondPart = reverseList(slow);
		while (headSecondPart != null) {
			if (head.val != headSecondPart.val) {
				return false;
			}
			head = head.next;
			headSecondPart = headSecondPart.next;
		}
		return true;
	}

	// reverse LinkedList
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
