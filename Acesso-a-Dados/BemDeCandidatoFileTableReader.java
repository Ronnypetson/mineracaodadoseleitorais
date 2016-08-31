package mineracaodadoseleitorais;

import java.util.ArrayList;

public class BemDeCandidatoFileTableReader extends FileTableReader {

private ArrayList<BemDeCandidato> rows;
	
	static final String TABLE_PATH
                = "C:\\Users\\ronnypetsonss\\Documents\\UFRN 2016.2\\Projeto de Software\\dados eleitorais de 2014\\bem_candidato_2014\\bem_candidato_2014_RN.txt";
	
	public BemDeCandidatoFileTableReader() {
		super(TABLE_PATH);
		rows = new ArrayList<BemDeCandidato>();
	}
	
	@Override
	protected void processRow(String[] entry) {
		rows.add(new BemDeCandidato(entry));
	}
	
	public BemDeCandidato getRow(int index) {
		return rows.get(index);
	}

}
