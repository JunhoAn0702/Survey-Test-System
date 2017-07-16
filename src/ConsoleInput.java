/**
 * SE 311 - 002
 * 03/01/2017
 * Junho An.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Class ConsoleInput.
 * ConsoleInput class that implements Input interface.
 */
public class ConsoleInput implements Input{

	/** The yes or no. */
	private String yesOrNo = "";
	
	/** The correct is yes. */
	private Boolean correctIsYes;
	
	/** The empty contains. */
	private Boolean emptyContains;
	
	/** The input string. */
	private String inputString;
	
	/** The input string list. */
	private List<String> inputStringList;
	
	/**
	 * Instantiates a new console input.
	 */
	public ConsoleInput(){
		this.emptyContains = false;
		this.correctIsYes = false;
		this.inputString = "";
		this.inputStringList = new ArrayList<String>();
		this.yesOrNo = "";
	}
	
	// Implementing readInput method from the interface
	@Override
	public void readInput(LineStorage lineStorage) {
		// Do while loop to retrieve console inputs from the user.
		do {
			this.emptyContains = false;
			this.correctIsYes = false;
			this.displayMessage();
			this.setStringInputList();
		} while (this.emptyContains || !this.correctIsYes);
		// Adding the user input to the lineStorage.
		for (String s : inputStringList) {
			lineStorage.addLine(s.trim());
		}
	}
	
	/**
	 * Display message.
	 */
	private void displayMessage() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Do while loop to validate the input.
		do {
			System.out.println(Constants.CONSOLE_INPUT_MESSAGE);
			try {
				inputString = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!Validation.checkCommaNull(this.inputString));
	}
	
	/**
	 * Sets the string input list.
	 */
	private void setStringInputList() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Set the inputString separated by comma to a list
		this.inputStringList = Arrays.asList(this.inputString
				.split("\\s*,\\s*"));
		// Iterate the list to validate each element
		for (String s : this.inputStringList) {
			if (s.trim().length() == 0 || s == null) {
				System.out.println(Constants.STRING_INPUT_MESSAGE);
				emptyContains = true;
				break;
			}
		}
		// If the list passes validation(doesn't contain empty space,
		if (!emptyContains) {
			// Iterate the list to print each element
			for (String s : inputStringList) {
				System.out.println(s);
			}
			// Do while loop to get confirmation from the user.
			do {
				System.out.println(Constants.STRING_INPUT_CORRECT_MESSAGE);
				try {
					yesOrNo = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (!Validation.checkYesOrNo(yesOrNo));
			// Set correctIsYes true only if user types "yes".
			if (yesOrNo.equalsIgnoreCase(Constants.YES)) {
				correctIsYes = true;
			}
		}
	}

}
