/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mineracaodadoseleitorais.DAO;

import java.io.IOException;
import java.sql.*;
import mineracaodadoseleitorais.negocio.BemDeCandidato;
import mineracaodadoseleitorais.negocio.Candidatura;

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
    
    public void insertTest() throws SQLException {
        query = "insert into BemDeCandidato values ('2026', 'BIKE09', 'NAC26', 'nova', '0036', 'RJ', '300')";
        stmt = dbConnection.createStatement();
        stmt.execute(query);
        stmt.close();
    }
    
    public void insertAllBemDeCandidato() throws SQLException {
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
                stmt.close();
            }
            // stmt.close();
        } catch (IOException e) {
        }
    }
    
    public void insertAllCandidatura() throws SQLException {
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
                stmt.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearTable(String tableName) throws SQLException {
        query = "delete from " + tableName + " where true";
        Statement stmt = dbConnection.createStatement();
        stmt.execute(query);
        stmt.close();
    }

    public ResultSet getTest() throws SQLException {
        query = "select * from BemDeCandidato";
        Statement stmt = dbConnection.createStatement();
        ResultSet results = stmt.executeQuery(query);
        // stmt.close();
        return results;
    }
    
    public ResultSet get(String tableName) throws SQLException { // throws SQLException
        query = "select * from " + tableName;
        Statement stmt = dbConnection.createStatement();
        ResultSet results = stmt.executeQuery(query);
        //stmt.close();
        return results;
    }
    
    public void printGetCandidatura() throws SQLException {
        ResultSet results;
        results = get("Candidatura");
        while (results.next()) {
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
        results = get("BemDeCadidato");
        while (results.next()) {
            System.out.println(": " + results.getString("SEQCANDIDATO")
                    + " |   " + results.getString("NOMEURNACANDIDATO")
                    + " |   " + results.getString("SIGLAPARTIDO")
                    + " |   " + results.getString("NOMELEGENDA")
                    + " |   " + results.getString("DESPESAMAXIMACAMPANHA")
                    + " |   " + results.getString("CODIGOTOTALIZACAOTURNO")
                    + " |   " + results.getString("EMAILCANDIDATO"));
        }
    }
    
    public void printGetTest() throws SQLException { // throws SQLException
        ResultSet results;
        results = getTest();
        while (results.next()) {
            System.out.println("Result: " + results.getString("AnoEleicao")
                    + " | " + results.getString("SeqCandidato"));
        }
    }
}
