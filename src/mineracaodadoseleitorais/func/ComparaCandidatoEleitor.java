package mineracaodadoseleitorais.func;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mineracaodadoseleitorais.dao.DAOTSE;
import mineracaodadoseleitorais.negocio.Candidatura;
import mineracaodadoseleitorais.negocio.PerfilEleitor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

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
            candidaturas = dao.getPerfisCandidaturas(regiao, cargo, false);
            //
            eleitorado = dao.getPerfisEleitores(regiao);
            //
            dao.disconnect();
            //
            this.candidatoTableModel.setRowCount(0);
            //
            //
            // Pie Chart
            //
            DefaultPieDataset pieDataSet = new DefaultPieDataset();
            //
            for (Candidatura cand : candidaturas) {
                if(cand.getDespesaMaximaCampanha().compareTo("\"-1\"") != 0){
                    String r[] = { cand.getNomeCandidato(),
                        cand.getDescricaoSexo(),
                        cand.getSiglaPartido(),
                        // cand.getDescricaoEstadoCivil(),
                        cand.getDescricaoGrauInstrucao(),
                        // cand.getDescricaoOcupacao(),
                        // cand.getDespesaMaximaCampanha(),
                        cand.getDescricaoCargo(),
                        "" + cand.getTotalVotos() };
                    // output.add(s);
                    candidatoTableModel.addRow(r);
                    pieDataSet.setValue(cand.getNomeUrnaCandidato(),
                                        cand.getTotalVotos());
                }
            }
            //
            JFreeChart pieChart = ChartFactory
                    .createPieChart("", pieDataSet, true, true, true);
            PiePlot p = (PiePlot)pieChart.getPlot();
            ChartFrame frame = new ChartFrame("Gráfico de Pizza", pieChart);
            frame.setVisible(true);
            frame.setSize(450, 500);
            //
            this.eleitorTableModel.setRowCount(0);
            //
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
