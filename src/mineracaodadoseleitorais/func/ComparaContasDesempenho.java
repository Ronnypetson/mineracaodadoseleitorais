/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mineracaodadoseleitorais.func;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import mineracaodadoseleitorais.dao.DAOTSE;
import mineracaodadoseleitorais.negocio.Candidatura;

/**
 *
 * @author ronnypetsonss
 */
public class ComparaContasDesempenho implements ComparadorContasDesempenho {

    
    private JTable candidatosTable;
    private JTable eleitoresTable;
    private DefaultTableModel candidatoTableModel;
    private DefaultTableModel contasTableModel;
    private String regiao;
    private String turno;
    private String cargo;
    
    public ComparaContasDesempenho(JTable candidatoList, JTable contasList,
            String regiao, String turno, String cargo) {
        this.candidatosTable = candidatoList;
        this.eleitoresTable = contasList;
        this.candidatoTableModel = (DefaultTableModel) this.candidatosTable.getModel();
        this.contasTableModel = (DefaultTableModel) this.eleitoresTable.getModel();
        this.regiao = regiao;
        this.cargo = cargo;
        this.turno = turno;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        DAOTSE dao;
        ArrayList<Candidatura> candidaturas;
        ArrayList<Candidatura> gastos;
        try {
            dao = new DAOTSE();
            dao.connect();
            //
            // Criar um metodo no DAO que busque pelo nome da regiao, cargo e turno
            // Definir a dominancia
            //
            candidaturas = dao.getPerfisCandidaturas(regiao, cargo, false);
            //
            gastos = dao.getPerfisCandidaturas(regiao, cargo, true);
            //
            dao.disconnect();
            //
            this.candidatoTableModel.setRowCount(0);
            //
            // Vector<String> output = new Vector<String>();
            for (Candidatura cand : candidaturas) {
                if(cand.getDespesaMaximaCampanha().compareTo("\"-1\"") != 0){
                    String r[] = { cand.getNomeCandidato(),
                        cand.getDescricaoSexo(),
                        cand.getNomePartido(),
                        // cand.getDescricaoEstadoCivil(),
                        cand.getDescricaoGrauInstrucao(),
                        // cand.getDescricaoOcupacao()
                        // cand.getDespesaMaximaCampanha(),
                        cand.getDescricaoCargo(),
                        "" + cand.getTotalVotos() };
                    // output.add(s);
                    candidatoTableModel.addRow(r);
                }
            }
            //
            this.contasTableModel.setRowCount(0);
            //
            // output = new Vector<String>();
            for (Candidatura perf : gastos) {
                String r[] = { perf.getNomeCandidato(),
                        perf.getDescricaoOcupacao(),
                        perf.getDespesaMaximaCampanha(),
                        perf.getDescricaoCargo(),
                        "" + perf.getTotalVotos(),
                        perf.getNomePartido()};
                // output.add(s);
                contasTableModel.addRow(r);
            }
            // eleitoradoList.setListData(output);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public void setGraficoBens(String nomeCandidato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDesempenho(String nomeCandidato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCorrelacaoContasDesempenho() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
