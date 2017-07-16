/**
 * SE 311 - 002
 * 03/01/2017
 * Junho An.
 */

/**
 * An asynchronous update interface for receiving notifications
 * about Add information as the Add is constructed.
 * AddObserver class that implements Observer interface.
 */
public class AddObserver implements Observer {

	// Implementing update method from the interface
	// Update that triggers an event addLine() method.
	@Override
	public void update(Event event) {
		event.addLine();
	}

}
