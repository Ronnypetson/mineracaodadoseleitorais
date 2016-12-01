/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analise_proporcional.negocio;

import java.util.Arrays;

/**
 *
 * @author ronnypetsonss
 */
public class VotacaoSecao extends Votacao {

    // private String NumZona;
    private String NumSecao;
    private String NumeroDoVotavel;
    private String QtdVotos;

    public VotacaoSecao() {
    }
    
    public VotacaoSecao(String[] entry) {
        super(Arrays.copyOfRange(entry, 0, 9));
        this.NumZona = entry[9];
        this.NumSecao = entry[10];
        this.NumeroDoVotavel = entry[13];
        this.QtdVotos = entry[14];
    }
    
    @Override
    public void setAll(String[] entry){
        this.NumZona = entry[0];
        this.NumSecao = entry[1];
        this.NumeroDoVotavel = entry[2];
        this.QtdVotos = entry[3];
    }
    
    @Override
    public String getNumZona() {
        return NumZona;
    }
    
    @Override
    public void setNumZona(String NumZona) {
        this.NumZona = NumZona;
    }
    
    public String getNumSecao() {
        return NumSecao;
    }
    
    public void setNumSecao(String NumSecao) {
        this.NumSecao = NumSecao;
    }
    
    public String getNumeroDoVotavel() {
        return NumeroDoVotavel;
    }
    
    public void setNumeroDoVotavel(String NumeroDoVotavel) {
        this.NumeroDoVotavel = NumeroDoVotavel;
    }
    
    public String getQtdVotos() {
        return QtdVotos;
    }
    
    public void setQtdVotos(String QtdVotos) {
        this.QtdVotos = QtdVotos;
    }
}
