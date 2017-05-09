package SmartCodeStyler;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLBuilder {
	void createXML(String inputFile, String xmlFileNm, String className) {
		try {
			String xmlFileName = xmlFileNm;
			String outputFileName = "C:\\Users\\Kalyan Sikdar\\Desktop\\"
					+ xmlFileName + ".xml";
			System.out.println(outputFileName);
			// List all feature names below
			String featureNo1 = "insert_new_line_before_finally_in_try_statement";
			String featureNo2 = "lineSplit";
			String featureNo3 = "insert_new_line_before_else_in_if_statement";
			String featureNo4 = "insert_space_before_assignment_operator";
			String featureNo5 = "insert_space_after_assignment_operator";
			String featureNo6 = "brace_position_for_method_declaration";
			String featureNo7 = "blank_lines_before_package";
			String featureNo8 = "brace_position_for_switch";
			String featureNo9 = "insert_space_before_binary_operator";
			String featureNo10 = "insert_space_after_binary_operator";
			String featureNo11 = "insert_space_before_prefix_operator";
			String featureNo12 = "insert_space_after_prefix_operator";
			// Feature Class details
			String featureClass = "org.eclipse.jdt.core.formatter.";
			// Feature Name with class details
			featureNo1 = featureClass + featureNo1;
			featureNo2 = featureClass + featureNo2;
			featureNo3 = featureClass + featureNo3;
			featureNo4 = featureClass + featureNo4;
			featureNo5 = featureClass + featureNo5;
			featureNo6 = featureClass + featureNo6;
			featureNo7 = featureClass + featureNo7;
			featureNo8 = featureClass + featureNo8;
			featureNo9 = featureClass + featureNo9;
			featureNo10 = featureClass + featureNo10;
			featureNo11 = featureClass + featureNo11;
			featureNo12 = featureClass + featureNo12;
			// Method calls - To call the method to retrieve each feature's
			// return value
			ControlStatementStyler controlStatementStyler = new ControlStatementStyler();
			WhiteSpacePosition whiteSpacePosition = new WhiteSpacePosition();
			BracePositions bracePositions = new BracePositions();
			BlankLines blankLines = new BlankLines();
			
			
			String CheckLineBeforeFinallyDecision = controlStatementStyler
					.checkNewLineBeforeFinally(inputFile);
			String checkIfElseInOneLineDecision = controlStatementStyler
					.newlineBeforeElse(inputFile);
			String splitValue = String.valueOf(calculateLineSplit(inputFile));
			String featureFourDecision = whiteSpacePosition
					.checkSpaceBeforeAssignmentOperatorStyle(
							inputFile);
			String featureFiveDecision = whiteSpacePosition
					.checkSpaceAfterAssignmentOperatorStyle(inputFile);
			
			//String featureSixDecision = bracePositions.braceStyleForMethod(inputFile);
			String featureSevenDecision = blankLines.blankLinesBeforePackage(inputFile);
			String featureEightDecision = bracePositions.bracePositionForSwitch(inputFile);
			String featureNineDecision = whiteSpacePosition.checkSpaceBeforeBinaryOperatorStyle(inputFile);
			String featureTenDecision = whiteSpacePosition.checkSpaceAfterBinaryOperatorStyle(inputFile);
			String featureElevenDecision = whiteSpacePosition.checkSpaceBeforePrefixOperatorStyle(inputFile);
			String featureTwelveDecision = whiteSpacePosition.checkSpaceAfterPrefixOperatorStyle(inputFile);
			
			// XML Styling starts here
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory
					.newDocumentBuilder();

			Document document = documentBuilder.newDocument();

			Element profiles = document.createElement("profiles");
			document.appendChild(profiles);
			Attr attr_profiles = document.createAttribute("version");
			attr_profiles.setValue("12");
			profiles.setAttributeNode(attr_profiles);

			Element profile = document.createElement("profile");
			profiles.appendChild(profile);

			Attr attr_profile = document.createAttribute("kind");
			attr_profile.setValue("CodeFormatterProfile");
			profile.setAttributeNode(attr_profile);

			Attr attr_profile1 = document.createAttribute("name");
			attr_profile1.setValue("CodeStyler");
			profile.setAttributeNode(attr_profile1);

			Attr attr_profile2 = document.createAttribute("version");
			attr_profile2.setValue("12");
			profile.setAttributeNode(attr_profile2);
			// Setting element for feature 1

			Element setting1 = document.createElement("setting");
			profile.appendChild(setting1);

			Attr attr_setting1 = document.createAttribute("id");
			attr_setting1.setValue(featureNo1);
			setting1.setAttributeNode(attr_setting1);

			Attr attr_setting2 = document.createAttribute("value");
			attr_setting2.setValue(CheckLineBeforeFinallyDecision);
			setting1.setAttributeNode(attr_setting2);

			// Setting element for feature 2
			Element setting2 = document.createElement("setting");
			profile.appendChild(setting2);

			Attr attr_setting3 = document.createAttribute("id");
			attr_setting3.setValue(featureNo2);
			setting2.setAttributeNode(attr_setting3);

			Attr attr_setting4 = document.createAttribute("value");
			attr_setting4.setValue(splitValue);
			setting2.setAttributeNode(attr_setting4);

			// Setting element for feature 3
			Element setting3 = document.createElement("setting");
			profile.appendChild(setting3);

			Attr attr_setting5 = document.createAttribute("id");
			attr_setting5.setValue(featureNo3);
			setting3.setAttributeNode(attr_setting5);

			Attr attr_setting6 = document.createAttribute("value");
			attr_setting6.setValue(checkIfElseInOneLineDecision);
			setting3.setAttributeNode(attr_setting6);

			// Setting element for feature 4
			Element setting4 = document.createElement("setting");
			profile.appendChild(setting4);

			Attr attr_setting7 = document.createAttribute("id");
			attr_setting7.setValue(featureNo4);
			setting4.setAttributeNode(attr_setting7);

			Attr attr_setting8 = document.createAttribute("value");
			attr_setting8.setValue(featureFourDecision);
			setting4.setAttributeNode(attr_setting8);

			// Setting element for feature 5
			Element setting5 = document.createElement("setting");
			profile.appendChild(setting5);

			Attr attr_setting9 = document.createAttribute("id");
			attr_setting9.setValue(featureNo5);
			setting5.setAttributeNode(attr_setting9);

			Attr attr_setting10 = document.createAttribute("value");
			attr_setting10.setValue(featureFiveDecision);
			setting5.setAttributeNode(attr_setting10);
			
			/*// Setting element for feature 6
			Element setting6 = document.createElement("setting");
			profile.appendChild(setting6);

			Attr attr_setting11 = document.createAttribute("id");
			attr_setting11.setValue(featureNo6);
			setting6.setAttributeNode(attr_setting11);

			Attr attr_setting12 = document.createAttribute("value");
			attr_setting12.setValue(featureSixDecision);
			setting6.setAttributeNode(attr_setting12);*/
			
			// Setting element for feature 7
			Element setting7 = document.createElement("setting");
			profile.appendChild(setting7);

			Attr attr_setting13 = document.createAttribute("id");
			attr_setting13.setValue(featureNo7);
			setting7.setAttributeNode(attr_setting13);

			Attr attr_setting14 = document.createAttribute("value");
			attr_setting14.setValue(featureSevenDecision);
			setting7.setAttributeNode(attr_setting14);
			
			// Setting element for feature 8
			Element setting8 = document.createElement("setting");
			profile.appendChild(setting8);

			Attr attr_setting15 = document.createAttribute("id");
			attr_setting15.setValue(featureNo8);
			setting8.setAttributeNode(attr_setting15);

			Attr attr_setting16 = document.createAttribute("value");
			attr_setting16.setValue(featureEightDecision);
			setting8.setAttributeNode(attr_setting16);
			
			// Setting element for feature 9
			Element setting9 = document.createElement("setting");
			profile.appendChild(setting9);

			Attr attr_setting17 = document.createAttribute("id");
			attr_setting17.setValue(featureNo9);
			setting9.setAttributeNode(attr_setting17);

			Attr attr_setting18 = document.createAttribute("value");
			attr_setting18.setValue(featureNineDecision);
			setting9.setAttributeNode(attr_setting18);
			
			// Setting element for feature 10
			Element setting10 = document.createElement("setting");
			profile.appendChild(setting10);

			Attr attr_setting19 = document.createAttribute("id");
			attr_setting19.setValue(featureNo10);
			setting10.setAttributeNode(attr_setting19);

			Attr attr_setting20 = document.createAttribute("value");
			attr_setting20.setValue(featureTenDecision);
			setting10.setAttributeNode(attr_setting20);
			
			// Setting element for feature 11
			Element setting11 = document.createElement("setting");
			profile.appendChild(setting11);

			Attr attr_setting21 = document.createAttribute("id");
			attr_setting21.setValue(featureNo11);
			setting11.setAttributeNode(attr_setting21);

			Attr attr_setting22 = document.createAttribute("value");
			attr_setting22.setValue(featureElevenDecision);
			setting11.setAttributeNode(attr_setting22);
						
			// Setting element for feature 12
			Element setting12 = document.createElement("setting");
			profile.appendChild(setting12);

			Attr attr_setting23 = document.createAttribute("id");
			attr_setting23.setValue(featureNo12);
			setting12.setAttributeNode(attr_setting23);

			Attr attr_setting24 = document.createAttribute("value");
			attr_setting24.setValue(featureTwelveDecision);
			setting12.setAttributeNode(attr_setting24);

			// Steps to generate output in a separate file/output console and
			// indentation formatting
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			// Output to xml file

			StreamResult result = new StreamResult(new File(outputFileName));
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
			// transformer.transform(source, result);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.transform(source, result);
			System.out.println("XML File saved!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	int calculateLineSplit(String inputFile) {
		Scanner scr = new Scanner(inputFile);
		int lineNumber = 0, maxCharCount = 0;
		while (scr.hasNextLine()) {
			lineNumber = lineNumber + 1;
			String currentLine = scr.nextLine();
			int numberOfCharacter = currentLine.length();
			if (numberOfCharacter > maxCharCount)
				maxCharCount = numberOfCharacter;
		}
		scr.close();
		return maxCharCount;
	}
}
