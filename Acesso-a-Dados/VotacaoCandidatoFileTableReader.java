package mineracaodadoseleitorais;

import java.util.ArrayList;

public class VotacaoCandidatoFileTableReader extends FileTableReader {
	private ArrayList<VotacaoCandidato> rows;
	
	static final String TABLE_PATH = "C:\\Users\\JP\\Documents\\Aulas\\PDS\\votacao_candidato_munzona_2014\\votacao_candidato_munzona_2014_RN.txt";
	
	public VotacaoCandidatoFileTableReader() {
		super(TABLE_PATH);
		rows = new ArrayList<VotacaoCandidato>();
	}

	@Override
	protected void processRow(String[] entry) {
		rows.add(new VotacaoCandidato(entry));
	}

}
