package mineracaodadoseleitorais.dao;

import java.io.IOException;
import mineracaodadoseleitorais.negocio.VotacaoCandidato;
import java.util.ArrayList;

public class VotacaoCandidatoFileTableReader extends FileTableReader {
	// private ArrayList<VotacaoCandidato> rows;

    static final String TABLE_PATH
            = "C:\\Users\\ronnypetsonss\\Documents\\UFRN 2016.2\\Projeto de Software"
            + "\\dados eleitorais de 2014\\votacao_candidato_munzona_2014\\votacao_candidato_munzona_2014_RN.txt";

    public VotacaoCandidatoFileTableReader() throws IOException {
        super(TABLE_PATH);
        rows = new ArrayList<VotacaoCandidato>();
    }
    
    @Override
    protected void processRow(String[] entry) {
        rows.add(new VotacaoCandidato(entry));
    }
}
