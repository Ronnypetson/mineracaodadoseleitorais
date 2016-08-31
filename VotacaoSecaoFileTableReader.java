package mineracaodadoseleitorais;

import java.util.ArrayList;

public class VotacaoSecaoFileTableReader extends FileTableReader {
	private ArrayList<VotacaoSecao> rows;
	
	static final String TABLE_PATH = "C:\\Users\\JP\\Documents\\Aulas\\PDS\\votacao_secao_2014_RN\\votacao_secao_2014_RN.txt"; 
	
	public VotacaoSecaoFileTableReader() {
		super(TABLE_PATH);
		rows = new ArrayList<VotacaoSecao>();
	}

	@Override
	protected void processRow(String[] entry) {
		rows.add(new VotacaoSecao(entry));
	}
}
