import java.io.IOException;

public class GuitarString {
	public RingBuffer ringBuffer;
	public int timesTicd;
	
	public GuitarString(double frequency) throws IOException
	{
		// use a sampling rate of 44,100
		int capacity = (int) (44100 / frequency);
		ringBuffer = new RingBuffer(capacity);
		
		for (int i = 0; i < capacity; i++)
		{
			ringBuffer.enqueue(0);
		}
		
	}
	
	public GuitarString(double[] init) throws IOException
	{
		// size and values are given by the array
		ringBuffer = new RingBuffer(init.length);
		
		for (double item : init)
		{
			ringBuffer.enqueue(item);
		}
	}
	
	
	public void pluck() throws IOException   
	{
		// set the buffer to white noise
		for (int i = 0; i < ringBuffer.size(); i++)
		{
			ringBuffer.dequeue();
			ringBuffer.enqueue(Math.round((Math.random() - 0.5) * 100.0) / 100.0);
		}
	}
	
	public void tic() throws IOException     
	{
		// advance the simulation one time step
		double item1 = ringBuffer.dequeue();
		double item2 = ringBuffer.peek();
		
		double average = ((item1 + item2) / 2) * 0.994;
		
		ringBuffer.enqueue(average);
		
		timesTicd++;
	}
	
	public double sample() throws IOException
	{
		return ringBuffer.peek();
		// return the current sample
	}
	
	public int time()
	{
		return timesTicd;
		// return number of tics
	}

}
