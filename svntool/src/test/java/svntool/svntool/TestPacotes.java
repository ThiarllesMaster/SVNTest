package svntool.svntool;

import java.util.List;
import java.util.ResourceBundle;

import org.junit.Test;

import artefato.Pacote;

/**
 * Classe que busca realizar o teste de verificacao dos artefatos dado os endereços
 * @author thiarlles.gomes
 *
 */
public class TestPacotes {

	@Test
	public void testIntegridadePacotes() {
		ResourceBundle resource = ResourceBundle.getBundle("properties.ambiente");
		//Chama a classe de inspecao dos pacotes ...
		InspecaoPacotes inspecaoPacotes = new InspecaoPacotes();
		String primeiraPasta = resource.getString("enderecoUm");
		String segundaPasta = resource.getString("enderecoDois");
		String usuario = resource.getString("usuarioSVN");
		String senha = resource.getString("senhaSVN");
		
		List<Pacote>artefatosPastaUm = inspecaoPacotes.verificacaoPastaUm(primeiraPasta, usuario, senha);
		List<Pacote>artefatosPastaDois = inspecaoPacotes.verificacaoPastaDois(segundaPasta, usuario, senha);
		
		
		for(Pacote pastaUm : artefatosPastaUm) {
			System.out.println("Artefato: " + pastaUm.getNomeArtefato() );
			System.out.println("Data de Modificacao" + pastaUm.getDataModificacao());
		}
		System.out.println("-----------Fim da inspeção na pasta 01 ---------------------------------");
		System.out.println("------------------------------------------------------------------------");
		for (Pacote pacoteNove : artefatosPastaDois) {
			System.out.println("Artefato: " + pacoteNove.getNomeArtefato());
			System.out.println("Data de Modificacao" + pacoteNove.getDataModificacao());
		}
		System.out.println("-----------Fim da inspeção na pasta 02 ---------------------------------");
	    //Definicao dos Asserts
		
	}

}
