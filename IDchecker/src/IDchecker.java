import java.util.Scanner;

public class IDchecker {

	static String idOPEN = " ";
	private static Scanner input;
	public static void main(String[] args) {
		System.out.println("What did you just call me?!");
		System.out.println(checkID());
		System.out.println(results(idOPEN));
	}

	public static String checkID() {
		System.out.println(" ");
		System.out.println("Enter your java identifier...");
		String yourID = "";
		input = new Scanner(System.in);
			if(input.hasNext()) {
				yourID = input.next();
				idOPEN = yourID;
			}
		
		return ("Your identifier is " + yourID + "\n\n Analyzing...");
	}
	
	public static boolean badWords( String id) {
		String[] keywords = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", 
				"char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
				"for", "goto", "if", "implements" , "import", "instanceof",	"int", "interface", "long",	"native", "new", "package",
				"private", "protected",	"public", "return", "short", "static", "strictfp", "super", "switch", "synchronized",  "this",
				"throw", "throws", "transient", "try", "void", "volatile",	"while", "true", "false", "null"};
		for(int i =0; i < keywords.length; i++) {
			if (keywords[i].equals(id)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean theRule(char testIt) {
		if((testIt >= 'a' && testIt <= 'z') || (testIt >= 'A' && testIt <= 'Z') || (testIt == '_') || testIt == '$') {
			return true;
		}
		
		return false;
	}
	
	public static boolean checkRules(String id) {
		char [] convertID = id.toCharArray();
		if(theRule(convertID[0])){
			for(int i = 0; i <convertID.length; i++) {
				if(!theRule(convertID[i]) && !Character.isDigit(convertID[i])) {
					return false;
				}
			}
		}else {
			return false;
		}
		
		return true;
	}
	
	public static String results(String id) {
		
		
		if(checkRules(id) && !badWords(id)) {
			
			return ("\nI like that name. That is a legal identifier.");
		}else {
			 return ("\nThat is not a legal identifier. The police are on their way...");
		}
	}
}
