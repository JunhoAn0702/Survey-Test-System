/**
 * SE 311 - 002
 * 03/01/2017
 * Junho An.
 */

/**
 * An asynchronous update interface for receiving notifications
 * about Delete information as the Delete is constructed.
 * DeleteObserver class that implements Observer interface.
 */
public class DeleteObserver implements Observer {

	// Implementing update method from the interface
	// Update that triggers an event deleteLine() method.
	@Override
	public void update(Event event) {
		event.deleteLine();
	}

}
