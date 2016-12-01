package analise_proporcional.dao;

import java.io.IOException;
import analise_proporcional.negocio.PerfilEleitor;
import java.util.ArrayList;

public class PerfilEleitorFileTableReader extends FileTableReader {
    
    // private ArrayList<PerfilEleitor> rows;
    
    static final String TABLE_PATH
            = "C:\\Users\\ronnypetsonss\\Documents\\UFRN 2016.2\\Projeto de Software"
            + "\\dados eleitorais de 2014\\perfil_eleitor_secao_2014_RN\\perfil_eleitor_secao_2014_RN.txt";
    
    public PerfilEleitorFileTableReader() throws IOException {
        super(TABLE_PATH);
        rows = new ArrayList<PerfilEleitor>();
    }
    
    @Override
    protected void processRow(String[] entry) {
        rows.add(new PerfilEleitor(entry));
    }
    
    public PerfilEleitor getRow(int index) {
        return (PerfilEleitor)rows.get(index);
    }
}
