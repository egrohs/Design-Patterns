package behavorial;

/**
 * Consider a "simple" switch. In this example we configure the Switch with 2
 * commands: to turn the light on and to turn the light off.
 * 
 * A benefit of this particular implementation of the command Pattern is that
 * the switch can be used with any device, not just a light - the Switch in the
 * following example turns a light on and off, but the Switch's constructor is
 * able to accept any subclasses of Command for its 2 parameters. For example,
 * you could configure the Switch to start an engine.
 * 
 * Note, a criticism of the sample application below is that it doesn't truly
 * model an electrical circuit. An electrical switch is dumb. A true binary
 * switch knows only that it is either on or off. It does not know about or have
 * any direct relationship with the various loads that might be attached to a
 * circuit (ie. you hook up a switch to a circuit, not directly to a load). The
 * switch should simply publish an event of its current state (either an ON or
 * OFF). The circuit then should contain a State Engine which manages circuit
 * states at various points along it (by listening to switch events) in order to
 * properly accommodate complex circuits with multiple loads and switches. Each
 * load is then conditional to a specific circuit's state (not directly to any
 * specific switch). In conclusion, the switch itself should not be aware of any
 * lamp details.
 */
class Switch {
	// the Invoker class

	private ICommand flipUpCommand;
	private ICommand flipDownCommand;

	public Switch(ICommand flipUpCmd, ICommand flipDownCmd) {
		this.flipUpCommand = flipUpCmd;
		this.flipDownCommand = flipDownCmd;
	}

	public void flipUp() {
		flipUpCommand.execute();
	}

	public void flipDown() {
		flipDownCommand.execute();
	}
}

/* Receiver class */
class Light {

	public Light() {
	}

	public void turnOn() {
		System.out.println("The light is on");
	}

	public void turnOff() {
		System.out.println("The light is off");
	}
}

/* the Command interface */
interface ICommand {
	void execute();
}

/* the Command for turning on the light */
class FlipUpCommand implements ICommand {

	private Light theLight;

	public FlipUpCommand(Light light) {
		this.theLight = light;
	}

	public void execute() {
		theLight.turnOn();
	}
}

/* the Command for turning off the light */
class FlipDownCommand implements ICommand {

	private Light theLight;

	public FlipDownCommand(Light light) {
		this.theLight = light;
	}

	public void execute() {
		theLight.turnOff();
	}
}

/* The test class or client */
public class Command {

	public static void main(String[] args) {
		Light lamp = new Light();
		ICommand switchUp = new FlipUpCommand(lamp);
		ICommand switchDown = new FlipDownCommand(lamp);

		// See criticism of this model above:
		// The switch itself should not be aware of lamp details (switchUp,
		// switchDown)
		// either directly or indirectly
		Switch s = new Switch(switchUp, switchDown);

		try {
			if (args[0].equalsIgnoreCase("ON")) {
				s.flipUp();
			} else if (args[0].equalsIgnoreCase("OFF")) {
				s.flipDown();
			} else {
				System.out.println("Argument \"ON\" or \"OFF\" is required.");
			}
		} catch (Exception e) {
			System.out.println("Arguments required.");
		}
	}
}