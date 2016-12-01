package analise_dois_turnos.dao;

import java.io.IOException;
import analise_dois_turnos.negocio.VotacaoSecao;
import java.util.ArrayList;

public class VotacaoSecaoFileTableReader extends FileTableReader {
	// private ArrayList<VotacaoSecao> rows;
	
	static final String TABLE_PATH
                = "C:\\Users\\ronnypetsonss\\Documents\\UFRN 2016.2\\Projeto de Software"
                + "\\dados eleitorais de 2014\\votacao_secao_2014_RN\\votacao_secao_2014_RN.txt"; 
	
	public VotacaoSecaoFileTableReader() throws IOException {
		super(TABLE_PATH);
		rows = new ArrayList<VotacaoSecao>();
	}
        
	@Override
	protected void processRow(String[] entry) {
		rows.add(new VotacaoSecao(entry));
	}
}
