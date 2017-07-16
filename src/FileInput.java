/**
 * SE 311 - 002
 * 03/01/2017
 * Junho An.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The Class FileInput.
 * FileInput class that implements Input interface.
 */
public class FileInput implements Input{

	/** The file name. */
	private String fileName;
	
	// Implementing readInput method from the interface
	@Override
	public void readInput(LineStorage lineStorage) {
		
		// Ask user to type the file name.
		this.askFileName();
		try {
			// Load the file
			FileInputStream file = new FileInputStream("./" + fileName);
			// Read the file
			@SuppressWarnings("resource")
			BufferedReader buf = new BufferedReader(new InputStreamReader(file));
			// Loop the iterate the lines in the file and put lines to the pipe.
			while (true) {
				String line = buf.readLine();
				if (line == null) {
					break;
				}
				if (line.trim().length() != 0) {
					lineStorage.addLine(line.trim());
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(Constants.FILE_NOT_FOUND);
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Ask file name.
	 * Asks the user to enter the file name.
	 */
	private void askFileName() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// While loop to get the existing file name from the user.
		while (true) {
			try {
				System.out.println(Constants.FILE_INPUT_MESSAGE);
				fileName = br.readLine();
				try {
					// Read the file and put all characters to one
					// string.
					FileInputStream file = new FileInputStream("./" + fileName);

					@SuppressWarnings({ "unused", "resource" })
					BufferedReader buf = new BufferedReader(
							new InputStreamReader(file));
					break;
				} catch (Exception e) {
					// Print the error message when the file
					// doesn't exist.
					System.out.println(Constants.FILE_INPUT_ERROR);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
