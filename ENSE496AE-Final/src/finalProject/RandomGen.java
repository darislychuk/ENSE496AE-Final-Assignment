package finalProject;


import java.util.*; 
import java.io.PrintWriter;

public class RandomGen {
		 
	    public static void main(String args[]){
	        Random rand = new Random(40236L);//Make sure to keep the L at the end when changing the prime
	        //Use random number generator library
	        try
	        {
	        	PrintWriter pr = new PrintWriter("LongList1.txt"); //Print to LongList.txt file

	            for (int i=0; i< 200 ; i++)	//For loop to print 200 random values
	            {
	                pr.println(Math.abs(rand.nextLong()));	//No unsigned long in Java, therefore take absolute value
	            }
	            pr.close();
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	            System.out.println("No such file exists.");
	        }
	        
	    }
	}