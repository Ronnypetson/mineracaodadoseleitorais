/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analise_proporcional.func;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import analise_proporcional.negocio.VotacaoCandidato;

/**
 *
 * @author ronnypetsonss
 */
public interface DistribuicaoAbstrataDeVotos extends ActionListener {
    
    public void setMapaDeDistribuicao(ArrayList<VotacaoCandidato> votacao);
    
    public void setGraficoDeDistribuicao(ArrayList<VotacaoCandidato> votacao);
}
