package padroesdelogicadedominio;

/***
 * 
 * @author 99689650068
 * 
 *         Representa a proposta feita para um cliente. Se ele aceitou ou não.
 * 
 */
public class Proposta {
	private boolean aceitou;
	
	public Proposta(boolean aceitou) {
		super();
		this.aceitou = aceitou;
	}

	public boolean aceitou() {
		return aceitou;
	}
}
