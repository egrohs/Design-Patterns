package padroesestruturais.comfacade;

public class Aplicacao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Aplicacao ap = new Aplicacao();
		ap.iniciar();
		ap.exibirMenu();
	}

	public void exibirMenu() {
		System.out.println("Metodo menor.");
	}

	public void iniciar() {
		System.out.println("Responsabilidades divididas.");
	}
}
