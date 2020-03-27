package finalProject;

import java.io.PrintWriter;

public class PrimeNumGen {

	public static void main (String[] args){
		
	      int i =0;
	      int num =0;
	      String  primeNumbers = "";
	      long n = 999999999999999999L; //Biggest value to go to
	      n = (long) Math.sqrt(n);  //Used to calculate primes from 2 to square root of n only
	      long startTime = System.nanoTime();  //**Use start time here if wanting accumulated time to find primes instead of time between each prime**
	      for (i = 1; i <= n; i++){
	    	  //long startTime = System.nanoTime();   **Use start time here if wanting time between each prime instead of accumulated time to find primes**
	    	  int counter=0;	    	  	  
	    	  if(i >= 2 && i <= n) {  //Only check if its a prime if between 2 and square root of n
	    		 
//	    		  if(i != 7 && i%7==0){  Was told by eliminating 5 and 7 it could harm performance
//		    		  i++;
//		    	  }
//	    		  
//	    		  if(i != 5 && i%5==0){
//		    		  i++;
//		    	  }
//	    		  
	    		  if(i != 3 && i%3==0){  //Eliminate all integers divisible by 3 other than 3 itself
	    			  i++;
	    		  }
	    		  if(i != 2 && i%2==0){  //Eliminate all integers divisible by 2 other than 2 itself
	    			  i++;
	    		  }
	      for(num =i; num>=1; num--){	//Start at the value i and check every value below itself
	    	  if(i%num==0){
	    		  counter = counter + 1;	//Increase counter when the value being looked at equals 0 when using modulus
	    	  }		//E.g. 5%5 == 0, increase counter, 5%4 != 0, 5%3 !=0 and so on...
	      }
	      if (counter ==2){
			 long endTime = System.nanoTime();	//End timer here to get processing time
	     	 long timeElapsed = endTime - startTime;	//Time taken is end - start
	     	 primeNumbers = primeNumbers + i + "," + 	//Put the prime value and timeElapsed into a string in csv format
					timeElapsed / 1000000 + "\n";
	     	 try{
	     		 PrintWriter pr = new PrintWriter("NewPrimeBank.csv");	//Print the prime number and processing time in a csv file     
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
}
