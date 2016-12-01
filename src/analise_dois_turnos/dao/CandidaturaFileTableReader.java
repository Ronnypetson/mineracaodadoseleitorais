package analise_dois_turnos.dao;

import java.io.IOException;
import analise_dois_turnos.negocio.Candidatura;
import java.util.ArrayList;

public class CandidaturaFileTableReader extends FileTableReader {

    // private ArrayList<Candidatura> rows;
    static String FOLDER
            = "C:\\Users\\ronnypetsonss\\Documents\\UFRN 2016.2\\Projeto de Software\\dados eleitorais de 2014\\consulta_cand_2014\\consulta_cand_2014_";
    static String TABLE_PATH
            = "C:\\Users\\ronnypetsonss\\Documents\\UFRN 2016.2\\Projeto de Software\\dados eleitorais de 2014\\consulta_cand_2014\\consulta_cand_2014_RN.txt";
    
    public CandidaturaFileTableReader() throws IOException {
        super(TABLE_PATH);
        rows = new ArrayList<Candidatura>();
        this.columns = new String[29];
        columns[0] = "NOMECANDIDATO";
        columns[1] = "SEQCANDIDATO";
        columns[2] = "NUMEROCANDIDATO";
        columns[3] = "CPFCANDIDATO";
        columns[4] = "NOMEURNACANDIDATO";
        columns[5] = "NUMEROPARTIDO";
        columns[6] = "SIGLAPARTIDO";
        columns[7] = "NOMEPARTIDO";
        columns[8] = "CODIGOLEGENDA";
        columns[9] = "SIGLALEGENDA";
        columns[10] = "COMPOSICAOLEGENDA";
        columns[11] = "NOMELEGENDA";
        columns[12] = "DESCRICAOOCUPACAO";
        columns[13] = "DATANASCIMENTO";
        columns[14] = "NUMTITULOELEITORAL";
        columns[15] = "IDADENAELEICAO";
        columns[16] = "DESCRICAOSEXO";
        columns[17] = "DESCRICAOGRAUINSTRUCAO";
        columns[18] = "DESCRICAOESTADOCIVIL";
        columns[19] = "DESCRICAOCORRACA";
        columns[20] = "CODIGONACIONALIDADE";
        columns[21] = "SIGLAUFNASCIMENTO";
        columns[22] = "CODIGOMUNICIPIONASCIMENTO";
        columns[23] = "NOMEMUNICIPIONASCIMENTO";
        columns[24] = "DESPESAMAXIMACAMPANHA";
        columns[25] = "CODIGOTOTALZACAOTURNO";
        columns[26] = "EMAILCANDIDATO";
        // ID (27 + 1)
        columns[28] = "DESCRICAOCARGO";
    }
    
    @Override
    protected void processRow(String[] entry) {
        rows.add(new Candidatura(entry));
    }
}
