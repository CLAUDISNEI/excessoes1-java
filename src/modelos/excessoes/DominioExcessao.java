package modelos.excessoes;

public class DominioExcessao extends RuntimeException {
	//declarando a versão da classe serialize
	private static final long serialVersionUID = 1L;
	
	public DominioExcessao(String msg) {
		super(msg);
	}
}
