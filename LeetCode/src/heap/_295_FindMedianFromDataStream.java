package heap;

import java.util.PriorityQueue;

/**
 * 
 * Problem:
 * 
 * Median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value. So the median is the mean of the two
 * middle value.
 * 
 * Examples: [2,3,4] , the median is 3
 * 
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addNum(int num) - Add a integer number from the data stream to the data
 * structure.
 * 
 * double findMedian() - Return the median of all elements so far.
 * 
 * For example:
 * 
 * addNum(1) addNum(2) findMedian() -> 1.5 addNum(3) findMedian() -> 2
 *
 */
public class _295_FindMedianFromDataStream {
	PriorityQueue<Integer> minHeap = null; // store the larger numbers
	PriorityQueue<Integer> maxHeap = null; // store the smaller numbers

	public _295_FindMedianFromDataStream() {
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>((a, b) -> (b - a));
	}

	public void addNum(int num) {
		maxHeap.offer(num); // put the number in the smaller part
		minHeap.offer(maxHeap.poll()); // put the maximum in the smaller part to
										// the larger part
		if (maxHeap.size() < minHeap.size()) {
			maxHeap.offer(minHeap.poll()); // put the minimum in the larger part
											// to the smaller part
		}
	}

	public double findMedian() {
		if (maxHeap.size() == minHeap.size()) {
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		} else {
			return maxHeap.peek();
		}
	}
}
