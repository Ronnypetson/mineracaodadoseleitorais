package mineracaodadoseleitorais;

import mineracaodadoseleitorais.acessoadados.BemDeCandidatoFileTableReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BemDeCandidatoFileTableReader ftr = new BemDeCandidatoFileTableReader();
		try {
			ftr.getAll();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scanner scanner = new Scanner(System.in);
		int index = scanner.nextInt();
		System.out.println(ftr.getRow(index).getDetalheBem());
		scanner.close();
	}

}
