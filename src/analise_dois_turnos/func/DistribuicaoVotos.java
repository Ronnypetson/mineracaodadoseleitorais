/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analise_dois_turnos.func;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import analise_dois_turnos.dao.DAOTSE;
import analise_dois_turnos.negocio.VotacaoCandidato;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ronnypetsonss
 */
public class DistribuicaoVotos implements DistribuicaoAbstrataDeVotos {
    
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
    
    public void actionPerformed(ActionEvent e) {
        DAOTSE daoTSE;
        ArrayList<VotacaoCandidato> votacao;
        try{
            daoTSE = new DAOTSE();
            daoTSE.connect();
            votacao = daoTSE.getPerfisVotacao(regiao, cargo);
            daoTSE.disconnect();
            //
            this.distTableModel.setRowCount(0);
            //
            for (VotacaoCandidato vc : votacao) {
                    String r[] = { vc.getNomeCandidato(),
                                vc.getComposicaoLegenda(),
                                vc.getSiglaPartido(),
                                ("\""+ this.cargo.toUpperCase() +"\""),
                                vc.getNomeMunicipio(),
                                vc.getNomeUrnaCandidato(),
                                vc.getNumZona(),
                                vc.getSiglaUF(),
                                vc.getTotalVotos() };
                    this.distTableModel.addRow(r);
            }
            setGraficoDeDistribuicao(votacao);
            //
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

    public void setMapaDeDistribuicao(String nomeCandidato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setGraficoDeDistribuicao(ArrayList<VotacaoCandidato> votacao) {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        TreeMap<String,Integer> data_ = new TreeMap<String,Integer>();
        //
        for (VotacaoCandidato vot : votacao) {
            String perfName = vot.getNomeMunicipio()+vot.getNomeUrnaCandidato();
            Integer qtd = Integer.parseInt(vot.getTotalVotos().replaceAll("[\\D]", ""));
            if(data_.containsKey(perfName)){
                qtd += data_.get(perfName);
            } else {
                data_.put(perfName, qtd);
            }
            // dataSet.setValue(qtd,"Votos",perfName);
            dataSet.setValue(qtd,vot.getNomeUrnaCandidato(),vot.getNomeMunicipio());
        }
        //
        JFreeChart chart
                = ChartFactory
                        .createStackedBarChart("Distribuição de votos",
                                               "Candidatos", "Votos", dataSet);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartFrame frame = new ChartFrame("", chart);
        frame.setVisible(true);
        frame.setSize(450, 500);
        //
    }
    
    public void setMapaDeDistribuicao(ArrayList<VotacaoCandidato> votacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setBarChart(ArrayList<VotacaoCandidato> votacao){
        //
        // Bar Chart
        //
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        TreeMap<String,Integer> data_ = new TreeMap<String,Integer>();
        //
        for (VotacaoCandidato vot : votacao) {
            String perfName = vot.getNomeUrnaCandidato()+vot.getNomeMunicipio();
            Integer qtd = Integer.parseInt(vot.getTotalVotos().replaceAll("[\\D]", ""));
            if(data_.containsKey(perfName)){
                qtd += data_.get(perfName);
            } else {
                data_.put(perfName, qtd);
            }
            dataSet.setValue(qtd,"Votos",perfName);
        }
        //
        JFreeChart chart
                = ChartFactory.createBarChart("Votação",
                                              "Candidato-Município",
                                              "Votos", dataSet,
                                              PlotOrientation.VERTICAL, false,
                                              true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartFrame frame = new ChartFrame("Gráfico de Barras", chart);
        frame.setVisible(true);
        frame.setSize(450, 500);
        //
    }
}
