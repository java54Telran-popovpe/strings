package relran.strings;

public class Validations {
	 public static boolean isArithmeticExpression( String expression) {
		 //1.Check against RE.
		 //2.Check brackets parity.
		boolean result = false;
		if ( result = expression.matches(RegularExpressions.arithmeticExpression())) {
			int counter = 0;
			int i = 0;
			while( i < expression.length() && counter >= 0 ) {
				if (expression.charAt( i ) == '(' )
					counter++;
				else if (expression.charAt( i ) == ')' )
					counter--;
				i++;
			}
			if ( counter != 0 )
				result = false;
		}
		return result;
	}
//

}
