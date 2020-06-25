package gov.adminserver.document;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Licenca {
	
	private String descricaoLicenca; // Férias 2019 ou Abono 2020
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataInicio;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataFim;
	
	protected Licenca() {}

	public Licenca(String descricaoLicenca, Date dataInicio, Date dataFim) {
		this.descricaoLicenca = descricaoLicenca;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public String getDescricaoLicenca() {
		return descricaoLicenca;
	}

	public void setDescricaoLicenca(String descricaoLicenca) {
		this.descricaoLicenca = descricaoLicenca;
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
	
}
