package linkedlist;

import java.util.HashMap;

/**
 * 
 * Problem: A linked list is given such that each node contains an additional
 * random pointer which could point to any node in the list or null. Return a
 * deep copy of the list.
 * 
 * Algorithm:
 *
 * Time Complexity:
 *
 * Space Complexity:
 *
 */
class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};

public class _138_CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		HashMap<RandomListNode, RandomListNode> hash = new HashMap<>();
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode pre = dummy;
		RandomListNode newNode;
		while (head != null) {
			if (hash.containsKey(head)) {
				newNode = hash.get(head);
			} else {
				newNode = new RandomListNode(head.label);
				hash.put(head, newNode);
			}
			pre.next = newNode;
			if (head.random != null) {
				if (hash.containsKey(head.random)) {
					newNode.random = hash.get(head.random);
				} else {
					// head.random doesn't exit. need to create a new one
					newNode.random = new RandomListNode(head.random.label);
					hash.put(head.random, newNode.random);
				}
			}
			pre = newNode;
			head = head.next;
		}
		return dummy.next;
	}
}
