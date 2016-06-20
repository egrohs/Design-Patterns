package creational;
abstract class Pizza2 {
	public abstract double getPrice();
}

class HamAndMushroomPizza extends Pizza2 {
	public double getPrice() {
		return 8.5;
	}
}

class DeluxePizza extends Pizza2 {
	public double getPrice() {
		return 10.5;
	}
}

class HawaiianPizza extends Pizza2 {
	public double getPrice() {
		return 11.5;
	}
}

class PizzaFactory {
	public enum PizzaType {
		HamMushroom, Deluxe, Hawaiian
	}

	public static Pizza2 createPizza(PizzaType pizzaType) {
		switch (pizzaType) {
		case HamMushroom:
			return new HamAndMushroomPizza();
		case Deluxe:
			return new DeluxePizza();
		case Hawaiian:
			return new HawaiianPizza();
		}
		throw new IllegalArgumentException("The pizza type " + pizzaType + " is not recognized.");
	}
}

public class FactoryMethod {
	/*
	 * Create all available pizzas and print their prices
	 */
	public static void main(String args[]) {
		// Output:
		// Price of HamMushroom is 8.5
		// Price of Deluxe is 10.5
		// Price of Hawaiian is 11.5
		for (PizzaFactory.PizzaType pizzaType : PizzaFactory.PizzaType.values()) {
			System.out.println("Price of " + pizzaType + " is " + PizzaFactory.createPizza(pizzaType).getPrice());
		}
	}
}