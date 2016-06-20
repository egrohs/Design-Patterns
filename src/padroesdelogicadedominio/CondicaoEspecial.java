package padroesdelogicadedominio;

/***
 * 
 * @author 99689650068
 * 
 *         Representa as condições específicas para uma proposta de seguro. Elas
 *         podem afetar as restrições impostas pelas condições gerais,
 *         permitindo o pagamento quando as primeiras o negam e negando-o quando
 *         as primeiras o autorizam. Está relacionada diretamente com Proposta.
 */
public class CondicaoEspecial extends CondicaoGeral {
	private boolean expirou;

	public CondicaoEspecial(Proposta proposta) {
		super(proposta);
		// TODO Auto-generated constructor stub
	}

	public void setExpirou(boolean expirou) {
		this.expirou = expirou;
	}

	@Override
	public boolean permitirPagamento() {
		boolean b = super.permitirPagamento();
		if (expirou) {
			b = false;
		}
		return b;
	}
}
