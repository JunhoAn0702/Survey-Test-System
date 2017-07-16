/**
 * SE 311 - 002
 * 03/01/2017
 * Junho An.
 */

/**
 * Validation class
 * This is a class to validate user's input.
 */
public class Validation {
	
	/**
	 * checkInteger.
	 * This method checks whether the input is an integer.
	 * @param input the input
	 * @return true, if the input is an integer
	 */
	public static boolean checkInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException ne) {
			System.out.println(input + " is not an integer.");
			return false;
		}
	}
	
	/**
	 * onlyOneTwo. 
	 * This method checks whether the input is "1" or "2".
	 * @param input the input
	 * @return true, if the input is "1" or "2".
	 */
	public static boolean onlyOneTwo(String input) {
		if (!checkInteger(input)) {
			return false;
		}
		if (input.equals(Constants.ONE) || input.equals(Constants.TWO)) {
			return true;
		}
		System.out.println(Constants.ONLY_ONE_TWO_ERROR);
		return false;
	}
	
	/**
	 * checkNull.
	 * This method checks whether the input is null.
	 * @param input the input
	 * @return true, if the input is not null.
	 */
	public static boolean checkNull(String input){
		if(input == null || input.trim().length() == 0){
			System.out.println(Constants.NULL_ERROR);
			return false;
		}
		else{
			return true;
		}
	}
	
	/**
	 * checkCommaNull.
	 * This method checks whether the input is null or starts/ends 
	 * with comma. 
	 * @param input the input
	 * @return true, if successful
	 */
	public static boolean checkCommaNull(String input){
		if(!checkNull(input)){
			return false;
		}
		if(input.trim().startsWith(Constants.COMMA)){
			System.out.println(Constants.COMMA_START_ERROR);
			return false;
		}
		else if(input.trim().endsWith(Constants.COMMA)){
			System.out.println(Constants.COMMA_END_ERROR);
			return false;
		}
		return true;
	}
	
	/**
	 * checkCommaNullContain.
	 * This method checks whether the input is null or contains comma
	 * 
	 * @param input the input
	 * @return true, if successful
	 */
	public static boolean checkCommaNullContain(String input){
		if(!checkNull(input)){
			return false;
		}
		else if(input.contains(Constants.COMMA)){
			System.out.println(Constants.COMMA_CONTAIN_ERROR);
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * checkYesOrNo.
	 * This method checks whether the input is either "yes" or
	 * "no" in both lower and upper cases.
	 * @param input the input
	 * @return true, if successful
	 */
	public static boolean checkYesOrNo(String input) {
		if (!checkNull(input)) {
			return false;
		} else if (input.equalsIgnoreCase(Constants.YES)
				|| input.equalsIgnoreCase(Constants.NO)) {
			return true;
		}
		System.out.println(Constants.INVALID_INPUT_ERROR);
		return false;
	}
}
