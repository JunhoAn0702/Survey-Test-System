/**
 * SE 311 - 002
 * 03/01/2017
 * Junho An.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Subject.
 * Subject class is to notify all events in the observer list.
 */
public class Subject {
	
	/** The observer list. */
	private List<Observer> observerList = new ArrayList<Observer>();
	
	/**
	 * Notify observer.
	 *
	 * @param event the event
	 */
	public void notifyObserver(Event event){
		// update all observers in the observer list.
		for(Observer o : observerList){
			o.update(event);
		}
	}
	
	/**
	 * Adds the observer.
	 *
	 * @param observer the observer
	 */
	public void addObserver(Observer observer){
		// Add the observer to the list.
		observerList.add(observer);
	}
	
	/**
	 * Removes all observers.
	 */
	public void removeObservers(){
		// Initialize the observerList.
		observerList = new ArrayList<Observer>();
	}
	
}
