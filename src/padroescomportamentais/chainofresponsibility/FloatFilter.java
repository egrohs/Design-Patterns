package padroescomportamentais.chainofresponsibility;

public class FloatFilter implements IFilter {
	@Override
	public Object filter(Input i) {
		return i.getFloatValue();
	}
}
