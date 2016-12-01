/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analise_dois_turnos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import analise_dois_turnos.negocio.Candidatura;
import analise_dois_turnos.negocio.PerfilEleitor;
import analise_dois_turnos.negocio.VotacaoCandidato;

/**
 *
 * @author ronnypetsonss
 */
public abstract class AbstractElectionDAO {
    protected String query;
    protected Statement stmt;
    protected List<String> UF
            = Arrays.asList("AC","AL","AM","AP","BA","CE","DF","ES","GO","MA","MG",
                          "MS","MT","PA","PB","PE","PI","PR","RJ","RN","RO","RR",
                          "RS","SC","SE","SP","TO");
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
    
    public ArrayList<PerfilEleitor> ordenaPerfisDeEleitorPorDominancia(ArrayList<PerfilEleitor> perfis){
        perfis.sort(new Comparator<PerfilEleitor>() {
            @Override
            public int compare(PerfilEleitor o1, PerfilEleitor o2) {
                int a = Integer.parseInt(o1.getQtdNoPerfil().replaceAll("[\\D]", ""));
                int b = Integer.parseInt(o2.getQtdNoPerfil().replaceAll("[\\D]", ""));
                return Integer.compare(b, a);
            }
        });
        return perfis;
    }
    
    public abstract ArrayList<VotacaoCandidato> getPerfisVotacao(String regiao, String cargo, String turno) throws SQLException;
    
    public abstract ArrayList<Candidatura> getPerfisCandidaturas(String regiao, String cargo, String turno, final boolean ordByGastos) throws SQLException;
    
    public abstract ArrayList<PerfilEleitor> getPerfisEleitores(String regiao) throws SQLException;
    
    public abstract ArrayList<Candidatura> ordenaCandidaturasPorDominancia(ArrayList<String[]> entries);
    
    public abstract ArrayList<Candidatura> ordenaCandidaturasPorGastos(ArrayList<String[]> entries);
}