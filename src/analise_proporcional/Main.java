
package analise_proporcional;

import java.io.IOException;
import java.sql.SQLException;
import analise_proporcional.dao.DAOTSE;

public class Main {
    
    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, SQLException, IOException {
        // DAO testing //
        DAOTSE myDAO = new DAOTSE();
        myDAO.connect();
        // myDAO.insertAllPerfilEleitor();
        // myDAO.insertAllVotacaoCandidato();
        // myDAO.insertAllLegenda();
        // myDAO.insertAllBemDeCandidato(); // PB, RN
        // myDAO.clearTable("Candidatura");
        // myDAO.insertAllCandidatura();
        // myDAO.clearTable("VOTACAOCANDIDATO");
        // myDAO.insertAllVotacaoCandidato();
        myDAO.disconnect();
    }
}
