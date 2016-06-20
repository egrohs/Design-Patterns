package abstractfactory;

import abstractfactory.Util.TIPOS;

public class ApplicationWithFactoryMethod {
	public static void main(String[] args) {
		TIPOS tipo = TIPOS.BMP;
		String conteudo = "assdjfkgsad";
		AbstractFactory i = new IMGFactory();
		AbstractFactory factory = i.factory(tipo, conteudo);
		System.out.println(factory.getClass().getName());
	}

}
