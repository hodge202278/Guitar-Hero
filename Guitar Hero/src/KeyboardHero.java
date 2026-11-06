import java.io.IOException;

public class KeyboardHero {

	public static void main(String[] args) throws IOException{
		// Create two guitar strings, for concert A and C
		String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
	 	String[] keys = keyboard.split("");
	 	GuitarString[] list = new GuitarString[keyboard.length()];
	 	StdDraw.setCanvasSize(1600,800);
	 	double TEXT_POS_X = 0;
	 	double TEXT_POS_Y = 1;
	 	
	 	for(int i = 0; i < 10; i++)
	 	{
	 		StdDraw.rectangle((i+11)*.02,.2,.02,.1);
	 		if(i==1 || i==2 || i==3 || i==5 || i==6 || i==9 || i==8)
	 		{
	 			StdDraw.filledRectangle((i+11)*.02, .25, .005, .05);
	 		}
	 	}
	 	for(int i = 0; i < 10; i++)
	 	{
	 		StdDraw.rectangle(i*.02,.2,.02,.1);
	 		if(i==0 || i==2 || i==3 || i==5 || i==6 || i==7 || i==9)
	 		{
	 			StdDraw.filledRectangle(i*.02, .25, .005, .05);
	 		}
	 		StdDraw.filledRectangle(.2, .25, .005, .05);
	 	}
	 	
	 	for (int i = 0; i < keys.length; i++)
	 	{
	 		list[i] = new GuitarString(440 * Math.pow(1.05956, i-24));
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
	        			list[i].pluck();
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
