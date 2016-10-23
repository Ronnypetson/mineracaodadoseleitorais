/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mineracaodadoseleitorais.negocio;

/**
 *
 * @author ronnypetsonss
 */
public class Votacao {
    protected String AnoEleicao;
    protected String NumTurno;
    protected String DescricaoEleicao;
    protected String SiglaUF;
    protected String SigaUE;
    protected String CodigoMunicipio;
    protected String NomeMunicipio;
    protected String CodigoCargo;
    protected String DescricaoCargo;
    protected String NumZona;
    
    public Votacao(){
    }
    
    public Votacao(String[] entry) {
        this.AnoEleicao = entry[0];
        this.NumTurno = entry[1];
        this.DescricaoEleicao = entry[2];
        this.SiglaUF = entry[3];
        this.SigaUE = entry[4];
        this.CodigoMunicipio = entry[5];
        this.NomeMunicipio = entry[6];
        this.CodigoCargo = entry[7];
        this.DescricaoCargo = entry[8];
        //this.NumZona = entry[9];
    }
    
    public void setAll(String[] entry){
    }
    
    public String getNumZona() {
        return NumZona;
    }

    public void setNumZona(String NumZona) {
        this.NumZona = NumZona;
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

    public String getSigaUE() {
        return SigaUE;
    }

    public void setSigaUE(String SigaUE) {
        this.SigaUE = SigaUE;
    }

    public String getCodigoMunicipio() {
        return CodigoMunicipio;
    }

    public void setCodigoMunicipio(String CodigoMunicipio) {
        this.CodigoMunicipio = CodigoMunicipio;
    }

    public String getNomeMunicipio() {
        return NomeMunicipio;
    }

    public void setNomeMunicipio(String NomeMunicipio) {
        this.NomeMunicipio = NomeMunicipio;
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
}
