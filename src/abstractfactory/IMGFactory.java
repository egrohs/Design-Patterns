package abstractfactory;

import abstractfactory.Util.TIPOS;

public class IMGFactory implements AbstractFactory {
	@Override
	public AbstractFactory factory(TIPOS tipo, String conteudo) {
		AbstractFactory fac = null;
		switch (tipo) {
		case BMP:
			fac = new BMPFactory();
			break;
		case JPG:
			fac = new JPGFactory();
			break;
		case GIF:
			fac = new GIFFactory();
			break;
		default:
			break;
		}
		return fac;
	}
}
