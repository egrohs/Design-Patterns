package behavorial;

/**
 * Allow an object to alter its behavior when its internal state changes. The
 * object will appear to change its class. The state interface and two
 * implementations. The state method has a reference to the context object and
 * is able to change its state.
 */
interface IState {
	public void writeName(StateContext stateContext, String name);
}

class StateA implements IState {
	public void writeName(StateContext stateContext, String name) {
		System.out.println(name.toLowerCase());
		stateContext.setState(new StateB());
	}
}

class StateB implements IState {
	private int count = 0;

	public void writeName(StateContext stateContext, String name) {
		System.out.println(name.toUpperCase());
		if (++count > 1) {
			stateContext.setState(new StateA());
		}
	}
}

/**
 * The context class, it has a state variable which it instantiates in an
 * initial state, in this case StateA. In its method, it uses then the
 * correspondent methods of the state object.
 */
class StateContext {
	private IState myState;

	public StateContext() {
		setState(new StateA());
	}

	// normally only called by classes implementing the State interface
	public void setState(IState stateName) {
		this.myState = stateName;
	}

	public void writeName(String name) {
		this.myState.writeName(this, name);
	}
}

public class State {
	public static void main(String[] args) {
		StateContext sc = new StateContext();
		sc.writeName("Monday");
		sc.writeName("Tuesday");
		sc.writeName("Wednesday");
		sc.writeName("Thursday");
		sc.writeName("Saturday");
		sc.writeName("Sunday");
	}
}