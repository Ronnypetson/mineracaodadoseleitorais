package mineracaodadoseleitorais.dao;

import java.io.IOException;
import mineracaodadoseleitorais.negocio.BemDeCandidato;
import java.util.ArrayList;

public class BemDeCandidatoFileTableReader extends FileTableReader {

        // private ArrayList<BemDeCandidato> rows;
	
	static final String TABLE_PATH
                = "C:\\Users\\ronnypetsonss\\Documents\\UFRN 2016.2\\Projeto de Software\\dados eleitorais de 2014\\bem_candidato_2014\\bem_candidato_2014_RN.txt";
	
	public BemDeCandidatoFileTableReader() throws IOException {
		super(TABLE_PATH);
		rows = new ArrayList<BemDeCandidato>();
                this.columns = new String[8];
                columns[0] = "ANOELEICAO";
                columns[1] = "DESCRICAOELEICAO";
                columns[2] = "SIGLAUF";
                columns[3] = "SEQCANDIDATO";
                columns[4] = "CODIGOTIPODEBEM";
                columns[5] = "DESCRICAOTIPODEBEM";
                columns[6] = "DETALHEBEM";
                columns[7] = "VALORBEM";
                // ID_BEM
	}
	
	@Override
	protected void processRow(String[] entry) {
		rows.add(new BemDeCandidato(entry));
	}
	
	public BemDeCandidato getRow(int index) {
		return (BemDeCandidato)this.rows.get(index);
	}
}
