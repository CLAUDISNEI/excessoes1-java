package modelos.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import modelos.excessoes.DominioExcessao;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date dataChegada;
	private Date dataSaida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroQuarto, Date dataChegada, Date dataSaida)  {
		if(!dataSaida.after(dataChegada)) {
			throw new DominioExcessao("Erro na reserva: Data de saída"
					+ " deve ser maior que a Data de entrada") ;	
		}
		this.numeroQuarto = numeroQuarto;
		this.dataChegada = dataChegada;
		this.dataSaida = dataSaida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getDataChegada() {
		return dataChegada;
	}

	public Date getDataSaída() {
		return dataSaida;
	}
	
	public long duracao() {
		long diferenca = dataSaida.getTime() - dataChegada.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void atulizarDatas(Date dataChegada, Date dataSaida)  {	
		Date hoje = new Date();	
		if (dataChegada.before(hoje) || dataSaida.before(hoje)) {
			throw new DominioExcessao( "Erro na reserva: Datas de update na reserva"
					+ " devem ser datas futuras");
		}
		if(!dataSaida.after(dataChegada)) {
			throw new DominioExcessao("Erro na reserva: Data de saída"
					+ " deve ser maior que a Data de entrada") ;	
		}
		this.dataChegada = dataChegada;
		this.dataSaida = dataSaida;
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ numeroQuarto
				+ ", Data Chegada: "
				+ sdf.format(dataChegada)
				+ ", Data saída: "
				+ sdf.format(dataSaida)
				+ ", "
				+ duracao()
				+" noites";
	}

	
	
	
}
