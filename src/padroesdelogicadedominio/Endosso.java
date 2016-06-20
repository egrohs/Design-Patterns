package padroesdelogicadedominio;

/***
 * 
 * @author 99689650068
 * 
 *         Cuida das alterações feitas em um contrato de seguro. Desde a mudança
 *         de número de telefone até inclusão de beneficiários, tudo é mantido
 *         por essa classe.
 */
public class Endosso {
	private boolean alteracao;

	public Endosso() {
		super();
		this.alteracao = false;
	}

	public void alterarTelefone() {
		alteracao=true;
	}

	public void incluirBeneficiario() {
		alteracao=true;
	}

	public boolean houveAlteracao() {
		return alteracao;
	}
}
