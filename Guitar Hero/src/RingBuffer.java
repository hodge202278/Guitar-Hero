import java.util.LinkedList;
import java.util.Queue;

public class RingBuffer {
	
	private double[] ringBuffer;

	public RingBuffer(int capacity)
	{
		ringBuffer = new double[capacity];
	}
	public int size()
	{
		return 0;
		// return number of items currently in the buffer
	}
	public boolean isEmpty()
	{
		return false;
		// is the buffer empty (size equals zero)?
	}
	public boolean isFull()
	{
		return false;
		// is the buffer full  (size equals capacity)?
	}
	public void enqueue(double x)
	{
		// add item x to the end (if not full)
	}
	public double dequeue()
	{
		return 0;
		// delete and return item from the front (if not empty)
	}
	public double peek()
	{
		return 0;
		// return item from the front of the buffer
	}
	public String toString()
	{
		return null;
		//form [front, next, …, next, last] 
	}

}
