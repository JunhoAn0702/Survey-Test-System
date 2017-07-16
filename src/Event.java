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
import java.util.Collections;
import java.util.List;

/**
 * The Class Event.
 * Event class that contains all events in the Observer.
 */
public class Event {
	
	/** The input string list. */
	private List<String> inputStringList = new ArrayList<String>();
	
	/**
	 * Instantiates a new event.
	 *
	 * @param inputStringList the input string list
	 */
	public Event(List<String> inputStringList){
		this.inputStringList = inputStringList;
	}
	
	/**
	 * Prints the output.
	 */
	public void printOutput(){
		System.out.println(Constants.DASH);
		// If list is empty print empty message otherwise, print the list.
		if(this.inputStringList.isEmpty()){
			System.out.println(Constants.EMPTY);
		}
		else{
			for(String s : inputStringList){
				System.out.println(s);
			}
		}
		System.out.println("");
	}
	
	/**
	 * Adds the line.
	 */
	public void addLine(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		// Retrieve and validate the user input.
		do {
			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(!Validation.checkCommaNullContain(line));
		
		// Add the user input to the list.
		this.inputStringList.add(line.trim());
	}
	
	/**
	 * Delete line.
	 */
	public void deleteLine(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		try {
			// Retrieve the input from the user.
			line = br.readLine();
			// If the list is empty, print the empty message.
			if(this.inputStringList.isEmpty()){
				System.out.println(Constants.EMPTY);
			}
			// If the list contains the user input, remove the input from the list.
			else if(this.inputStringList.contains(line.trim())) {
				this.inputStringList.remove(line.trim());
			}
			// Otherwise, print not-contain message.
			else {
				System.out.println(Constants.NOT_CONTAIN);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Sort.
	 * This sorts the list in alphabetical order.
	 */
	public void sort(){
		Collections.sort(this.inputStringList,
				String.CASE_INSENSITIVE_ORDER);
	}
	
	/**
	 * Circular shift.
	 * For each element in the list, shift the word one by one and add it to the list.
	 */
	public void circularShift() {
		// Iterate the input string list to remove all punctuation
		// and shift each word in each element.
		List<String> outputStringList = new ArrayList<String>();
		for (int i = 0; i < this.inputStringList.size(); i++) {
			// Remove all punctuation.
			this.inputStringList.set(i, this.inputStringList.get(i).replaceAll("\\p{P}", ""));
			// Store each string element separated by space to list.
			List<String> stringList =
				new ArrayList<String>(Arrays.asList(this.inputStringList.get(i).split("\\s+")));
			StringBuilder sb;
			// Iterate the string list to shift each word.
			for (int j = 0; j < stringList.size(); j++) {
				sb = new StringBuilder();
				// Create each word shifted string.
				for (String s : stringList) {
					sb.append(s);
					sb.append(" ");
				}
				// Store the result to output string list.
				outputStringList.add(sb.toString().trim());
				// Shift each word.
				String temp = stringList.get(0);
				stringList.remove(0);
				stringList.add(temp);
			}
		}
		this.inputStringList = outputStringList;
	}
}
