package design;

import java.util.LinkedList;
import java.util.Queue;

public class _225_ImplementStackUsingQueues {
	private Queue<Integer> queue = new LinkedList<>();

	// Push element x onto stack.
	public void push(int x) {
		queue.add(x);
		for (int i = 1; i < queue.size(); i++) {
			queue.add(queue.remove());
		}
	}

	// Removes the element on top of the stack.
	public int pop() {
		int res = top();
		queue.remove();
		return res;
	}

	// Get the top element.
	public int top() {
		return queue.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return queue.isEmpty();
	}
}
