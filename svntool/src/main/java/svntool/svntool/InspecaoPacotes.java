package svntool.svntool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNNodeKind;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

import artefato.Pacote;

/**
 * Classe responsavel por se conectar com o servidor SVN
 * 
 * @author thiarlles.gomes
 * 
 */
public class InspecaoPacotes {

	public List<Pacote> artefatosEnderecoUm = null;
	public List<Pacote> artefatosEnderecoDois = null;

	public InspecaoPacotes() {
		this.artefatosEnderecoUm = new ArrayList<Pacote>();
		this.artefatosEnderecoDois = new ArrayList<Pacote>();
	}

	/**
	 * Método desenvolvido para verificacao integridade Pasta 05
	 * 
	 * @param pastaDesenvolvimento
	 * @param login
	 * @param senha
	 * @return
	 */
	public List<Pacote> verificacaoPastaUm(String pastaDesenvolvimento,
			String login, String senha) {
		DAVRepositoryFactory.setup();
		SVNRepository repository = null;

		try {
			repository = SVNRepositoryFactory.create(SVNURL
					.parseURIEncoded(pastaDesenvolvimento));
			@SuppressWarnings("deprecation")
			ISVNAuthenticationManager authManager = SVNWCUtil
					.createDefaultAuthenticationManager(login, senha);
			repository.setAuthenticationManager(authManager);
			listarArquivosRepositorioUm(repository, "");

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return artefatosEnderecoUm;

	}

	/**
	 * Método desenvolvido para verificacao integridade Pasta 01
	 * 
	 * @param endereco
	 * @param usuario
	 */
	public List<Pacote> verificacaoPastaDois(String pastaImplantacao, String usuario, String senha) {
		DAVRepositoryFactory.setup();
		SVNRepository repository = null;

		try {
			repository = SVNRepositoryFactory.create(SVNURL
					.parseURIEncoded(pastaImplantacao));
			@SuppressWarnings("deprecation")
			ISVNAuthenticationManager authManager = SVNWCUtil
					.createDefaultAuthenticationManager(usuario, senha);
			repository.setAuthenticationManager(authManager);
			listarArquivosRepositorioDois(repository, "");

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return artefatosEnderecoDois;

	}

	@SuppressWarnings("rawtypes")
	private void listarArquivosRepositorioUm(SVNRepository repository,
			String path) throws SVNException {

		Collection entries = repository.getDir(path, -1, null,
				(Collection) null);

		Iterator iterator = entries.iterator();
		while (iterator.hasNext()) {
			SVNDirEntry entry = (SVNDirEntry) iterator.next();
			Pacote artefato = new Pacote(entry.getName(), entry.getDate());
			artefatosEnderecoUm.add(artefato);
			if (entry.getKind() == SVNNodeKind.DIR) {
				listarArquivosRepositorioUm(repository,
						(path.equals("")) ? entry.getName() : path + "/"
								+ entry.getName());
			}

		}
	}

	/**
	 * Método desenvolvido para o processo de análise da Pasta 02
	 * @param repository
	 * @param path
	 * @throws SVNException
	 */
	@SuppressWarnings("rawtypes")
	private void listarArquivosRepositorioDois(SVNRepository repository,
			String path) throws SVNException {

		Collection entries = repository.getDir(path, -1, null,
				(Collection) null);

		Iterator iterator = entries.iterator();
		while (iterator.hasNext()) {
			SVNDirEntry entry = (SVNDirEntry) iterator.next();
			Pacote artefato = new Pacote(entry.getName(), entry.getDate());
			artefatosEnderecoDois.add(artefato);
			if (entry.getKind() == SVNNodeKind.DIR) {
				listarArquivosRepositorioDois(repository,
						(path.equals("")) ? entry.getName() : path + "/"
								+ entry.getName());
			}

		}
	}

}
