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
public class PerfilEleitor {
    private String Periodo;
    private String UF;
    private String Municipio;
    private String CodigoMunicipioTSE;
    private String NumZona;
    private String Sexo;
    private String FaixaEtaria;
    private String GrauDeEscolaridade;
    private String QtdNoPerfil;
    
    public PerfilEleitor() {
    }
    
    public PerfilEleitor(String[] entry) {
    	/* if (entry.length != 9) {
    		throw new RuntimeException("Unexpected entry");
    	} */
    	
        this.Periodo = entry[2];
        this.UF = entry[3];
        this.Municipio = entry[5];
        this.CodigoMunicipioTSE = entry[4];
        this.NumZona = entry[6];
        this.Sexo = entry[15];
        this.FaixaEtaria = entry[11];
        this.GrauDeEscolaridade = entry[13];
        this.QtdNoPerfil = entry[16];
    }
    
    public void setAll(String[] entry){
        this.Periodo = entry[0];
        this.UF = entry[1];
        this.Municipio = entry[2];
        this.CodigoMunicipioTSE = entry[3];
        this.NumZona = entry[4];
        this.Sexo = entry[5];
        this.FaixaEtaria = entry[6];
        this.GrauDeEscolaridade = entry[7];
        this.QtdNoPerfil = entry[8];
    }
    
    public String getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(String Periodo) {
        this.Periodo = Periodo;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String Municipio) {
        this.Municipio = Municipio;
    }

    public String getCodigoMunicipioTSE() {
        return CodigoMunicipioTSE;
    }

    public void setCodigoMunicipioTSE(String CodigoMunicipioTSE) {
        this.CodigoMunicipioTSE = CodigoMunicipioTSE;
    }

    public String getNumZona() {
        return NumZona;
    }

    public void setNumZona(String NumZona) {
        this.NumZona = NumZona;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getFaixaEtaria() {
        return FaixaEtaria;
    }

    public void setFaixaEtaria(String FaixaEtaria) {
        this.FaixaEtaria = FaixaEtaria;
    }

    public String getGrauDeEscolaridade() {
        return GrauDeEscolaridade;
    }

    public void setGrauDeEscolaridade(String GrauDeEscolaridade) {
        this.GrauDeEscolaridade = GrauDeEscolaridade;
    }

    public String getQtdNoPerfil() {
        return QtdNoPerfil;
    }

    public void setQtdNoPerfil(String QtdNoPerfil) {
        this.QtdNoPerfil = QtdNoPerfil;
    }
}
