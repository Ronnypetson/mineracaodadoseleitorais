/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mineracaodadoseleitorais.func;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import mineracaodadoseleitorais.negocio.Candidatura;

/**
 *
 * @author ronnypetsonss
 */
public interface ComparadorContasDesempenho extends ActionListener {
    
    public void setGraficoBens(ArrayList<Candidatura> candidaturas);
    
    public void setDesempenho(String nomeCandidato);
    
    public void setCorrelacaoContasDesempenho();
    
}
