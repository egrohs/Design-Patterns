package padroesdelogicadedominio;

import java.util.ArrayList;
import java.util.List;

/***
 * @author 99689650068
 * 
 *         possui DADOS(integracao dos modelos que ele conecta) e COMPORTAMENTOS
 *         (conjuntos de comportamentos dos modelos específicos)
 */
public class ContratoDeSeguro {
	private String endereco;
	private List<String> beneficiario;
	private Endosso endosso;

	public ContratoDeSeguro(String endereco, Endosso e) {
		super();
		this.endereco = endereco;
		this.beneficiario = new ArrayList<String>();
		this.endosso = e;
	}

	public boolean clienteAssinou(Proposta p) {
		// O contrato só é assinado se a proposta é aceita.
		return p.aceitou();
	}

	public boolean clienteReceberIndenizacao(ICondicao c) {
		// Quem responde isso são as condições gerais e especiais.
		return c.permitirPagamento();
	}

	public boolean alteracaoContrato() {
		// Quem responde isso é o endosso.
		return endosso.houveAlteracao();
	}
}
