package gov.adminserver.document;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Afastamento {
	
	private String motivo;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataInicio;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataFim;
	
	protected Afastamento() {}

	public Afastamento(String motivo, Date dataInicio, Date dataFim) {
		this.motivo = motivo;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
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
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((motivo == null) ? 0 : motivo.hashCode());
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
		Afastamento other = (Afastamento) obj;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (motivo == null) {
			if (other.motivo != null)
				return false;
		} else if (!motivo.equals(other.motivo))
			return false;
		return true;
	}
	

}
