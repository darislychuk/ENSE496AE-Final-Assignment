package finalProject;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileCheck {

	 public static void main(String args[]) throws Exception {

	      FileInputStream fstream1 = new FileInputStream("BeforeShuffle.txt");
	      FileInputStream fstream2 = new FileInputStream("AfterShuffle.txt");

	      DataInputStream in1= new DataInputStream(fstream1);
	      DataInputStream in2= new DataInputStream(fstream2);

	      BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
	      BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));

	      String strLine1, strLine2;
	      StringBuffer strFile2 = new StringBuffer(); 
	      //Store the contents of File2 in strFile2
	      while((strLine2 = br2.readLine()) != null) {
	          strFile2.append(strLine2);
	      }
	      //Check whether each line of File1 is in File2
	      while((strLine1 = br1.readLine()) != null){
	          if(strFile2.toString().contains(strLine1)){
	              System.out.println("Matches");
	          }
	      }
	      br1.close();
	      br2.close();

	    }
	 }
