package design;

import java.util.HashMap;

/**
 * 
 * Problem: Design and implement a data structure for Least Recently Used (LRU)
 * cache. It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. put(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 * 
 * Follow up: Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * LRUCache cache = new LRUCache( 2 * capacity );
 * 
 * cache.put(1, 1);
 * 
 * cache.put(2, 2);
 * 
 * cache.get(1); // returns 1
 * 
 * cache.put(3, 3); // evicts key 2
 * 
 * cache.get(2); // returns -1 (not found)
 * 
 * cache.put(4, 4); // evicts key 1
 * 
 * cache.get(1); // returns -1 (not found)
 * 
 * cache.get(3); // returns 3
 * 
 * cache.get(4); // returns 4
 *
 */
public class _146_LRUCache {
	// doublely linkedlist
	private class Node {
		Node prev;
		Node next;
		int key;
		int value;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.prev = null;
			this.next = null;
		}
	}

	private int capacity;
	private HashMap<Integer, Node> map = new HashMap<>();
	// dummy head and tail
	private Node head = new Node(-1, -1);
	private Node tail = new Node(-1, -1);

	// constructor
	public _146_LRUCache(int capacity) {
		this.capacity = capacity;
		tail.prev = head;
		head.next = tail;
	}

	// in the get process, delete the current node, then move to tail
	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		// move current to tail. delete, add
		Node current = map.get(key);
		// delete
		current.prev.next = current.next;
		current.next.prev = current.prev;
		// add
		moveToTail(current);
		return map.get(key).value;
	}

	// if full, remove head node
	public void put(int key, int value) {
		if (get(key) != -1) {
			map.get(key).value = value;
			return;
		}
		// if full, remove
		if (map.size() == capacity) {
			// remove the eldest
			map.remove(head.next.key);
			head.next = head.next.next;
			head.next.prev = head;
		}
		Node insert = new Node(key, value);
		map.put(key, insert);
		moveToTail(insert);
	}

	private void moveToTail(Node current) {
		current.prev = tail.prev;
		tail.prev = current;
		current.prev.next = current;
		current.next = tail;
	}
}
