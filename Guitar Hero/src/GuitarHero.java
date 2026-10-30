import java.io.IOException;

public class GuitarHero {

	 public static void main(String[] args) throws IOException {

	        // Create two guitar strings, for concert A and C
		 	String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
		 	String[] keys = keyboard.split("");
		 	GuitarString[] list = new GuitarString[keyboard.length()];
		 	
		 	double TEXT_POS_X = 0;
		 	double TEXT_POS_Y = 1;
		 	
		 	for (int i = 0; i < keys.length; i++)
		 	{
		 		list[i] = new GuitarString(440 * Math.pow(1.05956, i-24));
		 		StdDraw.text(TEXT_POS_X + (i * 0.03), TEXT_POS_Y, keys[i]);
		 	}
	        
	        play(list, keys);
	    }
	    
	    private static void play(GuitarString[] list, String[] keys) throws IOException {        // the main input loop
	        while (true) {
	        	//double sample = 0;
	        	if(StdDraw.hasNextKeyTyped())
	        	{
	        		char key = StdDraw.nextKeyTyped();
		        	
		        	for(int i = 0; i < keys.length; i++)
		        	{
		        		if(key == keys[i].charAt(0))
		        		{
		        			System.out.println(key);
		        			list[i].pluck();
		        			System.out.println(list[i]);
		        		}
		        		//sample+=list[i].sample();
		        	}
		            
	        	}
	        	
	        	double sample = 0;
	        	for(int i = 0; i < list.length; i++)
	        	{
	        		sample+=list[i].sample();
	        		
	        	}
	        	StdAudio.play(sample);
	        	
	        	for(int i = 0; i < list.length; i++)
	        	{
	        		list[i].tic();
	        	}
	        }
	        
	    }
}
