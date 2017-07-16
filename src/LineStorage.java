/**
 * SE 311 - 002
 * 03/01/2017
 * Junho An.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * The Class LineStorage.
 * LineSotrage is to store the list of lines interactively.
 */
public class LineStorage extends Subject{
	
	/** The input string list. */
	public List<String> inputStringList = new ArrayList<String>();
	
	/** The event. */
	public Event event = new Event(inputStringList);
	
	/**
	 * Adds the line.
	 *
	 * @param input the input
	 */
	public void addLine(String input){
		// Add the line to the list.
		this.inputStringList.add(input);
	}
}
