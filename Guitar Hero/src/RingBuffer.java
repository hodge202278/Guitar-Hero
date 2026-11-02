import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;

public class RingBuffer {
	
	private double[] ringBuffer;
	private int size;
	
	private int head = 0;
	private int tail = 0;

	public RingBuffer(int capacity)
	{
		ringBuffer = new double[capacity];
		size = 0;
	}
	public int size()
	{
		return size;
		// return number of items currently in the buffer
	}
	public boolean isEmpty()
	{
		return (size == 0);
		// is the buffer empty (size equals zero)?
	}
	public boolean isFull()
	{
		return (size == ringBuffer.length);
		// is the buffer full  (size equals capacity)?
	}
	public void enqueue(double x) throws IllegalStateException
	{
		double temp;
		
		if (isFull())
		{
			throw new IllegalStateException();
		}
		
		ringBuffer[tail] = x;
		tail = size + 1;
		size++;
		// add item x to the end (if not full)
	}
	public double dequeue() throws NoSuchElementException
	{
		double temp;
		
		if (!isEmpty())
		{
			temp = ringBuffer[head];
			
			for (int i = head; i < tail-1; i++)
			{
				ringBuffer[i] = ringBuffer[i+1];
			}
			
			tail--;
			size--;
			
			return temp;
		}
		
		throw new NoSuchElementException();
		// delete and return item from the front (if not empty)
	}
	public double peek() throws NoSuchElementException
	{
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
		
		return ringBuffer[head];
		// return item from the front of the buffer
	}
	public String toString()
	{
		String builder = "[";
		
		for (int i = head; i < tail; i++)
		{
			builder += ringBuffer[i];
			
			if (!(i == tail - 1))
			{
				builder += ", ";
			}
		}
		
		builder += "]";
		
		return builder;
		//form [front, next, �, next, last] 
	}

}
