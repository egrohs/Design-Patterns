package padroesdelogicadedominio;

import junit.framework.TestCase;

import org.junit.Assert;

public class TestDomain extends TestCase {
	public void testSituacao1() {
		Proposta p = new Proposta(true);
		ICondicao c = new CondicaoGeral(p);
		Endosso e = new Endosso();
		ContratoDeSeguro cs = new ContratoDeSeguro("Av. Osvaldo Aranha, 455", e);
		Assert.assertTrue(!cs.alteracaoContrato());
		Assert.assertTrue(cs.clienteAssinou(p));
		Assert.assertTrue(cs.clienteReceberIndenizacao(c));
	}

	public void testSituacao2() {
		Proposta p = new Proposta(true);
		ICondicao c = new CondicaoEspecial(p);
		Endosso e = new Endosso();
		ContratoDeSeguro cs = new ContratoDeSeguro("Av. Osvaldo Aranha, 455", e);
		Assert.assertTrue(!cs.alteracaoContrato());
		Assert.assertTrue(cs.clienteAssinou(p));
		Assert.assertTrue(cs.clienteReceberIndenizacao(c));
	}

	public void testSituacao3() {
		Proposta p = new Proposta(false);
		ICondicao c = new CondicaoGeral(p);
		Endosso e = new Endosso();
		ContratoDeSeguro cs = new ContratoDeSeguro("Av. Osvaldo Aranha, 455", e);
		Assert.assertTrue(cs.alteracaoContrato());
		Assert.assertTrue(cs.clienteAssinou(p));
		Assert.assertTrue(cs.clienteReceberIndenizacao(c));
	}
}
