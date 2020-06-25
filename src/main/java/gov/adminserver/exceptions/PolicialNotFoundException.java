package gov.adminserver.exceptions;

public class PolicialNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PolicialNotFoundException(String mensagem) {
		super(mensagem);
	}

}
