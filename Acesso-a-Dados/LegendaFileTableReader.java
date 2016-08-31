package mineracaodadoseleitorais;

import java.util.ArrayList;

public class LegendaFileTableReader extends FileTableReader {
	private ArrayList<Legenda> rows;
	
	static final String TABLE_PATH = "C:\\Users\\JP\\Documents\\Aulas\\PDS\\consulta_legendas_2014\\consulta_legendas_2014_RN.txt";
	
	public LegendaFileTableReader() {
		super(TABLE_PATH);
		rows = new ArrayList<Legenda>();
	}

	@Override
	protected void processRow(String[] entry) {
		rows.add(new Legenda(entry));
	}
}
