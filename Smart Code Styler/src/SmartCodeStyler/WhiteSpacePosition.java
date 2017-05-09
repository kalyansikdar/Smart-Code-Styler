package SmartCodeStyler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WhiteSpacePosition {
	String checkSpaceBeforeAssignmentOperatorStyle(String inputFile) {
		/*
		 * This method will take the input java program file and check if there
		 * is space before assignment operator. In case of multiple occurrences
		 * of the operator system will take highest number of occurrence of the
		 * scenario.
		 */
		Scanner scr = new Scanner(inputFile);
		int lineNumber = 0;
		ArrayList<String> minedStyle = new ArrayList<>();
		while (scr.hasNextLine()) { // getting each line of the input program
			lineNumber = lineNumber + 1;
			String currentLine = scr.nextLine();
			minedStyle.addAll(findWhiteSpaceBefore(currentLine, "="));
		}
		//System.out.println(minedStyle);
		scr.close();
		if (Collections.frequency(minedStyle, "space found") > Collections.frequency(minedStyle, "space not found"))
			return "insert";
		else
			return "do not insert";
	}

	String checkSpaceAfterAssignmentOperatorStyle(String inputFile) {
		/*
		 * This method will take the input java program file and check if there
		 * is space before assignment operator. In case of multiple occurrences
		 * of the operator system will take highest number of occurrence of the
		 * scenario.
		 */
		Scanner scr = new Scanner(inputFile);
		int lineNumber = 0;
		ArrayList<String> minedStyle = new ArrayList<>();
		while (scr.hasNextLine()) { // getting each line of the input program
			lineNumber = lineNumber + 1;
			String currentLine = scr.nextLine();
			minedStyle.addAll(findWhiteSpaceAfter(currentLine, "="));
		}
		//System.out.println(minedStyle);
		scr.close();
		if (Collections.frequency(minedStyle, "space found") > Collections.frequency(minedStyle, "space not found"))
			return "insert";
		else
			return "do not insert";
	}

	String checkSpaceBeforeBinaryOperatorStyle(String inputFile) {
		/*
		 * This method will take the input java program file and check if there
		 * is space before assignment operator. In case of multiple occurrences
		 * of the operator system will take highest number of occurrence of the
		 * scenario.
		 */
		ArrayList<String> binaryOperator = new ArrayList<>();
		binaryOperator.add("\\+");
		binaryOperator.add("\\-");
		binaryOperator.add("\\*");
		binaryOperator.add("\\/");
		binaryOperator.add("\\>");
		binaryOperator.add("\\<");

		Scanner scr = new Scanner(inputFile);
		int lineNumber = 0;
		ArrayList<String> minedStyle = new ArrayList<>();

		for (String operator : binaryOperator) {
			while (scr.hasNextLine()) { // getting each line of the input
										// program
				lineNumber = lineNumber + 1;
				String currentLine = scr.nextLine();
				minedStyle.addAll(findWhiteSpaceBefore(currentLine, operator));
			}
			scr = new Scanner(inputFile);
			//System.out.println("In binary :" + minedStyle);
		}
		scr.close();
		if (Collections.frequency(minedStyle, "space found") > Collections.frequency(minedStyle, "space not found"))
			return "insert";
		else
			return "do not insert";
	}

	String checkSpaceAfterBinaryOperatorStyle(String inputFile) {
		/*
		 * This method will take the input java program file and check if there
		 * is space before assignment operator. In case of multiple occurrences
		 * of the operator system will take highest number of occurrence of the
		 * scenario.
		 */
		ArrayList<String> binaryOperator = new ArrayList<>();
		binaryOperator.add("\\+");
		binaryOperator.add("\\-");
		binaryOperator.add("\\*");
		binaryOperator.add("\\/");
		binaryOperator.add("\\>");
		binaryOperator.add("\\<");

		Scanner scr = new Scanner(inputFile);
		int lineNumber = 0;
		ArrayList<String> minedStyle = new ArrayList<>();

		for (String operator : binaryOperator) {
			while (scr.hasNextLine()) { // getting each line of the input
										// program
				lineNumber = lineNumber + 1;
				String currentLine = scr.nextLine();
				minedStyle.addAll(findWhiteSpaceAfter(currentLine, operator));
			}
			scr = new Scanner(inputFile);
			//System.out.println("In binary :" + minedStyle);
		}
		scr.close();
		if (Collections.frequency(minedStyle, "space found") > Collections.frequency(minedStyle, "space not found"))
			return "insert";
		else
			return "do not insert";
	}
	
	String checkSpaceBeforePrefixOperatorStyle(String inputFile) {
		/*
		 * This method will take the input java program file and check if there
		 * is space before assignment operator. In case of multiple occurrences
		 * of the operator system will take highest number of occurrence of the
		 * scenario.
		 */
		ArrayList<String> binaryOperator = new ArrayList<>();
		binaryOperator.add("\\++");
		binaryOperator.add("\\--");

		Scanner scr = new Scanner(inputFile);
		int lineNumber = 0;
		ArrayList<String> minedStyle = new ArrayList<>();

		for (String operator : binaryOperator) {
			while (scr.hasNextLine()) { // getting each line of the input
										// program
				lineNumber = lineNumber + 1;
				String currentLine = scr.nextLine();
				minedStyle.addAll(findWhiteSpaceBefore(currentLine, operator));
			}
			scr = new Scanner(inputFile);
			//System.out.println("In binary :" + minedStyle);
		}
		scr.close();
		if (Collections.frequency(minedStyle, "space found") > Collections.frequency(minedStyle, "space not found"))
			return "insert";
		else
			return "do not insert";
	}
	
	String checkSpaceAfterPrefixOperatorStyle(String inputFile) {
		/*
		 * This method will take the input java program file and check if there
		 * is space before assignment operator. In case of multiple occurrences
		 * of the operator system will take highest number of occurrence of the
		 * scenario.
		 */
		ArrayList<String> binaryOperator = new ArrayList<>();
		binaryOperator.add("\\++");
		binaryOperator.add("\\--");

		Scanner scr = new Scanner(inputFile);
		int lineNumber = 0;
		ArrayList<String> minedStyle = new ArrayList<>();

		for (String operator : binaryOperator) {
			while (scr.hasNextLine()) { // getting each line of the input
										// program
				lineNumber = lineNumber + 1;
				String currentLine = scr.nextLine();
				minedStyle.addAll(findWhiteSpaceAfter(currentLine, operator));
			}
			scr = new Scanner(inputFile);
			//System.out.println("In binary :" + minedStyle);
		}
		scr.close();
		if (Collections.frequency(minedStyle, "space found") > Collections.frequency(minedStyle, "space not found"))
			return "insert";
		else
			return "do not insert";
	}

	ArrayList<String> findWhiteSpaceAfter(String lineToCheck, String operator)
	/*
	 * This method takes each line of the program as input and checks if there
	 * are occurrences of == in the line. If yes, then mined style of those
	 * occurrences are stored in an array-list accordingly and the array-list is
	 * returned
	 */
	{
		String stringToSearch = lineToCheck;
		Pattern pattern = Pattern.compile((operator));
		Matcher matcher = pattern.matcher(stringToSearch);
		ArrayList<String> tokenPosition = new ArrayList<String>();

		while (matcher.find()) {
			int end = matcher.end();
			// System.out.println("String at end :" +
			// stringToSearch.charAt(end));
			// System.out.println("Char before ==: " +
			// stringToSearch.charAt(start-1));
			if (stringToSearch.charAt(end) == ' ')
				tokenPosition.add("space found");
			else
				tokenPosition.add("space not found");
		}
		return tokenPosition;
	}

	ArrayList<String> findWhiteSpaceBefore(String lineToCheck, String operator)
	/*
	 * This method takes each line of the program as input and checks if there
	 * are occurrences of == in the line. If yes, then mined style of those
	 * occurrences are stored in an array-list accordingly and the array-list is
	 * returned
	 */
	{
		String stringToSearch = lineToCheck;
		Pattern pattern = Pattern.compile(operator);
		Matcher matcher = pattern.matcher(stringToSearch);
		ArrayList<String> tokenPosition = new ArrayList<String>();

		while (matcher.find()) {
			int start = matcher.start();
			// System.out.println("String at end :" +
			// stringToSearch.charAt(end));
			// System.out.println("Char before ==: " +
			// stringToSearch.charAt(start-1));
			if (stringToSearch.charAt(start - 1) == ' ')
				tokenPosition.add("space found");
			else
				tokenPosition.add("space not found");
		}
		return tokenPosition;
	}

}
