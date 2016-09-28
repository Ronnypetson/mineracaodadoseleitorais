package mineracaodadoseleitorais;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import mineracaodadoseleitorais.DAO.DAOTSE;
import mineracaodadoseleitorais.negocio.Candidatura;
import mineracaodadoseleitorais.negocio.PerfilEleitor;
import mineracaodadoseleitorais.negocio.VotacaoCandidato;

public class Main {

    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, SQLException, IOException {
        // DAO testing
        DAOTSE myDAO = new DAOTSE();
        myDAO.connect();
        // myDAO.clearTable("VotacaoCandidato");
        // myDAO.insertAllVotacaoCandidato();
        // myDAO.printGet("VotacaoSecao");
        ArrayList<Candidatura> perfis = myDAO.getPerfisCandidaturasSecao("56");
        myDAO.disconnect();
    }
}
