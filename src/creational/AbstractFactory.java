package creational;

/**
 * The output should be either "I'm a WinButton" or "I'm an OSXButton" depending
 * on which kind of factory was used. Note that the Application has no idea what
 * kind of GUIFactory it is given or even what kind of Button that factory
 * creates.
 */
interface GUIFactory {
	public Button createButton();
}

class WinFactory implements GUIFactory {
	public Button createButton() {
		return new WinButton();
	}
}

class OSXFactory implements GUIFactory {
	public Button createButton() {
		return new OSXButton();
	}
}

interface Button {
	public void paint();
}

class WinButton implements Button {
	public void paint() {
		System.out.println("I'm a WinButton");
	}
}

class OSXButton implements Button {
	public void paint() {
		System.out.println("I'm an OSXButton");
	}
}

class Application {
	public Application(GUIFactory factory) {
		Button button = factory.createButton();
		button.paint();
	}
}

public class AbstractFactory {
	public static void main(String[] args) {
		new Application(createOsSpecificFactory());
	}

	public static GUIFactory createOsSpecificFactory() {
		int sys = 0;// readFromConfigFile("OS_TYPE");
		if (sys == 0) {
			return new WinFactory();
		} else {
			return new OSXFactory();
		}
	}
}