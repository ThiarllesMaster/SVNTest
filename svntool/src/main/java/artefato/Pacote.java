package artefato;

import java.util.Date;

/**
 * Classe que representa o artefato a ser verificado
 * @author thiarlles.gomes
 *
 */
public class Pacote {

	private String nomeArtefato;
	private Date dataModificacao;
	
	
	public Pacote(String nomeArtefato, Date dataModificacao) {
		this.nomeArtefato = nomeArtefato;
		this.dataModificacao = dataModificacao;
	}


	public String getNomeArtefato() {
		return nomeArtefato;
	}


	public void setNomeArtefato(String nomeArtefato) {
		this.nomeArtefato = nomeArtefato;
	}


	public Date getDataModificacao() {
		return dataModificacao;
	}


	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataModificacao == null) ? 0 : dataModificacao.hashCode());
		result = prime * result
				+ ((nomeArtefato == null) ? 0 : nomeArtefato.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacote other = (Pacote) obj;
		if (dataModificacao == null) {
			if (other.dataModificacao != null)
				return false;
		} else if (!dataModificacao.equals(other.dataModificacao))
			return false;
		if (nomeArtefato == null) {
			if (other.nomeArtefato != null)
				return false;
		} else if (!nomeArtefato.equals(other.nomeArtefato))
			return false;
		return true;
	}
	
	
	
	
}
