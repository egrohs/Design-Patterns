package behavorial;

/**
 * The following Java code illustrates the pattern with the example of a logging
 * class. Each logging handler decides if any action is to be taken at this log
 * level and then passes the message on to the next logging handler. The output
 * is:
 * 
 * Writing to stdout: Entering function y. Writing to stdout: Step1 completed.
 * Sending via e-mail: Step1 completed. Writing to stdout: An error has
 * occurred. Sending via e-mail: An error has occurred. Writing to stderr: An
 * error has occurred.
 * 
 * Note that this example should not be seen as a recommendation on how to write
 * logging classes.
 * 
 * Also, note that in a 'pure' implementation of the chain of responsibility
 * pattern, a logger would not pass responsibility further down the chain after
 * handling a message. In this example, a message will be passed down the chain
 * whether it is handled or not.
 */

abstract class Logger {
	public static int ERR = 3;
	public static int NOTICE = 5;
	public static int DEBUG = 7;
	protected int mask;

	// The next element in the chain of responsibility
	protected Logger next;

	public Logger setNext(Logger l) {
		next = l;
		return l;
	}

	public void message(String msg, int priority) {
		if (priority <= mask) {
			writeMessage(msg);
		}
		if (next != null) {
			next.message(msg, priority);
		}
	}

	abstract protected void writeMessage(String msg);

}

class StdoutLogger extends Logger {

	public StdoutLogger(int mask) {
		this.mask = mask;
	}

	protected void writeMessage(String msg) {
		System.out.println("Writing to stdout: " + msg);
	}
}

class EmailLogger extends Logger {

	public EmailLogger(int mask) {
		this.mask = mask;
	}

	protected void writeMessage(String msg) {
		System.out.println("Sending via email: " + msg);
	}
}

class StderrLogger extends Logger {

	public StderrLogger(int mask) {
		this.mask = mask;
	}

	protected void writeMessage(String msg) {
		System.err.println("Sending to stderr: " + msg);
	}
}

public class ChainOfResponsibility {
	public static void main(String[] args) {
		// Build the chain of responsibility
		Logger l, l1;
		l1 = l = new StdoutLogger(Logger.DEBUG);
		l1 = l1.setNext(new EmailLogger(Logger.NOTICE));
		l1 = l1.setNext(new StderrLogger(Logger.ERR));

		// Handled by StdoutLogger
		l.message("Entering function y.", Logger.DEBUG);

		// Handled by StdoutLogger and EmailLogger
		l.message("Step1 completed.", Logger.NOTICE);

		// Handled by all three loggers
		l.message("An error has occurred.", Logger.ERR);
	}
}