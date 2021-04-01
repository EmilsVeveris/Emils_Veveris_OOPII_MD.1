package utils;

public class DataVerification {
	
	public static String nameAndSurnameVerificaton(String input) {
		String result = "";

		for (int i = 0; i < input.length(); i++) {
			if (Character.isLetter(input.charAt(i)) || Character.isSpaceChar(input.charAt(i)) || input.charAt(i) == 45) {
				result += input.charAt(i);
			}
		}

		return result;

	}
	
	public static String idenNrVerificaton(String input) {
		String result = "";

		for (int i = 0; i < input.length(); i++) {
			if (Character.isDigit(input.charAt(i)) || Character.isSpaceChar(input.charAt(i)) || input.charAt(i) == 45) {
				result += input.charAt(i);
			}
		}

		return result;

	}
	
	public static boolean isLetterOrSpaceOrDefise(String input)
	{
		if(input.matches("[A-Z}{1}[a-z]+$"))
			return true;
		else
			return false;
	}

}
