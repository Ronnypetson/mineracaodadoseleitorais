/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mineracaodadoseleitorais.acessoadados.DAO;

import java.io.IOException;
import java.sql.*;
import mineracaodadoseleitorais.acessoadados.BemDeCandidatoFileTableReader;
import mineracaodadoseleitorais.negocio.BemDeCandidato;

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
    
    public DAOTSE() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance(); // Client
    }
    
    public void connect() throws SQLException{
        dbConnection = 
            DriverManager.getConnection(dbURL, userName, password);
    }
    
    public void disconnect() throws SQLException{
        // stmt.close();
        dbConnection.close();
    }
    
    public void insert() throws SQLException{
        query = "insert into BemDeCandidato values ('2026', 'BIKE09', 'NAC26', 'nova', '0036', 'RJ', '300')";
        stmt = dbConnection.createStatement();
        stmt.execute(query);
        stmt.close();
    }
    
    public void insertAll() throws SQLException{
        BemDeCandidatoFileTableReader ftr = new BemDeCandidatoFileTableReader();
        try {
                ftr.getAll();
                stmt = dbConnection.createStatement();
                int i = 0;
                for(BemDeCandidato bc : ftr.getRows()){
                    query = String.format("insert into BemDeCandidato values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d)",
                            bc.getAnoEleicao(), bc.getDescricaoEleicao(), bc.getSiglaUF(), bc.getSeqCandidato(),
                            bc.getCodigoTipoDeBem(), bc.getDescricaoTipoDeBem(),
                            bc.getDetalheBem(), bc.getValorBem(), i++);
                    stmt.execute(query);
                }
                stmt.close();
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
    
    public ResultSet get() throws SQLException{
        query = "select * from BemDeCandidato";
        Statement stmt = dbConnection.createStatement();
        ResultSet results = stmt.executeQuery(query);
        // stmt.close();
        return results;
    }
    
    public void printGet() throws SQLException{
        ResultSet results = null;
        try {
            results = get();
            while(results.next()){
                System.out.println("Result: " + results.getInt("AnoEleicao")
                        + " | " + results.getString("SeqCandidato"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            results.close();
        }
    }
}
