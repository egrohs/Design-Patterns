package padroesdelogicadedominio;

/***
 * 
 * @author 99689650068
 * 
 *         Representa as condições que governam todos os seguros de um
 *         determinado ramo. Isso inclui as restrições de pagamento do seguro.
 */
public class CondicaoGeral implements ICondicao {
	protected Proposta proposta;

	public CondicaoGeral(Proposta proposta) {
		super();
		this.proposta = proposta;
	}

	public boolean permitirPagamento() {
		return proposta.aceitou();
	}
}
