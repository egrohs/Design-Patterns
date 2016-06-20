package abstractfactory;

import abstractfactory.Util.TIPOS;

public class DOCFactory implements AbstractFactory {
	@Override
	public AbstractFactory factory(TIPOS tipo, String conteudo) {
		AbstractFactory fac = null;
		switch (tipo) {
		case TXT:
			fac = new TXTFactory();
			break;
		case PPT:
			fac = new PPTFactory();
			break;
		case XLS:
			fac = new XLSFactory();
			break;
		default:
			break;
		}
		return fac;
	}
}
