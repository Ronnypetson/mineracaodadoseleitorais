package mineracaodadoseleitorais.func;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mineracaodadoseleitorais.dao.DAOTSE;
import mineracaodadoseleitorais.negocio.Candidatura;
import mineracaodadoseleitorais.negocio.PerfilEleitor;

public class ComparaCandidatoEleitor implements ComparadorAbstratoCandidatoEleitor {

    private JTable candidatosTable;
    private JTable eleitoresTable;
    private DefaultTableModel candidatoTableModel;
    private DefaultTableModel eleitorTableModel;
    private String regiao;
    private String turno;
    private String cargo;
    
    public ComparaCandidatoEleitor(JTable candidatoList, JTable eleitoradoList,
            String regiao, String turno, String cargo) {
        this.candidatosTable = candidatoList;
        this.eleitoresTable = eleitoradoList;
        this.candidatoTableModel = (DefaultTableModel) this.candidatosTable.getModel();
        this.eleitorTableModel = (DefaultTableModel) this.eleitoresTable.getModel();
        this.regiao = regiao;
        this.cargo = cargo;
        this.turno = turno;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        DAOTSE dao;
        ArrayList<Candidatura> candidaturas;
        ArrayList<PerfilEleitor> eleitorado;
        try {
            dao = new DAOTSE();
            dao.connect();
            //
            // Criar um metodo no DAO que busque pelo nome da regiao, cargo e turno
            // Definir a dominancia
            //
            candidaturas = dao.getPerfisCandidaturas(regiao, cargo);
            //
            eleitorado = dao.getPerfisEleitores(regiao);
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
                        // cand.getDescricaoCorRaca(),
                        // cand.getDescricaoEstadoCivil(),
                        cand.getDescricaoGrauInstrucao(),
                        // cand.getDescricaoOcupacao()
                        cand.getDespesaMaximaCampanha(),
                        cand.getDescricaoCargo(),
                        "" + cand.getTotalVotos() };
                    // output.add(s);
                    candidatoTableModel.addRow(r);
                }
            }
            //
            this.eleitorTableModel.setRowCount(0);
            //
            // output = new Vector<String>();
            for (PerfilEleitor perf : eleitorado) {
                String r[] = { perf.getUF(),
                        perf.getMunicipio(),
                        perf.getSexo(),
                        perf.getFaixaEtaria(),
                        perf.getGrauDeEscolaridade(),
                        perf.getNumZona(),
                        perf.getQtdNoPerfil() };
                // output.add(s);
                eleitorTableModel.addRow(r);
            }
            // eleitoradoList.setListData(output);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public void setGraficoCandidato(String nomeMunicipio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setGraficoEleitor(String nomeMunicipio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCorrelacao(String nomeMunicipio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
