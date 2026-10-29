
public class GuitarString {
	public RingBuffer ringBuffer;
	
	public GuitarString(double frequency)
	{
		// use a sampling rate of 44,100
	}
	
	public GuitarString(double[] init)
	{
		// size and values are given by the array
	}
	
	
	public void pluck()   
	{
		// set the buffer to white noise
	}
	
	public void tic()     
	{
		// advance the simulation one time step
	}
	
	public double sample()
	{
		return 0;
		// return the current sample
	}
	
	public int time()
	{
		return 0;
		// return number of tics
	}

}
