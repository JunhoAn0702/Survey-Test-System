/**
 * SE 311 - 002
 * 03/01/2017
 * Junho An.
 */

/**
 * An asynchronous update interface for receiving notifications
 * about CircularShifter information as the CircularShifter is constructed.
 * CircularShifterObserver class that implements Observer interface.
 */
public class CircularShifterObserver implements Observer {

	// Implementing update method from the interface
	// Update that triggers an event circularShift() method.
	@Override
	public void update(Event event) {
		event.circularShift();
	}

}
