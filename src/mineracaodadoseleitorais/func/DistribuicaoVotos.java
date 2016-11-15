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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import mineracaodadoseleitorais.dao.DAOTSE;
import mineracaodadoseleitorais.negocio.VotacaoCandidato;

/**
 *
 * @author ronnypetsonss
 */
public class DistribuicaoVotos implements ActionListener {
    
    private JTable votosPorSecaoMunicipio;
    private String regiao;
    private String cargo;
    private String turno;
    private DefaultTableModel distTableModel;
    
    public DistribuicaoVotos(JTable votacao, String regiao, String cargo, String turno){
        votosPorSecaoMunicipio = votacao;
        this.regiao = regiao;
        this.cargo = cargo;
        this.turno = turno;
        distTableModel = (DefaultTableModel) votacao.getModel();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        DAOTSE daoTSE;
        ArrayList<VotacaoCandidato> votacao;
        try{
            daoTSE = new DAOTSE();
            daoTSE.connect();
            votacao = daoTSE.getVotacaoCandidatos(this.regiao);
            daoTSE.disconnect();
            //
            for (VotacaoCandidato vc : votacao) {
                    String r[] = { vc.getNomeCandidato(),
                                vc.getComposicaoLegenda(),
                                vc.getSiglaPartido(),
                                vc.getDescricaoCargo(),
                                vc.getNomeCandidato(),
                                vc.getNomeMunicipio(),
                                vc.getNomeUrnaCandidato(),
                                vc.getNumZona(),
                                vc.getSiglaUF(),
                                vc.getTotalVotos() };
                    this.distTableModel.addRow(r);
            }
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
