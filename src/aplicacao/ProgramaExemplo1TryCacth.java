package aplicacao;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgramaExemplo1TryCacth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		metodo1();
		
		System.out.println("Final do programa");
	}
	
	public static void metodo1() {
		System.out.println("METODO 1 INICIO");
		metodo2();
		System.out.println("MEDOTO 1 FINAL");
	}
	
	public static void metodo2() {
		System.out.println("***METODO2 START***");
		Scanner sc = new Scanner(System.in);
		try {
			String[] vetor = sc.nextLine().split(" ");
			int posicao = sc.nextInt();
			System.out.println(vetor[posicao]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Posição invalida");
			e.printStackTrace();
			sc.next();
		}
		catch (InputMismatchException e) {
			System.out.println("Valor inválido");
			
		}
		sc.close();
		System.out.println("***METODO2 END***");
	}

}
