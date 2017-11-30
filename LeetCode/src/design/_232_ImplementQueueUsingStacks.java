package design;

import java.util.Stack;

/**
 * 
 */
public class _232_ImplementQueueUsingStacks {
	Stack<Integer> input = new Stack<>();
	Stack<Integer> output = new Stack<>();

	public void push(int x) {
		input.push(x);
	}

	public int pop() {
		int res = peek();
		output.pop();
		return res;
	}

	public int peek() {
		if (output.isEmpty()) {
			while (!input.isEmpty()) {
				output.push(input.pop());
			}
		}
		return output.peek();
	}

	public boolean empty() {
		return input.isEmpty() && output.isEmpty();
	}
}
