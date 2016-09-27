package mineracaodadoseleitorais;

import mineracaodadoseleitorais.DAO.BemDeCandidatoFileTableReader;
import java.io.IOException;
import java.sql.SQLException;
// import java.util.Scanner;
import mineracaodadoseleitorais.DAO.DAOTSE;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException {
                // DAO testing
                DAOTSE myDAO = new DAOTSE();
                myDAO.connect();
                // myDAO.clearTable("PerfilEleitor");
                // myDAO.insertAllVotacaoSecao();
                myDAO.printGet("VotacaoSecao");
                myDAO.disconnect();
	}
}
