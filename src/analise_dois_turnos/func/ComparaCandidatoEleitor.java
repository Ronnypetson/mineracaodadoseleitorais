package analise_dois_turnos.func;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import analise_dois_turnos.dao.DAOTSE;
import analise_dois_turnos.negocio.Candidatura;
import analise_dois_turnos.negocio.PerfilEleitor;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
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
            //
            candidaturas = dao.getPerfisCandidaturas(regiao, cargo, turno, false);
            eleitorado = dao.getPerfisEleitores(regiao);
            dao.disconnect();
            //
            this.candidatoTableModel.setRowCount(0);
            // clearTable(candidatoTableModel);
            for (Candidatura cand : candidaturas) {
                if(cand.getDespesaMaximaCampanha().compareTo("\"-1\"") != 0){
                    String r[] = { cand.getNomeCandidato(),
                        cand.getDescricaoSexo(),
                        cand.getSiglaPartido(),
                        cand.getDescricaoGrauInstrucao(),
                        cand.getDescricaoCargo(),
                        "" + cand.getTotalVotos() };
                    candidatoTableModel.addRow(r);
                }
            }
            setGraficoCandidato(candidaturas);
            candidaturas.clear();
            //
            this.eleitorTableModel.setRowCount(0);
            // clearTable(eleitorTableModel);
            for (PerfilEleitor perf : eleitorado) {
                String r[] = { perf.getUF(),
                        perf.getMunicipio(),
                        perf.getSexo(),
                        perf.getFaixaEtaria(),
                        perf.getGrauDeEscolaridade(),
                        perf.getNumZona(),
                        perf.getQtdNoPerfil() };
                eleitorTableModel.addRow(r);
            }
            setGraficoEleitor(eleitorado);
            eleitorado.clear();
            //
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
    
    @Override
    public void setGraficoEleitor(ArrayList<PerfilEleitor> eleitores) {
        //
        // Pie Chart
        //
        DefaultPieDataset pieDataSet = new DefaultPieDataset();
        TreeMap<String,Integer> pie_ = new TreeMap<String,Integer>();
        //
        for (PerfilEleitor perf : eleitores) {
            String perfName = perf.getFaixaEtaria() + perf.getSexo();
            Integer qtd = Integer.parseInt(perf.getQtdNoPerfil().replaceAll("[\\D]", ""));
            if(pie_.containsKey(perfName)){
                qtd += pie_.get(perfName);
            } else {
                pie_.put(perfName, qtd);
            }
            pieDataSet.setValue(perfName, qtd);
        }
        //
        JFreeChart pieChart = ChartFactory
                .createPieChart("Eleitores", pieDataSet, true, true, true);
        PiePlot p = (PiePlot)pieChart.getPlot();
        ChartFrame frame = new ChartFrame("", pieChart);
        frame.setVisible(true);
        frame.setSize(450, 500);
        //
    }
    
    @Override
    public void setCorrelacao(String nomeMunicipio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void setGraficoCandidato(ArrayList<Candidatura> cands) {
        //
        // Pie Chart
        //
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        //
        for (Candidatura cand : cands) {
            if(cand.getDespesaMaximaCampanha().compareTo("\"-1\"") != 0){
                dataSet.setValue(cand.getTotalVotos(), "",
                        cand.getNomeUrnaCandidato());
            }
        }
        //
        JFreeChart chart = ChartFactory
                .createBarChart("Votos", "Candidato", "-", dataSet,
                        PlotOrientation.VERTICAL, true, true, true);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartFrame frame = new ChartFrame("", chart);
        frame.setVisible(true);
        frame.setSize(450, 500);
        //
    }
    
    public void clearTable(DefaultTableModel t){
        int n = t.getRowCount();
        for(int i = n-1; i >= 0; i--){
            t.removeRow(i);
        }
    }
}
