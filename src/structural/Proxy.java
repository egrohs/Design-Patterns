package structural;

//The following Java example illustrates the "virtual proxy" pattern. The ProxyImage class is used to access a remote method.

interface Image {
	public void displayImage();
}

// on System A
class RealImage implements Image {
	private String filename;

	public RealImage(String filename) {
		this.filename = filename;
		loadImageFromDisk();
	}

	private void loadImageFromDisk() {
		System.out.println("Loading   " + filename);
	}

	public void displayImage() {
		System.out.println("Displaying " + filename);
	}
}

// on System B
class ProxyImage implements Image {
	private String filename;
	private Image image;

	public ProxyImage(String filename) {
		this.filename = filename;
	}

	public void displayImage() {
		image = new RealImage(filename);
		image.displayImage();
	}
}

public class Proxy {
	public static void main(String[] args) {
		Image image1 = new ProxyImage("HiRes_10MB_Photo1");
		Image image2 = new ProxyImage("HiRes_10MB_Photo2");

		image1.displayImage(); // loading necessary
		image2.displayImage(); // loading necessary
	}
}

/*
 * The program's output is:
 * 
 * Loading HiRes_10MB_Photo1 Displaying HiRes_10MB_Photo1 Loading
 * HiRes_10MB_Photo2 Displaying HiRes_10MB_Photo2
 */