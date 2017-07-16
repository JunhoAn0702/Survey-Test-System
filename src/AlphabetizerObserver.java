/**
 * SE 311 - 002
 * 03/01/2017
 * Junho An.
 */

/**
 * An asynchronous update interface for receiving notifications
 * about Alphabetizer information as the Alphabetizer is constructed.
 * AlphabetizerObserver class that implements Observer interface.
 */
public class AlphabetizerObserver implements Observer {

	// Implementing update method from the interface
	// Update that triggers an event sort() method.
	@Override
	public void update(Event event) {
		event.sort();
	}

}
