package cap6;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CadastroDeClientes {
	private List<Cliente> clientes;

	public CadastroDeClientes() {
		clientes = new ArrayList<Cliente>();
		parse();
	}

	private void parse() {
		try {
			File fXmlFile = new File("src/cap6/clientes.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("cliente");

			System.out.println("----------------------------" + nList.getLength());

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String cpf = eElement.getElementsByTagName("cpf").item(0).getTextContent();
					String nome = eElement.getElementsByTagName("nome").item(0).getTextContent();
					String data = eElement.getElementsByTagName("data-de-nascimento").item(0).getTextContent();
					System.out.println("cpf : " + cpf);
					System.out.println("nome : " + nome);
					System.out.println("data : " + data);
					clientes.add(new Cliente(nome, cpf, data));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Cliente pesquisarPorCpf(String cpf) {
		for (Cliente c : clientes) {
			if (cpf.equals(c.getCpf())) {
				return c;
			}
		}
		return null;
	}

	public List<Cliente> listar() {
		return clientes;
	}
}
