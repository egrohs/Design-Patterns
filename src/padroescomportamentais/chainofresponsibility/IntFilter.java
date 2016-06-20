package padroescomportamentais.chainofresponsibility;

public class IntFilter implements IFilter {
	@Override
	public Object filter(Input i) {
		return i.getIntValue();
	}
}
