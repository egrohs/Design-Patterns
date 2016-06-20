package creational;
/**
 * Prototype Class
 */
abstract class PrototypeFactory implements Cloneable {
	public PrototypeFactory clone() throws CloneNotSupportedException {
		// call Object.clone()
		PrototypeFactory copy = (PrototypeFactory) super.clone();
		// In an actual implementation of this pattern you might now change
		// references to
		// the expensive to produce parts from the copies that are held inside
		// the prototype.
		return copy;
	}

	abstract void prototypeFactory(int x);

	abstract void printValue();
}

/**
 * Concrete Prototypes to clone
 */
class PrototypeImpl extends PrototypeFactory {
	int x;

	public PrototypeImpl(int x) {
		this.x = x;
	}

	@Override
	void prototypeFactory(int x) {
		this.x = x;
	}

	public void printValue() {
		System.out.println("Value :" + x);
	}
}

/**
 * Client Class
 */
public class Prototype {

	private PrototypeFactory example; // Could have been a private Cloneable
										// example.

	public Prototype(PrototypeFactory example) {
		this.example = example;
	}

	public PrototypeFactory makeCopy() throws CloneNotSupportedException {
		return this.example.clone();
	}

	public static void main(String args[]) {
		try {
			PrototypeFactory tempExample = null;
			int num = 1000;
			PrototypeFactory prot = new PrototypeImpl(1000);
			Prototype cm = new Prototype(prot);
			for (int i = 0; i < 10; i++) {
				tempExample = cm.makeCopy();
				tempExample.prototypeFactory(i * num);
				tempExample.printValue();
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}