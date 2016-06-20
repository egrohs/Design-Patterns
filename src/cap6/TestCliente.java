package cap6;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCliente {
	static CadastroDeClientes cc;

	@BeforeClass
	public static void inicia() {
		cc = new CadastroDeClientes();
	}

	@Test
	public void testRecupera1() {
		Cliente c = cc.pesquisarPorCpf("123456789101");
		Assert.assertTrue(c != null);
	}

	@Test
	public void testRecuperaTodos() {
		System.out.println(cc.listar().size());
		Assert.assertTrue(cc.listar().size() == 3);
	}
}
