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
        Random rand = new Random(key);	//Exchange pixels for random location based on shared key
        for (int i = size - 1; i > 0; i--)	//Go through each pixel exchanging them all
        {
            int n = rand.nextInt(i + 1);
            exchanges[size - 1 - i] = n;
        }
        return exchanges;	//Return the exchanged array
    }
	
	 public static int[] Shuffle(int[] toShuffle, int key)	//Take in the pixels and shared key as parameters
	    {
	        int size = toShuffle.length;	//Get the length of the array of shuffled pixels
	        int[] exchanges = GetShuffleExchanges(size, key);	//Call GetShuffleExchange function with size and shared key
	        for (int i = size - 1; i > 0; i--)	//Place each pixel back into array after being shuffled
	        {
	            int n = exchanges[size - 1 - i];
	            int tmp = toShuffle[i];
	            toShuffle[i] = toShuffle[n];
	            toShuffle[n] = tmp;
	        }
	        return toShuffle;
	    }
	 public static int[] DeShuffle(int[] shuffled, int key)	//Take in the shuffled pixels and shared key as parameters
	    {
	        int size = shuffled.length;	//Get the length of the array of shuffled pixels
	        int[] exchanges = GetShuffleExchanges(size, key);	//Call GetShuffleExchange function with size and shared key
	        for (int i = 1; i < size; i++)	//Place each pixel back into the array after being deshuffled
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
			BufferedImage originalImage = ImageIO.read(new File("c:\\Users\\Owner\\Documents\\ENSE\\ENSE496AE\\Final-Assignment\\Lock.png"));
			//Takes in given image
			 width = originalImage.getWidth();	//Gets width of original image
	         height = originalImage.getHeight();	//Gets height of original image
	         int[] pixels = new int[(width*height)];	//Create a 1D array to store pixel values in
	         
			
	         for(int i=0; i<height; i++) {
	             
	             for(int j=0; j<width; j++) {
	             
	                int p = originalImage.getRGB(j,i);	//Get the pixel value/RGB value at every given pixel in the image
	                //p = p/167238;
	                pixels[count] = p;	//Store these in the 1D array
	                count++;
	               // Color c = new Color(originalImage.getRGB(j, i));
	               // System.out.println("S.No: " + count + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());
	                System.out.print(pixels[count-1]);	//Print to console (not necessary)
	                
	                try
	    	        {	    	        	 	           
	    	                pr.println(pixels[count-1]);	//Print pixel values to BeforeShuffle.txt in order to compare later
	    	            	    	            
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
	         int[] shuffled = Shuffle(pixels,167238);	//Call shuffle function with pixels and shared key as parameters
	         	         
	         for(int i=0; i<height; i++) {
	             
	             for(int j=0; j<width; j++) {
	            	 
	       
	         System.out.print(shuffled[count]);	//Print to console (not necessary)
	         originalImage.setRGB((width - (j+1)),(height - (i+1)),shuffled[count]);	//Set the pixel values to shuffle and start in the bottom right instead of top left
	         count++;
	             }
	         }
	         
	         try	//Print out the shuffled image
	 	        {
	 	       
		 			ImageIO.write(originalImage, "png", new File(
							"c:\\Users\\Owner\\Documents\\ENSE\\ENSE496AE\\Final-Assignment\\newShuffledLock.png"));
	 	           
	 	        }
	 	        catch (Exception e)
	 	        {
	 	            e.printStackTrace();
	 	            System.out.println("No such file exists.");
	 	        }
	         
	         System.out.print("\n");
	         count = 0;
	         int[] deShuffled = DeShuffle(shuffled,167238);		//Call deshuffle algorithm with shuffled pixel and shared key
	         
	         for(int i=0; i<height; i++) {
	             
	             for(int j=0; j<width; j++) {
	            	 
	       
	         System.out.print(deShuffled[count]);	//Print to console (not necessary)
	         

	         try	//Print pixel values after deshuffle to Aftershuffle.txt to compare the two files for similarities
 	        {	    	        	 	           
 	                pr1.println(deShuffled[count]);
 	            	    	            
 	        }
 	        catch (Exception e)
 	        {
 	            e.printStackTrace();
 	            System.out.println("No such file exists.");
 	        }
	         
	         originalImage.setRGB(j,i,deShuffled[count]);	///Set the pixel value back to deshuffled value of each pixel
	         count++;
	             }
	         }
	         
	         try	//Print out the deshuffled image
 	        {
 	       
	 			ImageIO.write(originalImage, "png", new File(
						"c:\\Users\\Owner\\Documents\\ENSE\\ENSE496AE\\Final-Assignment\\newLock.png"));
 	           
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
