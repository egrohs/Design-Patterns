package padroescomportamentais.chainofresponsibility;

public class DoubleFilter implements IFilter {
	@Override
	public Object filter(Input i) {
		return i.getDoubleValue();
	}
}
