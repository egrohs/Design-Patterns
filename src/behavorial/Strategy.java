package behavorial;

/**
 * Define a family of algorithms, encapsulate each one, and make them
 * interchangeable. Strategy lets the algorithm vary independently from clients
 * that use it.
 */
public class Strategy {
	public static void main(String[] args) {
		Context context;
		// Three contexts following different strategies
		context = new Context(new ConcreteStrategyAdd());
		int resultA = context.executeStrategy(3, 4);

		context = new Context(new ConcreteStrategySubtract());
		int resultB = context.executeStrategy(3, 4);

		context = new Context(new ConcreteStrategyMultiply());
		int resultC = context.executeStrategy(3, 4);
	}
}

// The classes that implement a concrete strategy should implement this

// The context class uses this to call the concrete strategy
interface IStrategy {

	int execute(int a, int b);

}

// Implements the algorithm using the strategy interface
class ConcreteStrategyAdd implements IStrategy {

	public int execute(int a, int b) {
		System.out.println("Called ConcreteStrategyA's execute()");
		return a + b; // Do an addition with a and b
	}

}

class ConcreteStrategySubtract implements IStrategy {

	public int execute(int a, int b) {
		System.out.println("Called ConcreteStrategyB's execute()");
		return a - b; // Do a subtraction with a and b
	}

}

class ConcreteStrategyMultiply implements IStrategy {

	public int execute(int a, int b) {
		System.out.println("Called ConcreteStrategyC's execute()");
		return a * b; // Do a multiplication with a and b
	}

}

// Configured with a ConcreteStrategy object and maintains a reference to a
// Strategy object
class Context {

	private IStrategy strategy;

	// Constructor
	public Context(IStrategy strategy) {
		this.strategy = strategy;
	}

	public int executeStrategy(int a, int b) {
		return strategy.execute(a, b);
	}

}