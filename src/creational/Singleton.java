package creational;

public class Singleton {
	private static final Singleton INSTANCE = new Singleton();

	// Private constructor prevents instantiation from other classes
	private Singleton() {
	}

	public static Singleton getInstance() {
		return INSTANCE;
	}
}

/**
 * The solution of Bill Pugh The inner class is referenced no earlier (and
 * therefore loaded no earlier by the class loader) than the moment that
 * getInstance() is called. Thus, this solution is thread-safe without requiring
 * special language constructs (i.e. volatile or synchronized).
 */
class Singleton2 {
	// Private constructor prevents instantiation from other classes
	private Singleton2() {
	}

	/**
	 * SingletonHolder is loaded on the first execution of
	 * Singleton.getInstance() or the first access to SingletonHolder.INSTANCE,
	 * not before.
	 */
	private static class SingletonHolder {
		private static final Singleton2 INSTANCE = new Singleton2();
	}

	public static Singleton2 getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
