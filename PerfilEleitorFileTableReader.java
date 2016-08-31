package mineracaodadoseleitorais;

import java.util.ArrayList;

public class PerfilEleitorFileTableReader extends FileTableReader {
	private ArrayList<PerfilEleitor> rows;
	
	static final String TABLE_PATH = "C:\\Users\\JP\\Documents\\Aulas\\PDS\\perfil_eleitorado_2014\\perfil_eleitorado_2014.txt"; 
	
	public PerfilEleitorFileTableReader() {
		super(TABLE_PATH);
		rows = new ArrayList<PerfilEleitor>();
	}
	
	@Override
	protected void processRow(String[] entry) {
		rows.add(new PerfilEleitor(entry));
	}
	
	public PerfilEleitor getRow(int index) {
		return rows.get(index);
	}
}
