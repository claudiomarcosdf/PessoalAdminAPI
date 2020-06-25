package gov.adminserver.exceptions;

public class MatriculaExistenteException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public MatriculaExistenteException(String mensagem) {
		super(mensagem);
	}

}
