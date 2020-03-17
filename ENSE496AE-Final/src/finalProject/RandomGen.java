package finalProject;


import java.util.*; 
import java.io.PrintWriter;

public class RandomGen {
		 
	    public static void main(String args[]){
	        Random rand = new Random(40236);
	    
	        try
	        {
	        	PrintWriter pr = new PrintWriter("LongList1.txt"); 

	            for (int i=0; i< 200 ; i++)
	            {
	                pr.println(Math.abs(rand.nextLong()));
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