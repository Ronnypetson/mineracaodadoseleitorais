/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analise_proporcional.negocio;

/**
 *
 * @author ronnypetsonss
 */
public class Votavel extends AbstractVotavel {

    protected String SiglaUF;
    protected String SiglaUE;
    protected String NomeUE;
    protected String CodigoCargo;
    protected String NumeroPartido;
    protected String SiglaPartido;
    protected String NomePartido;

    public Votavel() {
    }

    public Votavel(String[] entry) {
        this.AnoEleicao = entry[0];
        this.NumTurno = entry[1];
        this.SiglaUF = entry[2];
        this.SiglaUE = entry[3];
        this.NomeUE = entry[4];
        this.CodigoCargo = entry[5];
        this.DescricaoCargo = entry[6];

    }

    public void setAll(String[] entry) {
    }

    public String getAnoEleicao() {
        return AnoEleicao;
    }

    public void setAnoEleicao(String AnoEleicao) {
        this.AnoEleicao = AnoEleicao;
    }

    public String getNumTurno() {
        return NumTurno;
    }

    public void setNumTurno(String NumTurno) {
        this.NumTurno = NumTurno;
    }

    public String getSiglaUF() {
        return SiglaUF;
    }

    public void setSiglaUF(String SiglaUF) {
        this.SiglaUF = SiglaUF;
    }

    public String getSiglaUE() {
        return SiglaUE;
    }

    public void setSiglaUE(String SiglaUE) {
        this.SiglaUE = SiglaUE;
    }

    public String getNomeUE() {
        return NomeUE;
    }

    public void setNomeUE(String NomeUE) {
        this.NomeUE = NomeUE;
    }

    public String getCodigoCargo() {
        return CodigoCargo;
    }

    public void setCodigoCargo(String CodigoCargo) {
        this.CodigoCargo = CodigoCargo;
    }

    public String getDescricaoCargo() {
        return DescricaoCargo;
    }

    public void setDescricaoCargo(String DescricaoCargo) {
        this.DescricaoCargo = DescricaoCargo;
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
}
