package gov.adminserver.document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Policial {
	
	@Id
	private String id;
	@NotNull
	private Long matricula;
	private String nomeGuerra;
	private String quadro;
	private String postoGraduacao;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataIngresso;
	private String siape;
	@JsonFormat(pattern="yyyy-MM-dd")	
	private Date bienalValidade;
	@JsonFormat(pattern="yyyy-MM-dd")	
	private Date tafData;
	private String genero;
	private String nome;
	private String cpf;
	@JsonFormat(pattern="yyyy-MM-dd")	
	private Date dataNascimento;
    private Endereco endereco;
	@JsonFormat(pattern="yyyy-MM-dd")    
	private Date cnhValidade;
	private String categoria;
	private String email;
	@Indexed(direction = IndexDirection.DESCENDING)
	private List<Afastamento> afastamentos;
	private List<Licenca> licencas;
	private List<Curso> cursos;
	private boolean transferido;
	
	public Policial() {
		this.afastamentos = new ArrayList<>();
		this.licencas = new ArrayList<>();
		this.cursos = new ArrayList<>();
	}
	
	public Policial(Long matricula, String nomeGuerra, String quadro, String postoGraduacao, Date dataIngresso,
			String siape, Date bienalValidade, Date tafData, String genero, String nome, String cpf,
			Date dataNascimento, Endereco endereco, Date cnhValidade, String email, List<Afastamento> afastamentos,
			List<Licenca> licencas, List<Curso> cursos, String categoria,
			boolean transferido) {
		this.matricula = matricula;
		this.nomeGuerra = nomeGuerra;
		this.quadro = quadro;
		this.postoGraduacao = postoGraduacao;
		this.dataIngresso = dataIngresso;
		this.siape = siape;
		this.bienalValidade = bienalValidade;
		this.tafData = tafData;
		this.genero = genero;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.cnhValidade = cnhValidade;
		this.email = email;
		this.afastamentos = afastamentos;
		this.licencas = licencas;
		this.cursos = cursos;
		this.transferido = transferido;
		this.categoria = categoria;
	}

	public String getId() {
		return id;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNomeGuerra() {
		return nomeGuerra;
	}

	public void setNomeGuerra(String nomeGuerra) {
		this.nomeGuerra = nomeGuerra;
	}

	public String getQuadro() {
		return quadro;
	}

	public void setQuadro(String quadro) {
		this.quadro = quadro;
	}

	public String getPostoGraduacao() {
		return postoGraduacao;
	}

	public void setPostoGraduacao(String postoGraduacao) {
		this.postoGraduacao = postoGraduacao;
	}

	public Date getDataIngresso() {
		return dataIngresso;
	}

	public void setDataIngresso(Date dataIngresso) {
		this.dataIngresso = dataIngresso;
	}

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}

	public Date getBienalValidade() {
		return bienalValidade;
	}

	public void setBienalValidade(Date bienalValidade) {
		this.bienalValidade = bienalValidade;
	}

	public Date getTafData() {
		return tafData;
	}

	public void setTafData(Date tafData) {
		this.tafData = tafData;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Afastamento> getAfastamentos() {
		return afastamentos;
	}

	public void setAfastamentos(List<Afastamento> afastamentos) {
		this.afastamentos = afastamentos;
	}
	
	public List<Licenca> getLicencas() {
		return licencas;
	}

	public void setLicencas(List<Licenca> licencas) {
		this.licencas = licencas;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Date getCnhValidade() {
		return cnhValidade;
	}

	public void setCnhValidade(Date cnhValidade) {
		this.cnhValidade = cnhValidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isTransferido() {
		return transferido;
	}

	public void setTransferido(boolean transferido) {
		this.transferido = transferido;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((afastamentos == null) ? 0 : afastamentos.hashCode());
		result = prime * result + ((cursos == null) ? 0 : cursos.hashCode());
		result = prime * result + ((licencas == null) ? 0 : licencas.hashCode());
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
		Policial other = (Policial) obj;
		if (afastamentos == null) {
			if (other.afastamentos != null)
				return false;
		} else if (!afastamentos.equals(other.afastamentos))
			return false;
		if (cursos == null) {
			if (other.cursos != null)
				return false;
		} else if (!cursos.equals(other.cursos))
			return false;
		if (licencas == null) {
			if (other.licencas != null)
				return false;
		} else if (!licencas.equals(other.licencas))
			return false;
		return true;
	}
	
	

	/* PARA TESTE - FUNCIONOU!
	 * public String getDataTemp() { SimpleDateFormat sdf; sdf = new
	 * SimpleDateFormat("yyyy-MM-dd"); sdf.setTimeZone(TimeZone.getTimeZone("CET"));
	 * String text = sdf.format(getDataIngresso());
	 * 
	 * return text; }
	 * 
	 * 
	 * PÁGINA PARA TESTES DE CONVERSAO DO NÚMERO PARA DATA: https://dencode.com/date/iso8601 -> SELECIONAR CET NO COMBOBOX
	 */

    	

}
