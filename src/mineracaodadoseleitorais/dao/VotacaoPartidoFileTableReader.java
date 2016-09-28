package mineracaodadoseleitorais.dao;

import java.io.IOException;
import mineracaodadoseleitorais.negocio.VotacaoPartido;
import java.util.ArrayList;

public class VotacaoPartidoFileTableReader extends FileTableReader {
	// private ArrayList<VotacaoPartido> rows; 
	
	static final String TABLE_PATH
                = "C:\\Users\\ronnypetsonss\\Documents\\UFRN 2016.2\\Projeto de Software"
                + "\\dados eleitorais de 2014\\votacao_partido_munzona_2014\\votacao_partido_munzona_2014_RN.txt";
	
	public VotacaoPartidoFileTableReader() throws IOException {
		super(TABLE_PATH);
		rows = new ArrayList<>();
	}
        
	@Override
	protected void processRow(String[] entry) {
		rows.add(new VotacaoPartido(entry));
	}
}
