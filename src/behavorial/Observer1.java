package behavorial;

import java.util.ArrayList;
import java.util.List;

interface IObserver {
	void update(String state);
}

/**
 * Two implementations of the Observer interface. Each implement the update
 * method where they update their own state.
 */
public class Observer1 implements IObserver {
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void update(String state) {
		setState(state);
		System.out.println("Observer1 has received update signal with new state: " + getState());
	}
}

class Observer2 implements IObserver {
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void update(String state) {
		setState(state);
		System.out.println("Observer2 has received update signal with new state: " + getState());
	}
}

/**
 * This is the LogSubject which get observed by the Observers. It maintains a
 * list of Observers. Everytime its state is changed, it runs the update method
 * of all of the observers in its list changing their states as well.
 */
class LogSubject {
	private List<IObserver> observerList = new ArrayList<IObserver>();
	private String state;

	public String getState() {
		return state;
	}

	public void attach(IObserver observer) {
		observerList.add(observer);
	}

	public void detach(IObserver observer) {
		observerList.remove(observer);
	}

	public void setState(String state) {
		this.state = state;
		stateChanged();
	}

	private void stateChanged() {
		for (IObserver item : observerList) {
			item.update(getState());
		}
	}
}

// And here the usage of the pattern above:
class ObserverZ {
	public static void main(String[] args) {
		LogSubject subject = new LogSubject();
		IObserver ob1 = new Observer1();
		IObserver ob2 = new Observer2();
		subject.attach(ob1);
		subject.attach(ob2);
		subject.setState("state1");
		subject.setState("state2");
		subject.detach(ob1);
		subject.setState("state3");
	}
}