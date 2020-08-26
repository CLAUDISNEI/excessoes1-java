package aplicacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProgramaExemplo1TryCacthFinally {

	public static void main(String[] args) {
		
		File arquivo = new File("C:\\Users\\claud\\Documents\\ini.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(arquivo);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("Erro ao abrir arquivo: "+ e.getMessage());
		}
		finally {
			if(sc!=null) {
				sc.close();
			}
			System.out.println("Bloco finally executado");
		}
	}

}
