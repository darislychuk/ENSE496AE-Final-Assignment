package finalProject;

import java.util.Scanner;

public class DHKeyAgreement {

	public static void main(String args[]){
		
		Scanner AlicePass = new Scanner(System.in);
		Scanner BobPass = new Scanner(System.in);
		
		long P, G, x, y, keyA, keyB;
		long a = 0;
		long b = 0;
	      
	    P = 275911; //This is a prime taken from excel
	    G = 2;  //G was said to be 2 or 5
	  
	    System.out.println("Enter password for Alice : ");
	    String APass = AlicePass.nextLine();	//Taking in password input from Alice via console
	    	    
	    for(int i = 0; i < APass.length();  i++)
	    {
	    	a = a + Character.getNumericValue(APass.charAt(i));  //Convert each character in the string to integer value
	    }
	    a = (long) Math.sqrt(a); // a is the chosen private key  
	    x = (long) (Math.pow(G, a)); // gets the generated key
	    x = x%P;
	      
	    System.out.println("Enter password for Bob : ");
	    String BPass = BobPass.nextLine();	//Taking in password input from Bob via console
		    
	    for(int i = 0; i < BPass.length();  i++)
	    {
	    	b = b + Character.getNumericValue(BPass.charAt(i));	//Convert each character in the string to integer value
	    }
	    b = (long) Math.sqrt(b); // b is the chosen private key 
	    y = (long) (Math.pow(G, b)); // gets the generated key
	    y = y%P;
	  
	    keyA = (long) (Math.pow(y, a)%P); //Secret key for Alice 
	    keyB = (long) (Math.pow(x, b)%P); //Secret key for Bob 
	      
	    System.out.println("Secret key for the Alice is : " + keyA); //Print out both keys to make sure they match
	    System.out.println("Secret Key for the Bob is : " + keyB); 
	    
	    AlicePass.close();
	    BobPass.close();
	    
	    return; 
	}
}
