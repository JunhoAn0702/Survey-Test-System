/**
 * SE 311 - 002
 * 03/01/2017
 * Junho An.
 */

/**
 * An asynchronous update interface for receiving notifications
 * about Print information as the Print is constructed.
 * PrintObserver class that implements Observer interface.
 */
public class PrintObserver implements Observer {

	// Implementing update method from the interface
	// Update that triggers an event printOutput() method.
	@Override
	public void update(Event event) {
		event.printOutput();
		
	}
	

}
