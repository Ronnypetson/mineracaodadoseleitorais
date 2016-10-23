/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mineracaodadoseleitorais.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ronnypetsonss
 */
public interface AbstractDAO {
    void connect() throws SQLException;
    void disconnect() throws SQLException;
    void clearTable(String tableName) throws SQLException;
    ResultSet get(String tableName) throws SQLException;
    void printGet(String tableName) throws SQLException;
    void printGet(ResultSet results) throws SQLException;
}
