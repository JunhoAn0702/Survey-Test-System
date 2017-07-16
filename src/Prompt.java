/**
 * SE 311 - 002
 * 03/01/2017
 * Junho An.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The Class Prompt.
 */
public class Prompt {
	
	/** The input type. */
	private String inputType;
	
	/**
	 * Gets the input type.
	 *
	 * @return the inputType
	 */
	public String getInputType() {
		return inputType;
	}

	/**
	 * Sets the input type.
	 *
	 * @param inputType the inputType to set
	 */
	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	/**
	 * Instantiates a new prompt.
	 */
	public Prompt() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Displaying the greeting message to the user.
		System.out.println(Constants.GREETING_MESSAGE);
		String input = "";
		// Ask the user how to enter the input, and validate the input. 
		do{
			System.out.println(Constants.HOW_INPUT_MESSAGE);
			try {
				input = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (!Validation.onlyOneTwo(input));
		
		// Setting the inputType
		if(input.equals(Constants.TWO)){
			this.inputType = Constants.CONSOLE;
		}
		else{
			this.inputType = Constants.FILE;
		}
	}
}
