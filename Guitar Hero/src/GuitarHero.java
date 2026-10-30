import java.io.IOException;

public class GuitarHero {

	 public static void main(String[] args) throws IOException {

	        // Create two guitar strings, for concert A and C
		 	String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
		 	
		 	GuitarString[] list = new GuitarString[keyboard.length()];
		 	
		 	double TEXT_POS_X = 0;
		 	double TEXT_POS_Y = 0;
		 	
		 	for (int i = 0; i < keyboard.split("").length; i++)
		 	{
		 		list[i] = new GuitarString(440 * Math.pow(1.05956, i-25));
		 		StdDraw.text(TEXT_POS_X, TEXT_POS_Y + (i * 5), keyboard.split("")[i]);
		 	}
	        
	        play(list);
	    }
	    
	    private static void play(GuitarString[] string) throws IOException {        // the main input loop
	        while (true) {
	            
	            // check if the user has typed a key, and, if so, process it
	            if (StdDraw.hasNextKeyTyped()) {
	 
	                // the user types this character
	                char key = StdDraw.nextKeyTyped();

	                // pluck the corresponding string
	                if (key == 'a') 
	                    stringA.pluck();
	                else if (key == 'c') 
	                    stringC.pluck();
	            }

	            // compute the superposition of the samples
	            double sample = stringA.sample() + stringC.sample();

	            // send the result to standard audio
	            StdAudio.play(sample);

	            // advance the simulation of each guitar string by one step
	            stringA.tic();
	            stringC.tic();
	        }
	        
	    }
}
