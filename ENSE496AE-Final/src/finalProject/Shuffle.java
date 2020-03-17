package finalProject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;

public class Shuffle {
	
	public static int[] GetShuffleExchanges(int size, int key)
    {
        int[] exchanges = new int[size - 1];
        Random rand = new Random(key);
        for (int i = size - 1; i > 0; i--)
        {
            int n = rand.nextInt(i + 1);
            exchanges[size - 1 - i] = n;
        }
        return exchanges;
    }
	
	 public static int[] Shuffle(int[] toShuffle, int key)
	    {
	        int size = toShuffle.length;
	        int[] exchanges = GetShuffleExchanges(size, key);
	        for (int i = size - 1; i > 0; i--)
	        {
	            int n = exchanges[size - 1 - i];
	            int tmp = toShuffle[i];
	            toShuffle[i] = toShuffle[n];
	            toShuffle[n] = tmp;
	        }
	        return toShuffle;
	    }
	 public static int[] DeShuffle(int[] shuffled, int key)
	    {
	        int size = shuffled.length;
	        int[] exchanges = GetShuffleExchanges(size, key);
	        for (int i = 1; i < size; i++)
	        {
	            int n = exchanges[size - i - 1];
	            int tmp = shuffled[i];
	            shuffled[i] = shuffled[n];
	            shuffled[n] = tmp;
	        }
	        return shuffled;
	    }

	public static void main(String[] args) {

		int width, height;
		 int count = 0;
		
		try {

			PrintWriter pr = new PrintWriter("BeforeShuffle.txt");
			PrintWriter pr1 = new PrintWriter("AfterShuffle.txt");
			BufferedImage originalImage = ImageIO.read(new File(
					"c:\\Users\\Owner\\Documents\\ENSE\\ENSE496AE\\Final\\TERRY.jpg"));
			
			 width = originalImage.getWidth();
	         height = originalImage.getHeight();
	         int[] pixels = new int[(width*height)];
	         
			
	         for(int i=0; i<height; i++) {
	             
	             for(int j=0; j<width; j++) {
	             
	                int p = originalImage.getRGB(j,i);
	                //p = p/167238;
	                pixels[count] = p;
	                count++;
	               // Color c = new Color(originalImage.getRGB(j, i));
	               // System.out.println("S.No: " + count + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());
	                System.out.print(pixels[count-1]);
	                
	                try
	    	        {	    	        	 	           
	    	                pr.println(pixels[count-1]);
	    	            	    	            
	    	        }
	    	        catch (Exception e)
	    	        {
	    	            e.printStackTrace();
	    	            System.out.println("No such file exists.");
	    	        }

	             }
	          }
	         System.out.print("\n");
	         count = 0;
	         int[] shuffled = Shuffle(pixels,167238);
	         	         
	         for(int i=0; i<height; i++) {
	             
	             for(int j=0; j<width; j++) {
	            	 
	       
	         System.out.print(shuffled[count]);
	         originalImage.setRGB((width - (j+1)),(height - (i+1)),shuffled[count]);
	         count++;
	             }
	         }
	         
	         try
	 	        {
	 	       
		 			ImageIO.write(originalImage, "jpg", new File(
							"c:\\Users\\Owner\\Documents\\ENSE\\ENSE496AE\\Final\\newShuffledTerry.jpg"));
	 	           
	 	        }
	 	        catch (Exception e)
	 	        {
	 	            e.printStackTrace();
	 	            System.out.println("No such file exists.");
	 	        }
	         
	         System.out.print("\n");
	         count = 0;
	         int[] deShuffled = DeShuffle(shuffled,167238);
	         
	         for(int i=0; i<height; i++) {
	             
	             for(int j=0; j<width; j++) {
	            	 
	       
	         System.out.print(deShuffled[count]);
	         

	         try
 	        {	    	        	 	           
 	                pr1.println(deShuffled[count]);
 	            	    	            
 	        }
 	        catch (Exception e)
 	        {
 	            e.printStackTrace();
 	            System.out.println("No such file exists.");
 	        }
	         
	         originalImage.setRGB(j,i,deShuffled[count]);
	         count++;
	             }
	         }
	         
	         try
 	        {
 	       
	 			ImageIO.write(originalImage, "jpg", new File(
						"c:\\Users\\Owner\\Documents\\ENSE\\ENSE496AE\\Final\\newTERRY.jpg"));
 	           
 	        }
 	        catch (Exception e)
 	        {
 	            e.printStackTrace();
 	            System.out.println("No such file exists.");
 	        }
	         
	         pr.close();
	         pr1.close();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
