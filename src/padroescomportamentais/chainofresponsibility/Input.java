package padroescomportamentais.chainofresponsibility;

import java.util.Random;

public class Input {
	public int getIntValue() {
		Random r = new Random(11);
		return r.nextInt();
	}
	public String getStringValue() {
		return "asd";
	}
	public double getDoubleValue() {
		return 1.2;
	}
	public float getFloatValue() {
		return 1.4F;
	}
}
