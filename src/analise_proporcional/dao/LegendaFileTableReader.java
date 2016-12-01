package analise_proporcional.dao;

import java.io.IOException;
import analise_proporcional.negocio.Legenda;
import java.util.ArrayList;

public class LegendaFileTableReader extends FileTableReader {
    
    // private ArrayList<Legenda> rows;
    static final String TABLE_PATH
            = "C:\\Users\\ronnypetsonss\\Documents\\UFRN 2016.2"
            + "\\Projeto de Software\\dados eleitorais de 2014\\consulta_legendas_2014\\consulta_legendas_2014_RN.txt";
    
    public LegendaFileTableReader() throws IOException {
        super(TABLE_PATH);
        rows = new ArrayList<Legenda>();
        this.columns = new String[7];
        columns[0] = "TIPOLEGENDA";
        columns[1] = "NUMEROPARTIDO";
        columns[2] = "SIGLAPARTIDO";
        columns[3] = "NOMEPARTIDO";
        columns[4] = "SIGLACOLIGACAO";
        columns[5] = "COMPOSICAOCOLIGACAO";
        columns[6] = "SEQCOLIGACAO";
        // ID
    }
    
    @Override
    protected void processRow(String[] entry) {
        rows.add(new Legenda(entry));
    }
}
