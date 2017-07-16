/**
 * SE 311 - 002
 * 03/01/2017
 * Junho An.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The Class KWICMain.
 * This is the main class
 */
public class KWICMain {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){

		// Prompt to ask the user how to input.
		Prompt prompt = new Prompt();
		Input input;
		
		// If the user chooses console, initialize input with ConsoleInput class
		// otherwise, initialize with FileInput class.
		if(prompt.getInputType().equals(Constants.CONSOLE)) {
			input = new ConsoleInput();
		}
		else {
			input = new FileInput();
		}
		
		// Initialize Subject with LineStorage class
		Subject sb = new LineStorage();
		
		// Read the input from the sb.
		input.readInput((LineStorage) sb);
		
		
		System.out.println(Constants.INSTRUCTION);
		String userInput = "";
		try {
			Observer ob;
			// Do while loop until the user types "q".
			do{
				System.out.println(Constants.ADD_DELETE_PRINT_QUIT);
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
				userInput = br.readLine();
				
				if(userInput.equals(Constants.A)){
					ob = new AddObserver();
				}
				else if(userInput.equals(Constants.D)){
					ob = new DeleteObserver();
				}
				else if(userInput.equals(Constants.P)){
					ob = new CircularShifterObserver();
					sb.addObserver(ob);
					ob = new AlphabetizerObserver();
					sb.addObserver(ob);
					ob = new PrintObserver();
				}
				else if(userInput.equals(Constants.Q)){
					System.out.println(Constants.EXIT_MESSAGE);
					break;
				}
				else{
					System.out.println(Constants.INVALID_INPUT_ERROR);
					System.out.println(Constants.INSTRUCTION);
					continue;
				}
				
				// Add the observer the user chose, and notify the observer.
				sb.addObserver(ob);
				sb.notifyObserver(new Event(((LineStorage) sb).inputStringList));
				// Remove the added observer.
				sb.removeObservers();
				
			}while(!userInput.equals(Constants.Q));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
