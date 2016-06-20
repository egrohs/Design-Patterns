package behavorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Here another example of this pattern in java. In this example we have
 * different roles, each having a fix purchase power limit and a successor.
 * Everytime a user in a role receives a purchase request, when it's over his
 * limit, he just passes that request to his successor.
 * 
 * The PurchasePower abstract class with the abstract method processRequest.
 */
abstract class PurchasePower {

	protected final double base = 500;
	protected PurchasePower successor;

	public void setSuccessor(PurchasePower successor) {
		this.successor = successor;
	}

	abstract public void processRequest(PurchaseRequest request);
}

// Four implementations of the abstract class above: Manager, Director, Vice
// President, President

class ManagerPPower extends PurchasePower {
	private final double ALLOWABLE = 10 * base;

	public void processRequest(PurchaseRequest request) {
		if (request.getAmount() < ALLOWABLE)
			System.out.println("Manager will approve $" + request.getAmount());
		else if (successor != null)
			successor.processRequest(request);
	}
}

class DirectorPPower extends PurchasePower {
	private final double ALLOWABLE = 20 * base;

	public void processRequest(PurchaseRequest request) {
		if (request.getAmount() < ALLOWABLE)
			System.out.println("Director will approve $" + request.getAmount());
		else if (successor != null)
			successor.processRequest(request);
	}
}

class VicePresidentPPower extends PurchasePower {
	private final double ALLOWABLE = 40 * base;

	public void processRequest(PurchaseRequest request) {
		if (request.getAmount() < ALLOWABLE)
			System.out.println("Vice President will approve $" + request.getAmount());
		else if (successor != null)
			successor.processRequest(request);
	}
}

class PresidentPPower extends PurchasePower {
	private final double ALLOWABLE = 60 * base;

	public void processRequest(PurchaseRequest request) {
		if (request.getAmount() < ALLOWABLE)
			System.out.println("President will approve $" + request.getAmount());
		else
			System.out.println("Your request for $" + request.getAmount() + " needs a board meeting!");
	}
}

// The PurchaseRequest class with its Getter methods which keeps the request
// data in this example.

class PurchaseRequest {

	private int number;
	private double amount;
	private String purpose;

	public PurchaseRequest(int number, double amount, String purpose) {
		this.number = number;
		this.amount = amount;
		this.purpose = purpose;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amt) {
		amount = amt;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String reason) {
		purpose = reason;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int num) {
		number = num;
	}
}

// And here a usage example, the successors are set like this: Manager ->
// Director -> Vice President -> President

public class ChainOfResponsibility2 {
	public static void main(String[] args) {
		ManagerPPower manager = new ManagerPPower();
		DirectorPPower director = new DirectorPPower();
		VicePresidentPPower vp = new VicePresidentPPower();
		PresidentPPower president = new PresidentPPower();
		manager.setSuccessor(director);
		director.setSuccessor(vp);
		vp.setSuccessor(president);

		// enter ctrl+c to kill.
		try {
			while (true) {
				System.out.println("Enter the amount to check who should approve your expenditure.");
				System.out.print(">");
				double d = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
				manager.processRequest(new PurchaseRequest(0, d, "General"));
			}
		} catch (Exception e) {
			System.exit(1);
		}
	}
}