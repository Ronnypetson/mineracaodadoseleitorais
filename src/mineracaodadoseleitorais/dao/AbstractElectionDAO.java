/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mineracaodadoseleitorais.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ronnypetsonss
 */
public interface AbstractElectionDAO {
    void connect() throws SQLException;
    void disconnect() throws SQLException;
    void clearTable(String tableName) throws SQLException;
    ResultSet get(String tableName) throws SQLException;
    void printGet(String tableName) throws SQLException;
    void printGet(ResultSet results) throws SQLException;
    void insertAllCandidatura() throws SQLException, IOException;
    void insertAllLegenda() throws SQLException, IOException;
    void insertAllPerfilEleitor() throws SQLException, IOException;
    void insertAllVotacaoCandidato() throws SQLException, IOException;
    void insertAllVotacaoPartido() throws SQLException, IOException;
}
