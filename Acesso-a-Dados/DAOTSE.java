/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mineracaodadoseleitorais.DAO;

import java.io.IOException;
import java.sql.*;
import mineracaodadoseleitorais.negocio.*;
/**
 *
 * @author ronnypetsonss
 */
public class DAOTSE {
    
    private Connection dbConnection;
    private final String password = "123";
    private final String dbURL = "jdbc:derby://localhost:1527/db_test1";
    private final String userName = "ronny";
    private String query;
    private Statement stmt;
    
    public DAOTSE() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance(); // Client
    }
    
    public void connect() throws SQLException {
        dbConnection
                = DriverManager.getConnection(dbURL, userName, password);
    }
    
    public void disconnect() throws SQLException {
        // stmt.close();
        dbConnection.close();
    }
    
    public void insertAllBemDeCandidato() throws SQLException, IOException {
        BemDeCandidatoFileTableReader ftr = new BemDeCandidatoFileTableReader();
        try {
            ftr.getAll();
            stmt = dbConnection.createStatement();
            int i = 0;
            for (Object ob : ftr.getRows()) {
                BemDeCandidato bc = (BemDeCandidato) ob;
                query = String.format("insert into BemDeCandidato values ('%s',"
                        + " '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d)",
                        bc.getAnoEleicao(), bc.getDescricaoEleicao(),
                        bc.getSiglaUF(), bc.getSeqCandidato(),
                        bc.getCodigoTipoDeBem(), bc.getDescricaoTipoDeBem(),
                        bc.getDetalheBem(), bc.getValorBem(), i++);
                stmt.execute(query);
                // stmt.close();
            }
            stmt.close();
        } catch (IOException e) {
        }
    }
    
    public void insertAllCandidatura() throws SQLException, IOException {
        CandidaturaFileTableReader ftr = new CandidaturaFileTableReader();
        try {
            ftr.getAll();
            stmt = dbConnection.createStatement();
            int i = 0;
            for (Object ob : ftr.getRows()) {
                Candidatura cand = (Candidatura) ob;
                query = String.format("insert into Candidatura values ('%s',"
                        + "'%s','%s','%s','%s','%s','%s','%s','%s','%s','%s',"
                        + "'%s','%s','%s','%s','%s','%s','%s','%s','%s','%s',"
                        + "'%s','%s','%s','%s','%s','%s',%d)",
                        cand.getNomeCandidato(), cand.getSeqCandidato(),
                        cand.getNumeroCandidato(), cand.getCPFCandidato(),
                        cand.getNomeUrnaCandidato(), cand.getNumeroPartido(),
                        cand.getSiglaPartido(), cand.getNomePartido(), cand.getCodigoLegenda(),
                        cand.getSiglaLegenda(), cand.getComposicaoLegenda(),
                        cand.getNomeLegenda(), cand.getDescricaoOcupacao(),
                        cand.getDataNascimento(), cand.getNumTituloEleitoral(),
                        cand.getIdadeNaEleicao(), cand.getDescricaoSexo(),
                        cand.getDescricaoGrauInstrucao(), cand.getDescricaoEstadoCivil(),
                        cand.getDescricaoCorRaca(), cand.getCodigoNacionalidade(),
                        cand.getSiglaUFNascimento(), cand.getCodigoMunicipioNascimento(),
                        cand.getNomeMunicipioNascimento(), cand.getDespesaMaximaCampanha(),
                        cand.getCodigoTotalizacaoTurno(), cand.getEmailCandidato(), i++);
                stmt.execute(query);
                //stmt.close();
            }
            stmt.close();
        } catch (IOException e) {
        }
    }
    
    public void insertAllLegenda() throws SQLException, IOException {
        FileTableReader ftr = new LegendaFileTableReader();
        try {
            ftr.getAll();
            stmt = dbConnection.createStatement();
            int i = 0;
            for (Object ob : ftr.getRows()) {
                Legenda leg = (Legenda) ob;
                query = String.format("insert into Legenda values ('%s',"
                        + " '%s', '%s', '%s', '%s', '%s', '%s', %d)",
                        leg.getTipoLegenda(), leg.getNumeroPartido(),
                        leg.getSiglaPartido(), leg.getNomePartido(),
                        leg.getSiglaColigacao(), leg.getComposicaoColigacao(),
                        leg.getSeqColigacao(), i++);
                stmt.execute(query);
                // stmt.close();
            }
            stmt.close();
        } catch (IOException e) {
        }
    }
    
    public void insertAllPerfilEleitor() throws SQLException, IOException {
        FileTableReader ftr = new PerfilEleitorFileTableReader();
        try {
            ftr.getAll();
            stmt = dbConnection.createStatement();
            int i = 0;
            for (Object ob : ftr.getRows()) {
                PerfilEleitor pel = (PerfilEleitor) ob;
                query = String.format("insert into PerfilEleitor values ('%s',"
                        + " '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d)",
                        pel.getPeriodo(), pel.getUF(), pel.getMunicipio(),
                        pel.getCodigoMunicipioTSE(), pel.getNumZona(), pel.getSexo(),
                        pel.getFaixaEtaria(), pel.getGrauDeEscolaridade(),
                        pel.getQtdNoPerfil(), i++);
                stmt.execute(query);
                // stmt.close();
            }
            stmt.close();
        } catch (IOException e) {
        }
    }
    
    public void insertAllVotacaoCandidato() throws SQLException, IOException {
        FileTableReader ftr = new VotacaoCandidatoFileTableReader();
        try {
            ftr.getAll();
            stmt = dbConnection.createStatement();
            int i = 0;
            for (Object ob : ftr.getRows()) {
                VotacaoCandidato vc = (VotacaoCandidato) ob;
                query = String.format("insert into VotacaoCandidato values ('%s',"
                        + " '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s',"
                        + " '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d)",
                        vc.getNumeroCandidato(), vc.getSeqCandidato(),
                        vc.getNomeCandidato(), vc.getNomeUrnaCandidato(),
                        vc.getCodigoSituacaoCandidatoSuperior(),
                        vc.getDescricaoSituacaoCandidatoSuperior(),
                        vc.getCodigoSituacaoCandidato(),
                        vc.getDescricaoSituacaoCandidato(),
                        vc.getCodigoSituacaoCandidatoTotal(),
                        vc.getDescricaoSituacaoCandidatoTotal(),
                        vc.getNumeroPartido(), vc.getSiglaPartido(),
                        vc.getSeqLegenda(), vc.getNomeColigacao(),
                        vc.getComposicaoLegenda(), vc.getTotalVotos(),
                        vc.getVotoEmTransito(), i++);
                stmt.execute(query);
                // stmt.close();
            }
            stmt.close();
        } catch (IOException e) {
        }
    }
    
    public void insertAllVotacaoPartido() throws SQLException, IOException {
        FileTableReader ftr = new VotacaoPartidoFileTableReader();
        try {
            ftr.getAll();
            stmt = dbConnection.createStatement();
            int i = 0;
            for (Object ob : ftr.getRows()) {
                VotacaoPartido vp = (VotacaoPartido) ob;
                query = String.format("insert into VotacaoPartido values ('%s',"
                        + " '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d)",
                        vp.getTipoLegenda(), vp.getNomeColigacao(),
                        vp.getComposicaoLegenda(), vp.getSiglaPartido(),
                        vp.getNumeroPartido(), vp.getNomePartido(),
                        vp.getQtdVotosNominais(), vp.getQtdVotosLegenda(),
                        vp.getVotoEmTransito(), i++);
                stmt.execute(query);
                // stmt.close();
            }
            stmt.close();
        } catch (IOException e) {
        }
    }
    
    public void insertAllVotacaoSecao() throws SQLException, IOException {
        FileTableReader ftr = new VotacaoSecaoFileTableReader();
        try {
            ftr.getAll();
            stmt = dbConnection.createStatement();
            int i = 0;
            for (Object ob : ftr.getRows()) {
                VotacaoSecao vs = (VotacaoSecao) ob;
                query = String.format("insert into VotacaoSecao values ('%s',"
                        + " '%s', '%s', '%s', %d)",
                        vs.getNumZona(), vs.getNumSecao(),
                        vs.getNumeroDoVotavel(), vs.getQtdVotos(), i++);
                stmt.execute(query);
                // stmt.close();
            }
            stmt.close();
        } catch (IOException e) {
        }
    }
    
    //
    public void clearTable(String tableName) throws SQLException {
        query = "delete from " + tableName + " where true";
        Statement stmt = dbConnection.createStatement();
        stmt.execute(query);
        stmt.close();
    }
    
    public ResultSet get(String tableName) throws SQLException { // throws SQLException
        query = "select * from " + tableName;
        Statement stmt = dbConnection.createStatement();
        ResultSet results = stmt.executeQuery(query);
        //stmt.close();
        return results;
    }
    
    public void printGet(String tableName) throws SQLException {
        ResultSet results;
        results = get(tableName);
        int columnCount = results.getMetaData().getColumnCount();
        while (results.next()) { // results.toString()
            for(int i = 1; i <= columnCount; i++){
                System.out.print(" | " + results.getString(i));
            }
            System.out.println();
        }
    }
    
    // --
    public void printGetCandidatura() throws SQLException {
        ResultSet results;
        results = get("Candidatura");
        while (results.next()) { // results.toString()
            System.out.println(": " + results.getString("SEQCANDIDATO")
                    + " |   " + results.getString("NOMEURNACANDIDATO")
                    + " |   " + results.getString("SIGLAPARTIDO")
                    + " |   " + results.getString("NOMELEGENDA")
                    + " |   " + results.getString("DESPESAMAXIMACAMPANHA")
                    + " |   " + results.getString("CODIGOTOTALIZACAOTURNO")
                    + " |   " + results.getString("EMAILCANDIDATO"));
        }
    }
    
    public void printGetBemDeCandidato() throws SQLException {
        ResultSet results;
        results = get("BemDeCandidato");
        while (results.next()) {
            System.out.println(": " + results.getString("AnoEleicao")
                    + " |   " + results.getString("DescricaoEleicao")
                    + " |   " + results.getString("SiglaUF")
                    + " |   " + results.getString("SeqCandidato")
                    + " |   " + results.getString("CodigoTipoDeBem")
                    + " |   " + results.getString("DetalheBem")
                    + " |   " + results.getString("ValorBem"));
        }
    }
    
    public void insertTest() throws SQLException {
        query = "insert into BemDeCandidato values ('2026', 'BIKE09', 'NAC26', 'nova', '0036', 'RJ', '300')";
        stmt = dbConnection.createStatement();
        stmt.execute(query);
        stmt.close();
    }
}
