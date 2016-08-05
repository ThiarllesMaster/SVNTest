package artefato;

import java.util.ResourceBundle;

import svntool.svntool.InspecaoPacotes;

public class Test {
	
	public static void main(String[] args) {
		ResourceBundle resource = ResourceBundle.getBundle("properties.ambiente");
		InspecaoPacotes connectionManager = new InspecaoPacotes();
		String enderecoDois = resource.getString("pastaADO");
		String usuario = resource.getString("");
		String senha = resource.getString("senhaSVN");
		
		
		connectionManager.verificacaoPastaDois(usuario, senha, enderecoDois);
	}

}
