package SmartCodeStyler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ControlStatementStyler {
	
	/*
	 * Method - CheckLineBeforeFinally is to check if there is a new line before finally in
	 * try block. <setting id=
	 * "org.eclipse.jdt.core.formatter.insert_new_line_before_finally_in_try_statement"
	 * value="do not insert"/>
	 */
	
	String checkNewLineBeforeFinally(String inputfile) throws Exception {
		Scanner scr = new Scanner(inputfile);
		int lineNumber = 0;
		ArrayList<String> minedStyle = new ArrayList<>();
		while (scr.hasNextLine()) {
			lineNumber = lineNumber + 1;
			String currentLine = scr.nextLine();
			minedStyle.addAll(findFinally((currentLine)));  //calling this method to find == in each line of the input program
			//minedStyle.add(lineNumber, currentLine);
		}
		//System.out.println("MINED STYLE:" + minedStyle);
		scr.close();
		if (Collections.frequency(minedStyle, "New Line not Found") > Collections
				.frequency(minedStyle, "New Line Found"))
			// System.out.println("insert");
			return "do not insert";
		else
			// System.out.println("do not insert");
			return "insert";
	}
	
	ArrayList<String> findFinally(String lineToCheck)
	/*
	 * This method takes each line of the program as input and checks if there
	 * are occurrences of 'finally' keyword in the line. If yes, then mined style of those
	 * occurrences are stored in an array-list accordingly and the array-list is
	 * returned
	 */
	{
		String stringToSearch = lineToCheck;
		Pattern pattern = Pattern.compile("(\\bfinally\\b)");
		Matcher matcher = pattern.matcher(stringToSearch);
		ArrayList<String> tokenPosition = new ArrayList<String>();

		while (matcher.find()) {
			String[] result= stringToSearch.split("finally");
			/*for(String k:  result)
				System.out.println(k);*/
			if(result[0].trim().length() == 0)
				tokenPosition.add("New Line Found");
			else 
				tokenPosition.add("New Line not Found");
		}
		//System.out.println("Inside find method" + tokenPosition);
		return tokenPosition;
	}
	
	 String newlineBeforeElse(String inputFile) throws Exception {
		int lineNumber = 0, targetLineNo = 0;
		String currentLine = null;
		Scanner scr = new Scanner(inputFile);
		HashMap<Integer, String> inputProgram = new HashMap<>();
		while (scr.hasNextLine()) {
			currentLine = scr.nextLine();
			
			lineNumber++;
			inputProgram.put(lineNumber, currentLine);
			
			Scanner word = new Scanner(currentLine);
			while(word.hasNext()&& word.next().matches("\\b(if)\\b"))
			{       
				targetLineNo = lineNumber;
				inputProgram.put(lineNumber, currentLine);
				break;
				}
			word.close();
			}
		String targetLine = inputProgram.get(targetLineNo);
		scr.close();
		Scanner el = new Scanner(targetLine);		
		String p= "";
		while(el.hasNext()){ 
			String val=el.next();
			//System.out.println(val);
			if(val.matches("\\b(else)\\b")){
			//	System.out.println("enter else");
			     p= "do not insert";
			     break;
			  }
			else
				p= "insert";
		}
		//System.out.println(p);
		el.close(); 
		return p;
		}
}
