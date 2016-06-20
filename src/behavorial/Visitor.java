package behavorial;

/**
 * The following example is in the Java programming language, and shows how the
 * contents of a tree of nodes (in this case describing the components of a car)
 * can be printed. Instead of creating "print" methods for each subclass (Wheel,
 * Engine, Body, and Car), a single class (CarElementPrintVisitor) performs the
 * required printing action. Because different subclasses require slightly
 * different actions to print properly, CarElementDoVisitor dispatches actions
 * based on the class of the argument passed to it.
 */
interface CarElementVisitor {
	void visit(Wheel wheel);

	void visit(Engine engine);

	void visit(Body body);

	void visit(Car car);
}

interface CarElement {
	void accept(CarElementVisitor visitor); // CarElements have to provide
	// accept().
}

class Wheel implements CarElement {
	private String name;

	Wheel(String name) {
		this.name = name;
	}

	String getName() {
		return this.name;
	}

	public void accept(CarElementVisitor visitor) {
		visitor.visit(this);
	}
}

class Engine implements CarElement {
	public void accept(CarElementVisitor visitor) {
		visitor.visit(this);
	}
}

class Body implements CarElement {
	public void accept(CarElementVisitor visitor) {
		visitor.visit(this);
	}
}

class Car implements CarElement {
	CarElement[] elements;

	public CarElement[] getElements() {
		return elements.clone(); // Return a copy of the array of references.
	}

	public Car() {
		this.elements = new CarElement[] { new Wheel("front left"), new Wheel("front right"), new Wheel("back left"),
				new Wheel("back right"), new Body(), new Engine() };
	}

	public void accept(CarElementVisitor visitor) {
		for (CarElement element : this.getElements()) {
			element.accept(visitor);
		}
		visitor.visit(this);
	}

}

class CarElementPrintVisitor implements CarElementVisitor {
	public void visit(Wheel wheel) {
		System.out.println("Visiting " + wheel.getName() + " wheel");
	}

	public void visit(Engine engine) {
		System.out.println("Visiting engine");
	}

	public void visit(Body body) {
		System.out.println("Visiting body");
	}

	public void visit(Car car) {
		System.out.println("Visiting car");
	}
}

class CarElementDoVisitor implements CarElementVisitor {
	public void visit(Wheel wheel) {
		System.out.println("Kicking my " + wheel.getName() + " wheel");
	}

	public void visit(Engine engine) {
		System.out.println("Starting my engine");
	}

	public void visit(Body body) {
		System.out.println("Moving my body");
	}

	public void visit(Car car) {
		System.out.println("Starting my car");
	}

}

public class Visitor {
	public static void main(String[] args) {
		Car car = new Car();
		car.accept(new CarElementPrintVisitor());
		car.accept(new CarElementDoVisitor());
	}
}