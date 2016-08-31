package mineracaodadoseleitorais;

import java.util.ArrayList;

public class CandidaturaFileTableReader extends FileTableReader {
	private ArrayList<Candidatura> rows;
	
	static final String TABLE_PATH = "C:\\Users\\JP\\Documents\\Aulas\\PDS\\consulta_cand_2014\\consulta_cand_2014_RN.txt";
	
	public CandidaturaFileTableReader() {
		super(TABLE_PATH);
		rows = new ArrayList<Candidatura>();
	}

	@Override
	protected void processRow(String[] entry) {
		rows.add(new Candidatura(entry));
	}
}
