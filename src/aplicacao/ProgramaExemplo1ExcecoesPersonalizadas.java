package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelos.entidades.Reserva;

public class ProgramaExemplo1ExcecoesPersonalizadas {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int numQuarto = sc.nextInt();
		System.out.print("Data entrada:");
		Date dataEntrada = sdf.parse(sc.next());
		
		System.out.print("Data saida:");
		Date dataSaida = sdf.parse(sc.next());
		
		if(!dataSaida.after(dataEntrada)) {
			System.out.println("Erro na reserva: Data de saída"
					+ " deve ser maior que a Data de entrada" );
		}else {
			Reserva reserva =  new Reserva(numQuarto, dataEntrada, dataSaida);
			System.out.println("Reserva: "+ reserva);
			
			System.out.println();
			System.out.println("Entre a data de update da reserva: ");
			System.out.print("Data entrada:");
			dataEntrada = sdf.parse(sc.next());
			
			System.out.print("Data saida:");
			dataSaida = sdf.parse(sc.next());
			
			String erro = reserva.atulizarDatas(dataEntrada, dataSaida);
			if( erro != null) {
				System.out.println("Erro na reserva: " + erro);
			}
			else {
			System.out.println("Reserva: "+ reserva);
			}
			
			

		}
		
		sc.close();

	}

}
