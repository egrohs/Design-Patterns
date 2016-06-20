package padroescomportamentais.chainofresponsibility;

public class Filtragem {
	public static void main(String[] args) {
		Filter f = new Filter();
		f.addFilter(new IntFilter());
		f.addFilter(new DoubleFilter());
		f.addFilter(new StringFilter());
		f.addFilter(new FloatFilter());
		f.filter(new Input());
	}
}
