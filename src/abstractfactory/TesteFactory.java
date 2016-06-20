package abstractfactory;

import junit.framework.TestCase;

import org.junit.Assert;

import abstractfactory.Util.TIPOS;

public class TesteFactory extends TestCase {

	public void testInstances() {
		String conteudo = "assdjfkgsad";
		
		AbstractFactory i = new IMGFactory();
		AbstractFactory c1 = i.factory(TIPOS.BMP, conteudo);
		Assert.assertTrue(c1 instanceof BMPFactory);
		AbstractFactory c2 = i.factory(TIPOS.JPG, conteudo);
		Assert.assertTrue(c2 instanceof JPGFactory);
		AbstractFactory c3 = i.factory(TIPOS.GIF, conteudo);
		Assert.assertTrue(c3 instanceof GIFFactory);
		
		AbstractFactory i2 = new DOCFactory();
		AbstractFactory c4 = i2.factory(TIPOS.TXT, conteudo);
		Assert.assertTrue(c4 instanceof TXTFactory);
		AbstractFactory c5 = i2.factory(TIPOS.PPT, conteudo);
		Assert.assertTrue(c5 instanceof PPTFactory);
		AbstractFactory c6 = i2.factory(TIPOS.XLS, conteudo);
		Assert.assertTrue(c6 instanceof XLSFactory);
	}
}