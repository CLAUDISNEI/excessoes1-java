package modelos.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer numeroQuarto;
	private Date dataChegada;
	private Date dataSaída;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroQuarto, Date dataChegada, Date dataSaída) {
		this.numeroQuarto = numeroQuarto;
		this.dataChegada = dataChegada;
		this.dataSaída = dataSaída;
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
		return dataSaída;
	}
	
	public long duracao() {
		long diferenca = dataSaída.getTime() - dataChegada.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public String atulizarDatas(Date dataChegada, Date dataSaida) {	
		Date hoje = new Date();	
		if (dataChegada.before(hoje) || dataSaida.before(hoje)) {
			return "Erro na reserva: Datas de update na reserva"
					+ " devem ser datas futuras";
		}
		if(!dataSaida.after(dataChegada)) {
			return "Erro na reserva: Data de saída"
					+ " deve ser maior que a Data de entrada" ;	
		}
		this.dataChegada = dataChegada;
		this.dataSaída = dataSaida;
		return null;
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ numeroQuarto
				+ ", Data Chegada: "
				+ sdf.format(dataChegada)
				+ ", Data saída: "
				+ sdf.format(dataSaída)
				+ ", "
				+ duracao()
				+" noites";
	}

	
	
	
}
