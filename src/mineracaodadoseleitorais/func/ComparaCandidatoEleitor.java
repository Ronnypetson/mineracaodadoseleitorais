package mineracaodadoseleitorais.func;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JList;

import mineracaodadoseleitorais.dao.DAOTSE;
import mineracaodadoseleitorais.negocio.Candidatura;
import mineracaodadoseleitorais.negocio.PerfilEleitor;

public class ComparaCandidatoEleitor implements ComparadorAbstratoCandidatoEleitor {
    private JList<String> candidatoList;
    private JList<String> eleitoradoList;

    public ComparaCandidatoEleitor(JList<String> candidatoList, JList<String> eleitoradoList) {
        this.candidatoList = candidatoList;
        this.eleitoradoList = eleitoradoList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            DAOTSE dao;
            ArrayList<Candidatura> candidaturas;
            ArrayList<PerfilEleitor> eleitorado;
            try {
                    dao = new DAOTSE();
                    dao.connect();

                    candidaturas = dao.getPerfisCandidaturasMunicipio("NATAL");
                    eleitorado = dao.getPerfisEleitoresMunicipio("NATAL");

                    dao.disconnect();

                    Vector<String> output = new Vector<String>();
                    for (Candidatura cand : candidaturas) {
                            String s = cand.getNomeCandidato()
                                                    + " | " + cand.getDescricaoSexo()
                                                    + " | " + cand.getDescricaoCorRaca()
                                                    + " | " + cand.getDescricaoEstadoCivil()
                                                    + " | " + cand.getDescricaoGrauInstrucao()
                                                    + " | " + cand.getDescricaoOcupacao()
                                                    + " | " + cand.getDespesaMaximaCampanha();
                            output.add(s);
                    }
                    candidatoList.setListData(output);

                    output = new Vector<String>();
                    for (PerfilEleitor perf : eleitorado) {
                            String s = perf.getUF()
                                        + " | " + perf.getMunicipio()
                                        + " | " + perf.getSexo()
                                        + " | " + perf.getFaixaEtaria()
                                        + " | " + perf.getGrauDeEscolaridade()
                                        + " | " + perf.getNumZona()
                                        + " | " + perf.getQtdNoPerfil();
                            output.add(s);
                    }
                    eleitoradoList.setListData(output);

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
