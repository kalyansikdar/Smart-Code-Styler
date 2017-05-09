package SmartCodeStyler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;

class BracePositions {

	String braceStyleForMethod(String inputFile)
			throws Exception {

		Scanner scr = new Scanner(inputFile);
		int lineNumber = 0;
		ArrayList<String> minedStyle = new ArrayList<>();
		//System.out.println("INSIDE BRACE STYLE" + inputFile);
		ArrayList<String> methodList = generateMethods(inputFile);
		
		while (scr.hasNextLine()) { 		// getting each line of the input program
			lineNumber = lineNumber + 1;
			String currentLine = scr.nextLine();
			for (String key : methodList) {
				//System.out.println(findMethodStyle(currentLine, key));
				minedStyle.addAll(findMethodStyle(currentLine, key));

			}
		}
		//System.out.println(minedStyle);
		scr.close();
		if (Collections.frequency(minedStyle, "Next Line") > Collections
				.frequency(minedStyle, "Same Line"))
			// System.out.println("insert");
			return "next line";
		else
			// System.out.println("do not insert");
			return "same line";
		// return null;
	}

	ArrayList<String> findMethodStyle(String lineToCheck,
			String methodName) {
		String stringToSearch = lineToCheck;
		Pattern pattern = Pattern.compile(methodName);
		Matcher matcher = pattern.matcher(stringToSearch);
		ArrayList<String> tokenPosition = new ArrayList<String>();

		while (matcher.find()) {
			//System.out.println(matcher.find());
			String[] result = stringToSearch.split("\\)");
			
			if (result[1].replaceAll("\\s", "").length()==0)	// can be
																// replaced by
																// isEmpty()
																// method
				tokenPosition.add("Next Line");
			else
				tokenPosition.add("Same Line");
		}
		//System.out.println(tokenPosition);
		return tokenPosition;
	}

	/*Field[] findFieldNames(String className) throws Exception {
		Class cls = Class.forName(className);
		Field[] fieldList = cls.getDeclaredFields();
		
		return fieldList;
	}*/

	/*Method[] findMethodNames(String className) throws Exception {
		Class cls = Class.forName(className);
		Method methodList[] = cls.getDeclaredMethods();

		return methodList;
	}*/
	
	ArrayList<String> generateMethods(String sourceFile){
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(sourceFile.toCharArray());
		//parser.setSource("/*abc*/".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		//ASTNode node = parser.createAST(null);
		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
		ArrayList<String> methodNames = new ArrayList<String>();
 
		cu.accept(new ASTVisitor() {
 
			public boolean visit(MethodDeclaration node) {
				SimpleName name = node.getName();
				//System.out.println("Declaration of '"+name+"' at line"+cu.getLineNumber(name.getStartPosition()));
				//System.out.println(name);
				String nm=name.toString();
				methodNames.add(nm);
				return false; // do not continue to avoid usage info
			}
		});
		return methodNames;
	}
	
	String bracePositionForSwitch(String inputFile) throws Exception {
		int lineNumber = 0;
		String currentLine = null;
		HashMap<Integer, String> inputProgram = new HashMap<>();
		ArrayList<String> minedStyle = new ArrayList<>();
		
		Scanner scr = new Scanner(inputFile);
		
		while (scr.hasNextLine()) {
			lineNumber++;
			currentLine = scr.nextLine();
			inputProgram.put(lineNumber, currentLine);
			minedStyle.addAll(findSwitch(currentLine));
			
		}
		scr.close();
		if (Collections.frequency(minedStyle, "Next Line") > Collections
				.frequency(minedStyle, "Same Line"))
			// System.out.println("insert");
			return "next line";
		else
			// System.out.println("do not insert");
			return "same line";
		}
	
	ArrayList<String> findSwitch(String lineToCheck) {
		String stringToSearch = lineToCheck;
		Pattern pattern = Pattern.compile("\\b(switch)\\b");
		Matcher matcher = pattern.matcher(stringToSearch);
		ArrayList<String> tokenPosition = new ArrayList<String>();

		while (matcher.find()) {
			String[] result = stringToSearch.split("\\)");
			
			if (result[1].replaceAll("\\s", "").length()==0)	// can be
																// replaced by
																// isEmpty()
																// method
				tokenPosition.add("Next Line");
			else
				tokenPosition.add("Same Line");
		}
		return tokenPosition;
	}

}
