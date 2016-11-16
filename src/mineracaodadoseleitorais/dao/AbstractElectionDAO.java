/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mineracaodadoseleitorais.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import mineracaodadoseleitorais.negocio.Candidatura;
import mineracaodadoseleitorais.negocio.PerfilEleitor;

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
    
    public ArrayList<Candidatura> ordenaCandidaturasPorDominancia(ArrayList<String[]> entries){
        TreeMap<String, Candidatura> dominancias = new TreeMap<String, Candidatura>();
        ArrayList<Candidatura> perfis = new ArrayList<Candidatura>();
        // TreeSet<String> hperfis = new TreeSet<String>();
        for (String[] entry : entries) {
            Candidatura cand = new Candidatura();
            cand.setAll(entry);
            // perfis.add(cand);
            String seq = cand.getSeqCandidato();
            int votes = Integer.parseInt(entry[44].replaceAll("[\\D]", ""));
            if(dominancias.containsKey(seq)){
                int total = dominancias.get(seq).getTotalVotos();
                dominancias.get(seq).setTotalVotos(total + votes);
            } else {
                dominancias.put(seq, cand);
            }
        }
        //
        for(Candidatura c: dominancias.values()){
            perfis.add(c);
        }
        //
        perfis.sort(new Comparator<Candidatura>(){
            @Override
            public int compare(Candidatura o1, Candidatura o2) {
                return Integer.compare(o2.getTotalVotos(), o1.getTotalVotos());
            }
        });
        return perfis;
    }
    
    public ArrayList<Candidatura> ordenaCandidaturasPorGastos(ArrayList<String[]> entries){
        TreeMap<String, Candidatura> dominancias = new TreeMap<String, Candidatura>();
        ArrayList<Candidatura> perfis = new ArrayList<Candidatura>();
        // TreeSet<String> hperfis = new TreeSet<String>();
        for (String[] entry : entries) {
            Candidatura cand = new Candidatura();
            cand.setAll(entry);
            // perfis.add(cand);
            String seq = cand.getSeqCandidato();
            int votes = Integer.parseInt(entry[44].replaceAll("[\\D]", ""));
            if(dominancias.containsKey(seq)){
                int total = dominancias.get(seq).getTotalVotos();
                dominancias.get(seq).setTotalVotos(total + votes);
            } else {
                dominancias.put(seq, cand);
            }
        }
        //
        for(Candidatura c: dominancias.values()){
            perfis.add(c);
        }
        //
        perfis.sort(new Comparator<Candidatura>(){
            @Override
            public int compare(Candidatura o1, Candidatura o2) {
                int a = Integer.parseInt(o1.getDespesaMaximaCampanha().replaceAll("[\\D]", ""));
                int b = Integer.parseInt(o2.getDespesaMaximaCampanha().replaceAll("[\\D]", ""));
                return Integer.compare(b, a);
            }
        });
        return perfis;
    }
}
