package modelos.excessoes;

public class DominioExcessao extends RuntimeException {
	//declarando a vers�o da classe serialize
	private static final long serialVersionUID = 1L;
	
	public DominioExcessao(String msg) {
		super(msg);
	}
}
