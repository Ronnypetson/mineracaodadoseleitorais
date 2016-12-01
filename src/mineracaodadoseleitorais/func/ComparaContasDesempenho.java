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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

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
            String cargo, String regiao, String turno) {
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
            candidaturas = dao.getPerfisCandidaturas(regiao, cargo, turno, false);
            //
            gastos = dao.getPerfisCandidaturas(regiao, cargo, turno, true);
            //
            dao.disconnect();
            //
            this.candidatoTableModel.setRowCount(0);
            //
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
            //
            this.contasTableModel.setRowCount(0);
            //
            for (Candidatura perf : gastos) {
                String r[] = { perf.getNomeCandidato(),
                        perf.getDescricaoOcupacao(),
                        perf.getDespesaMaximaCampanha(),
                        perf.getDescricaoCargo(),
                        "" + perf.getTotalVotos(),
                        perf.getSiglaPartido()};
                contasTableModel.addRow(r);
            }
            //
            setGraficoBens(candidaturas);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
    
    public void setGraficoBens(ArrayList<Candidatura> candidaturas) {
        //
        // Line Series Chart
        //
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        //
        int desp, votos;
        Candidatura max_ = candidaturas.get(0);
        desp = Integer.parseInt(max_.getDespesaMaximaCampanha()
                                .replaceAll("[\\D]", ""));
        votos = max_.getTotalVotos();
        double norm_k = desp*1.0/votos;
        for (Candidatura cand : candidaturas) {
            if(cand.getDespesaMaximaCampanha().compareTo("\"-1\"") != 0){
                dataSet.addValue(cand.getTotalVotos()*norm_k, "Desempenho",
                                 cand.getNomeUrnaCandidato());
                Integer despesa
                        = Integer.parseInt(cand.getDespesaMaximaCampanha()
                                .replaceAll("[\\D]", ""));
                dataSet.addValue(despesa, "Despesa",
                                 cand.getNomeUrnaCandidato());
            }
        }
        //
        JFreeChart chart = ChartFactory
                .createLineChart("Contas e desempenho",
                                 "Candidato",
                                 "Votos-Desempenho", dataSet,
                                 PlotOrientation.VERTICAL, true, true, false);
        // LinePlot p = (LinePlot)chart.getPlot();
        ChartFrame frame = new ChartFrame("", chart);
        frame.setVisible(true);
        frame.setSize(450, 500);
        //
    }
    
    public void setDesempenho(String nomeCandidato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setCorrelacaoContasDesempenho() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
