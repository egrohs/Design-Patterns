package padroescomportamentais.chainofresponsibility;

public class StringFilter implements IFilter {
	@Override
	public Object filter(Input i) {
		return i.getStringValue();
	}
}
