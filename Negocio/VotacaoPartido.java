/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mineracaodadoseleitorais.negocio;

import java.util.Arrays;

/**
 *
 * @author ronnypetsonss
 */
public class VotacaoPartido extends Votacao {
    private String TipoLegenda;
    private String NomeColigacao;
    private String ComposicaoLegenda;
    private String SiglaPartido;
    private String NumeroPartido;
    private String NomePartido;
    private String QtdVotosNominais;
    private String QtdVotosLegenda;
    private String VotoEmTransito;
    
    public VotacaoPartido(){
    }
    
    public VotacaoPartido(String[] entry) {
        super(Arrays.copyOfRange(entry, 0, 9));
        this.TipoLegenda = entry[12];
        this.NomeColigacao = entry[13];
        this.ComposicaoLegenda = entry[14];
        this.SiglaPartido = entry[15];
        this.NumeroPartido = entry[16];
        this.NomePartido = entry[17];
        this.QtdVotosNominais = entry[18];
        this.QtdVotosLegenda = entry[19];
        this.VotoEmTransito = entry[20];
    }
    
    public String getTipoLegenda() {
        return TipoLegenda;
    }

    public void setTipoLegenda(String TipoLegenda) {
        this.TipoLegenda = TipoLegenda;
    }

    public String getNomeColigacao() {
        return NomeColigacao;
    }

    public void setNomeColigacao(String NomeColigacao) {
        this.NomeColigacao = NomeColigacao;
    }

    public String getComposicaoLegenda() {
        return ComposicaoLegenda;
    }

    public void setComposicaoLegenda(String ComposicaoLegenda) {
        this.ComposicaoLegenda = ComposicaoLegenda;
    }

    public String getSiglaPartido() {
        return SiglaPartido;
    }

    public void setSiglaPartido(String SiglaPartido) {
        this.SiglaPartido = SiglaPartido;
    }

    public String getNumeroPartido() {
        return NumeroPartido;
    }

    public void setNumeroPartido(String NumeroPartido) {
        this.NumeroPartido = NumeroPartido;
    }

    public String getNomePartido() {
        return NomePartido;
    }

    public void setNomePartido(String NomePartido) {
        this.NomePartido = NomePartido;
    }

    public String getQtdVotosNominais() {
        return QtdVotosNominais;
    }

    public void setQtdVotosNominais(String QtdVotosNominais) {
        this.QtdVotosNominais = QtdVotosNominais;
    }

    public String getQtdVotosLegenda() {
        return QtdVotosLegenda;
    }

    public void setQtdVotosLegenda(String QtdVotosLegenda) {
        this.QtdVotosLegenda = QtdVotosLegenda;
    }

    public String getVotoEmTransito() {
        return VotoEmTransito;
    }

    public void setVotoEmTransito(String VotoEmTransito) {
        this.VotoEmTransito = VotoEmTransito;
    }
}
