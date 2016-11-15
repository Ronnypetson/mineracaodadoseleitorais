/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mineracaodadoseleitorais.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ronnypetsonss
 */
public abstract class AbstractElectionDAO {
    
    protected Connection dbConnection;
    protected String password;
    protected String dbURL;
    protected String userName;
    
    public void connect() throws SQLException {
        dbConnection
                = DriverManager.getConnection(dbURL, userName, password);
    }
    
    public void disconnect() throws SQLException {
        // stmt.close();
        dbConnection.close();
    }
}
