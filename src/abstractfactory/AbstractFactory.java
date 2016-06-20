package abstractfactory;

import abstractfactory.Util.TIPOS;

public interface AbstractFactory {
	public AbstractFactory factory(TIPOS tipo, String conteudo);
}
