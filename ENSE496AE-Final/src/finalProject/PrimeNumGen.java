package finalProject;

import java.io.PrintWriter;

public class PrimeNumGen {

	public static void main (String[] args){
		
	      int i =0;
	      int num =0;
	      String  primeNumbers = "";
	      long n = 999999999;
	      long startTime = System.nanoTime();
	      for (i = 1; i <= n; i++){
	    	  int counter=0; 		  
	      for(num =i; num>=1; num--){
	    	  if(i%num==0){
	    		  counter = counter + 1;
	    	  }
	      }
	      if (counter ==2){
			 long endTime = System.nanoTime();
	     	 long timeElapsed = endTime - startTime;
	     	 primeNumbers = primeNumbers + i + "," + 
					timeElapsed / 1000000 + "\n";
	     	 try{
	     		 PrintWriter pr = new PrintWriter("PrimeBank.csv");	         
	                pr.println(primeNumbers);
	                //System.out.println(primeNumbers);
	                     pr.close();
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	            System.out.println("No such file exists.");
	        }
	      }
	      }
	}
}
