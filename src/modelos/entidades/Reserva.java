package modelos.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer numeroQuarto;
	private Date dataChegada;
	private Date dataSa�da;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroQuarto, Date dataChegada, Date dataSa�da) {
		this.numeroQuarto = numeroQuarto;
		this.dataChegada = dataChegada;
		this.dataSa�da = dataSa�da;
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

	public Date getDataSa�da() {
		return dataSa�da;
	}
	
	public long duracao() {
		long diferenca = dataSa�da.getTime() - dataChegada.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void atulizarDatas(Date dataChegada, Date dataSaida) {
		this.dataChegada = dataChegada;
		this.dataSa�da = dataSaida;
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ numeroQuarto
				+ ", Data Chegada: "
				+ sdf.format(dataChegada)
				+ ", Data sa�da: "
				+ sdf.format(dataSa�da)
				+ ", "
				+ duracao()
				+" noites";
	}

	
	
	
}
