package relran.strings;

public class RegularExpressions {
	public static String javaVariable() {
		String regex = "[A-Za-z$][A-Za-z0-9_$]*|_[A-Za-z0-9_$]+";
		return regex;
	}

	public static String zero_300() {
		String regex = "0|[1-9]\\d?|[1-2]\\d{2}|300"; // \\d*?[02468]
		return regex;
	}
	
	public static String ipOctet() {
		//string contains 1 - 3 symbols presented number from 0 - 255
		
		//disjunction of three regexps
		//0{0,2}\d - covers range from 0 to 9 with optional one or two leading zeroes
		//[01]?\d{2} - covers range from [0]10 to 199
		//2[0-4]\d|25[0-5] - covers range from 200 to 255 and  
		
		String regex ="0{0,2}\\d|[01]?\\d{2}|2[0-4]\\d|25[0-5]";
		return regex;
	}
	
	public static String mobileIsraelNumber() {
		//TODO
		//string
		//+972-<prefix two digits starting with 5>-<7 digits>
		//<prefix three digits with 05>-<7 digits>
		
		String regex = "(\\+972-?|0)5\\d(-?\\d){7}";
		return regex;
	}

}
