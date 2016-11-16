/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mineracaodadoseleitorais.func;

import java.awt.event.ActionListener;

/**
 *
 * @author ronnypetsonss
 */
public interface DistribuicaoAbstrataDeVotos extends ActionListener {
    
    public void setMapaDeDistribuicao(String nomeCandidato);
    
    public void setGraficoDeDistribuicao(String nomeCandidato);
}
