/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mineracaodadoseleitorais.dao;

import java.sql.SQLException;

/**
 *
 * @author ronnypetsonss
 */
public interface AbstractElectionDAO {
    
    void connect() throws SQLException;
    
    void disconnect() throws SQLException;
    
}
