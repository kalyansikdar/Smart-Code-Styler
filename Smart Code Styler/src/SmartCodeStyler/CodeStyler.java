/* Smart Code Styler
 * Author : Kalyan Sikdar
 * Advanced Software Engineering : Dr. Csallner
*/
package SmartCodeStyler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CodeStyler {

	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));) {
			System.out.println("Please Enter the Input File Name: ");
			// Scanner object named 'input' takes the file path and name as
			// input provided by user
			// br = new BufferedReader(new InputStreamReader(System.in,
			// StandardCharsets.UTF_8)); -- Ignoring this bug as it not possible
			// to know the metadata of every input file

			String className = br.readLine();
			String input = "C:\\SmartCodeStyler\\Test Source Code\\" + className
					+ ".java";
			System.out.println("Entered File Name: " + input);
			File inputFile = new File(input);

			while (!inputFile.exists()) {
				System.out.println("Please Enter the Correct Input File Path:");
				if (!("").equals(br.readLine()))
					input = br.readLine();
				inputFile = new File(input, "UTF-8");
			}

			// Store mining start time
			String startTime = getCurrentTimeStamp();
			//filter comments
			String filteredFile = filterInput(inputFile);
			/*
			 * System.out.println("Please Enter expected XML File Name"); input2
			 * = new Scanner(System.in, "UTF-8"); // FB Bug - input String/file
			 * encoding must be specified String xmlFileName =
			 * input2.nextLine();
			 */
			String xmlFileName = "minedStyle";
			System.out.println("User's Expected XML file name : " + xmlFileName);

			// Calls createXML() method
			XMLBuilder xmlBuilder = new XMLBuilder();
			xmlBuilder.createXML(filteredFile, xmlFileName, className);
			
			System.out.println("Style Mining Start Time : " + startTime);
			System.out.println("Style Mining End Time : " + getCurrentTimeStamp());

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	public static String getCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");// dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}

	// Method - filterInput(File) filters the comments of the input program
	static String filterInput(File inputFile) throws Exception {
		try (InputStreamReader br = new InputStreamReader(new FileInputStream(inputFile), "UTF-8")) {
			StringBuilder builder = new StringBuilder();
			int c;
			while ((c = br.read()) != -1)
				builder.append((char) c);
			String fileData = builder.toString();
			// Remove comments
			String fileWithoutComments = fileData.replaceAll("([\\t ]*\\/\\*(?:.|\\R)*?\\*\\/[\\t ]*\\R?)|(\\/\\/.*)",
					"");
			return fileWithoutComments;
		}
	}
}
