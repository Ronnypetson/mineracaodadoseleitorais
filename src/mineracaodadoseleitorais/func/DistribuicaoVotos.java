/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mineracaodadoseleitorais.func;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import mineracaodadoseleitorais.dao.DAOTSE;
import mineracaodadoseleitorais.negocio.VotacaoCandidato;

/**
 *
 * @author ronnypetsonss
 */
public class DistribuicaoVotos implements ActionListener {
    
    private JList<String> votosPorSecaoMunicipio;
    private String municipio;
    
    public DistribuicaoVotos(JList<String> votacao, String municipio){
        votosPorSecaoMunicipio = votacao;
        this.municipio = municipio;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        DAOTSE daoTSE;
        ArrayList<VotacaoCandidato> votacao;
        try{
            daoTSE = new DAOTSE();
            daoTSE.connect();
            votacao = daoTSE.getVotacaoCandidatos(this.municipio);
            daoTSE.disconnect();
            Vector<String> output = new Vector<String>();
            for (VotacaoCandidato cand : votacao) {
                    String s = cand.getNomeCandidato()
                                + " | " + cand.getComposicaoLegenda()
                                + " | " + cand.getSiglaPartido()
                                + " | " + cand.getDescricaoCargo()
                                + " | " + cand.getNomeCandidato()
                                + " | " + cand.getNomeMunicipio()
                                + " | " + cand.getNomeUrnaCandidato()
                                + " | " + cand.getNumZona()
                                + " | " + cand.getSiglaUF()
                                + " | " + cand.getTotalVotos();
                    output.add(s);
            }
            votosPorSecaoMunicipio.setListData(output);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DistribuicaoVotos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DistribuicaoVotos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DistribuicaoVotos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DistribuicaoVotos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
    }
}
