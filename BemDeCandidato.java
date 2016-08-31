/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mineracaodadoseleitorais;

/**
 *
 * @author ronnypetsonss
 */
public class BemDeCandidato {
    private String AnoEleicao;
    private String DescricaoEleicao;
    private String SiglaUF;
    private String SeqCandidato;
    private String CodigoTipoDeBem;
    private String DescricaoTipoDeBem;
    private String DetalheBem;
    private String ValorBem;

    public BemDeCandidato() {
    }

    public BemDeCandidato(String[] entry) {
        this.AnoEleicao = entry[0];
        this.DescricaoEleicao = entry[1];
        this.SiglaUF = entry[2];
        this.SeqCandidato = entry[3];
        this.CodigoTipoDeBem = entry[4];
        this.DescricaoTipoDeBem = entry[5];
        this.DetalheBem = entry[6];
        this.ValorBem = entry[7];
    }

    public String getAnoEleicao() {
        return AnoEleicao;
    }

    public void setAnoEleicao(String AnoEleicao) {
        this.AnoEleicao = AnoEleicao;
    }

    public String getDescricaoEleicao() {
        return DescricaoEleicao;
    }

    public void setDescricaoEleicao(String DescricaoEleicao) {
        this.DescricaoEleicao = DescricaoEleicao;
    }

    public String getSiglaUF() {
        return SiglaUF;
    }

    public void setSiglaUF(String SiglaUF) {
        this.SiglaUF = SiglaUF;
    }

    public String getSeqCandidato() {
        return SeqCandidato;
    }

    public void setSeqCandidato(String SeqCandidato) {
        this.SeqCandidato = SeqCandidato;
    }

    public String getCodigoTipoDeBem() {
        return CodigoTipoDeBem;
    }

    public void setCodigoTipoDeBem(String CodigoTipoDeBem) {
        this.CodigoTipoDeBem = CodigoTipoDeBem;
    }

    public String getDescricaoTipoDeBem() {
        return DescricaoTipoDeBem;
    }

    public void setDescricaoTipoDeBem(String DescricaoTipoDeBem) {
        this.DescricaoTipoDeBem = DescricaoTipoDeBem;
    }

    public String getDetalheBem() {
        return DetalheBem;
    }

    public void setDetalheBem(String DetalheBem) {
        this.DetalheBem = DetalheBem;
    }

    public String getValorBem() {
        return ValorBem;
    }

    public void setValorBem(String ValorBem) {
        this.ValorBem = ValorBem;
    }
}
