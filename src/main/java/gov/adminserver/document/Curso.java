package gov.adminserver.document;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Curso {
	
	private String descricaoCurso; // CAP 2019 ou CAEP 2021
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataInicio;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataFim;
	
	protected Curso() {}

	public Curso(String descricaoCurso, Date dataInicio, Date dataFim) {
		this.descricaoCurso = descricaoCurso;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public String getDescricaoCurso() {
		return descricaoCurso;
	}

	public void setDescricaoCurso(String descricaoCurso) {
		this.descricaoCurso = descricaoCurso;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
//	DEIXEI HASHCODE E EQUALS PARA COMPARAR TODOS OS ATRIBUTOS, POIS
//  O CLIENTE ENVIARÁ O OBJETO COM TODOS SEUS ATRIBUTOS PARA COMPARAÇÃO	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricaoCurso == null) ? 0 : descricaoCurso.hashCode());
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
		Curso other = (Curso) obj;
		if (descricaoCurso == null) {
			if (other.descricaoCurso != null)
				return false;
		} else if (!descricaoCurso.equals(other.descricaoCurso))
			return false;
		return true;
	}
	
	
}
