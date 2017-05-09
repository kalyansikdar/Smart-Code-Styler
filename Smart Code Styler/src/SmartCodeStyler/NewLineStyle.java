package SmartCodeStyler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewLineStyle {
	static String CheckNewLineArray(
			String inputFile) {
		/*
		 * This method will take the input java program file and check if there is
		 * new line before/after opening brace of array initializer. In case of multiple occurrences
		 * of the operator system will take highest number of occurrence of the
		 * scenario.
		 */
		Scanner scr = new Scanner(inputFile);
		int lineNumber = 0;
		ArrayList<String> minedStyle = new ArrayList<>();
		while (scr.hasNextLine()) { // getting each line of the input program
			lineNumber=lineNumber + 1;
			String currentLine = scr.nextLine();
			if (FindCharacterforArray(currentLine) != null) // calling this method
															// to find == in
															// each line of the
															// inout program
				minedStyle.addAll(FindCharacterforArray(currentLine));
		}
		scr.close();
		System.out.println(minedStyle);
		if (Collections.frequency(minedStyle, "space found") > Collections
				.frequency(minedStyle, "space not found"))
			// System.out.println("insert");
			return "insert";
		else
			// System.out.println("do not insert");
			return "do not insert";
		// return null;
	}
	
	public static ArrayList<String> FindCharacterforArray(String lineToCheck)
	/*
	 * This method takes each line of the program as input and checks if there
	 * are occurrences of == in the line. If yes, then mined style of those
	 * occurrences are stored in an array-list accordingly and the array-list is
	 * returned
	 */
	{
		String stringToSearch = lineToCheck;
		Pattern pattern = Pattern.compile("(\\[])");
		Matcher matcher = pattern.matcher(stringToSearch);
		ArrayList<String> tokenPosition = new ArrayList<String>();

		while (matcher.find()) {
			int start = matcher.start();
			// System.out.println("String at end :" +
			// stringToSearch.charAt(end));
			// System.out.println("Char before ==: " +
			// stringToSearch.charAt(start-1));
			if (stringToSearch.charAt(start - 1) == ' '
					&& stringToSearch.charAt(start - 1) == ' ')
				tokenPosition.add("space found");
			else
				tokenPosition.add("space not found");
		}
		return tokenPosition;
	}

}
