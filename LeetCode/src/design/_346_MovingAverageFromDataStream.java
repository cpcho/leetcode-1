package design;

/**
 * 
 * Problem: Given a stream of integers and a window size, calculate the moving
 * average of all integers in the sliding window.
 * 
 * For example, MovingAverage m = new MovingAverage(3);
 * 
 * m.next(1) = 1 
 * 
 * m.next(10) = (1 + 10) / 2
 * 
 * m.next(3) = (1 + 10 + 3) / 3
 * 
 * m.next(5) = (10 + 3 + 5) / 3
 *
 */
public class _346_MovingAverageFromDataStream {

 	private int[] window;
	private int count;
	private int insertIndex;
	private long sum;
    public _346_MovingAverageFromDataStream(int size) {
        window = new int[size];
        insertIndex = 0;
        sum = 0;
    }
    
    public double next(int val) {
        if(count < window.length){
        	count++;
        }
        // decrease the number in insert position
        sum -= window[insertIndex];
        sum += val;
        //update the number in insert Index
        window[insertIndex] = val;
        insertIndex = (insertIndex + 1) % window.length;
        return (double)sum / count;
    }
}
