package SmartCodeStyler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class BlankLines {
	String blankLinesBeforePackage(String inputFile) {
		
		Scanner scr = new Scanner(inputFile);
		int lineNumber = 0, targetLineNo=0, minedStyle = 0;
		HashMap<Integer, String> inputProgram = new HashMap<>();
		ArrayList<String> packageList = generatePackage(inputFile);
		String packNm = packageList.get(0);
		
		while (scr.hasNextLine()) {							//getting each line of the input program
			lineNumber++;
			String currentLine = scr.nextLine();
			inputProgram.put(lineNumber, currentLine);
			
			if(ifPackageAvailable(currentLine, packNm)){
				System.out.println(lineNumber);
				targetLineNo=lineNumber;
			}
			}
		scr.close();
		while(targetLineNo > 0)
		{
			if(inputProgram.get(targetLineNo).length() == 0){
				minedStyle++;
			}
			targetLineNo--;
		}
		return String.valueOf(minedStyle);
		}
	
	ArrayList<String> generatePackage(String sourceFile){
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(sourceFile.toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		final org.eclipse.jdt.core.dom.CompilationUnit cu =  (org.eclipse.jdt.core.dom.CompilationUnit)parser.createAST(null);
				//.createAST(null);
		ArrayList<String> packageName = new ArrayList<String>();
		
		cu.accept(new ASTVisitor() {
			public boolean visit(CompilationUnit node){
				packageName.add(node.getPackage().getName().toString());
				return false;
			}
		});
 
		/*cu.accept(new ASTVisitor() {
 
			public boolean visit(CompilationUnit node) {
				//System.out.println(node.getPackage().getName());
				packageName.add(node.getPackage().getName().toString());
				return false; // do not continue to avoid usage info
			}
		});*/
		return packageName;
	}
	
	Boolean ifPackageAvailable(String lineToCheck,
			String packageName) {
		String stringToSearch = lineToCheck;
		Pattern pattern = Pattern.compile(packageName);
		Matcher matcher = pattern.matcher(stringToSearch);
		Boolean ifFound = false;

		while (matcher.find()) {
			ifFound = true;
		}
		return ifFound;
	}

}
