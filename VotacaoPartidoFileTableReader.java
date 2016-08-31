package mineracaodadoseleitorais;

import java.util.ArrayList;

public class VotacaoPartidoFileTableReader extends FileTableReader {
	private ArrayList<VotacaoPartido> rows; 
	
	static final String TABLE_PATH = "C:\\Users\\JP\\Documents\\Aulas\\PDS\\votacao_partido_munzona_2014\\votacao_partido_munzona_2014_RN.txt";
	
	public VotacaoPartidoFileTableReader() {
		super(TABLE_PATH);
		rows = new ArrayList<VotacaoPartido>();
	}

	@Override
	protected void processRow(String[] entry) {
		rows.add(new VotacaoPartido(entry));
	}
}
