package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelos.entidades.Reserva;
import modelos.excessoes.DominioExcessao;

public class ProgramaExemplo1ExcecoesPersonalizadas {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Número do quarto: ");
			int numQuarto = sc.nextInt();
			System.out.print("Data entrada:");
			Date dataEntrada = sdf.parse(sc.next());

			System.out.print("Data saida:");
			Date dataSaida = sdf.parse(sc.next());

			Reserva reserva = new Reserva(numQuarto, dataEntrada, dataSaida);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Entre a data de update da reserva: ");
			System.out.print("Data entrada:");
			dataEntrada = sdf.parse(sc.next());

			System.out.print("Data saida:");
			dataSaida = sdf.parse(sc.next());

			reserva.atulizarDatas(dataEntrada, dataSaida);
			System.out.println("Reserva: " + reserva);
		} catch (ParseException e) {
			System.out.println("O usuário digitou uma data inválida!");
		}catch (DominioExcessao e) {
			System.out.println(e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("Erro inesperado: "+ e.getStackTrace().toString());
		}
		sc.close();

	}

}
