/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mineracaodadoseleitorais;

import java.util.Arrays;

/**
 *
 * @author ronnypetsonss
 */
public class Legenda extends Votavel {
    private String TipoLegenda;
    private String NumeroPartido;
    private String SiglaPartido;
    private String NomePartido;
    private String SiglaColigacao;
    private String NomeColigacao;
    private String ComposicaoColigacao;

    public Legenda() {
    }

    public Legenda(String[] entry) {
        super(Arrays.copyOfRange(entry, 7, 14));
        this.TipoLegenda = entry[0];
        this.NumeroPartido = entry[1];
        this.SiglaPartido = entry[2];
        this.NomePartido = entry[3];
        this.SiglaColigacao = entry[4];
        this.NomeColigacao = entry[5];
        this.ComposicaoColigacao = entry[6];
    }

    public String getTipoLegenda() {
        return TipoLegenda;
    }

    public void setTipoLegenda(String TipoLegenda) {
        this.TipoLegenda = TipoLegenda;
    }

    public String getNumeroPartido() {
        return NumeroPartido;
    }

    public void setNumeroPartido(String NumeroPartido) {
        this.NumeroPartido = NumeroPartido;
    }

    public String getSiglaPartido() {
        return SiglaPartido;
    }

    public void setSiglaPartido(String SiglaPartido) {
        this.SiglaPartido = SiglaPartido;
    }

    public String getNomePartido() {
        return NomePartido;
    }

    public void setNomePartido(String NomePartido) {
        this.NomePartido = NomePartido;
    }

    public String getSiglaColigacao() {
        return SiglaColigacao;
    }

    public void setSiglaColigacao(String SiglaColigacao) {
        this.SiglaColigacao = SiglaColigacao;
    }

    public String getNomeColigacao() {
        return NomeColigacao;
    }

    public void setNomeColigacao(String NomeColigacao) {
        this.NomeColigacao = NomeColigacao;
    }

    public String getComposicaoColigacao() {
        return ComposicaoColigacao;
    }

    public void setComposicaoColigacao(String ComposicaoColigacao) {
        this.ComposicaoColigacao = ComposicaoColigacao;
    }
}
