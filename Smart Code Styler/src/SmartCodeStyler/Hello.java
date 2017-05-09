

package SmartCodeStyler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Implementation of Finally block, if-else block, line split
 * Adv Software Engineering : Dr. Csallner
 * */
public class Hello {
	
	int classF = 0;
	int A=12, B=13;
	public static void main(String[] args) 	{
		try {
			boolean isfinallyDone = true;
			int i=1, j=2, k=3;
			i=1 + i;
			i=i - 1;
			i=2 + 3;
			System.out.print("Hello, world!");
			System.out.print("\r");
			System.out.print("Need to print substraction method");
			System.out.println(isfinallyDone);
			if (i == 2 ) System.out.println("The value of i is true "); else System.out.println("The value of i is false");
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}finally {
			System.out.println("We are in the destination");
		}
		// finally { block ends
	}
	public void BelloMethod(){ 
		try{
		System.out.println("Bello, world!");
		Pattern p=Pattern.compile("([0-9])");
		Matcher m=p.matcher("Here is ur string4s4s56");
		int i=2;
		if (i == 2 || i == 3 ) System.out.println("The value of i is true "); else System.out.println("The value of i is false");
		} finally {
			
		}
	}
	
	public String xballs() 	{   
		int x=2;
		switch (x) {
		  case 1:
		        break;
		  case 2: 
		        break;
		  case 3:
		  case 4:        
		        break;
		  default:
		        break;
		}
		return null;
	}
	public void smartCodingStyle() 
	{}
	class A{}
}