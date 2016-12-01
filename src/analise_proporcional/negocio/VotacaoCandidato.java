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
public class VotacaoCandidato extends Votacao {
    private String NumeroCandidato;
    private String SeqCandidato;
    private String NomeCandidato;
    private String NomeUrnaCandidato;
    private String CodigoSituacaoCandidatoSuperior;
    private String DescricaoSituacaoCandidatoSuperior;
    private String CodigoSituacaoCandidato;
    private String DescricaoSituacaoCandidato;
    private String CodigoSituacaoCandidatoTotal;
    private String DescricaoSituacaoCandidatoTotal;
    private String NumeroPartido;
    private String SiglaPartido;
    private String SeqLegenda;
    private String NomeColigacao;
    private String ComposicaoLegenda;
    private String TotalVotos;
    private String VotoEmTransito;
    
    public VotacaoCandidato() {
    }
    
    public VotacaoCandidato(String[] entry) {
        super(Arrays.copyOfRange(entry, 0, 9));
        this.NumTurno = entry[3];
        this.SiglaUF = entry[5];
        this.CodigoMunicipio = entry[7];
        this.NomeMunicipio = entry[8];
        this.NumZona = entry[9];
        this.CodigoCargo = entry[10];
        this.NumeroCandidato = entry[11];
        this.SeqCandidato = entry[12];
        this.NomeCandidato = entry[13];
        this.NomeUrnaCandidato = entry[14];
        this.CodigoSituacaoCandidatoSuperior = entry[16];
        this.DescricaoSituacaoCandidatoSuperior = entry[17];
        this.CodigoSituacaoCandidato = entry[18];
        this.DescricaoSituacaoCandidato = entry[19];
        this.CodigoSituacaoCandidatoTotal = entry[20];
        this.DescricaoSituacaoCandidatoTotal = entry[21];
        this.NumeroPartido = entry[22];
        this.SiglaPartido = entry[23];
        this.SeqLegenda = entry[25];
        this.NomeColigacao = entry[26];
        this.ComposicaoLegenda = entry[27];
        this.TotalVotos = entry[28];
        this.VotoEmTransito = entry[29];
    }
    
    @Override
    public void setAll(String[] entry){
        this.NumeroCandidato = entry[0];
        this.NomeCandidato = entry[1];
        this.NomeUrnaCandidato = entry[2];
        this.CodigoSituacaoCandidatoSuperior = entry[3];
        this.DescricaoSituacaoCandidatoSuperior = entry[4];
        this.CodigoSituacaoCandidato = entry[5];
        this.DescricaoSituacaoCandidato = entry[6];
        this.CodigoSituacaoCandidatoTotal = entry[7];
        this.DescricaoSituacaoCandidatoTotal = entry[8];
        this.NumeroPartido = entry[9];
        this.SiglaPartido = entry[10];
        this.SeqLegenda = entry[11];
        this.NomeColigacao = entry[12];
        this.ComposicaoLegenda = entry[13];
        this.TotalVotos = entry[14];
        this.VotoEmTransito = entry[15];
        // ID
        this.CodigoMunicipio = entry[17];
        this.NomeMunicipio = entry[18];
        this.NumZona = entry[19];
        this.CodigoCargo = entry[20];
        this.NumTurno = entry[21];
        this.SiglaUF = entry[22];
        this.SeqCandidato = entry[23];
    }
    
    public String getNumeroCandidato() {
        return NumeroCandidato;
    }

    public void setNumeroCandidato(String NumeroCandidato) {
        this.NumeroCandidato = NumeroCandidato;
    }

    public String getSeqCandidato() {
        return SeqCandidato;
    }

    public void setSeqCandidato(String SeqCandidato) {
        this.SeqCandidato = SeqCandidato;
    }

    public String getNomeCandidato() {
        return NomeCandidato;
    }

    public void setNomeCandidato(String NomeCandidato) {
        this.NomeCandidato = NomeCandidato;
    }

    public String getNomeUrnaCandidato() {
        return NomeUrnaCandidato;
    }

    public void setNomeUrnaCandidato(String NomeUrnaCandidato) {
        this.NomeUrnaCandidato = NomeUrnaCandidato;
    }

    public String getCodigoSituacaoCandidatoSuperior() {
        return CodigoSituacaoCandidatoSuperior;
    }

    public void setCodigoSituacaoCandidatoSuperior(String CodigoSituacaoCandidatoSuperior) {
        this.CodigoSituacaoCandidatoSuperior = CodigoSituacaoCandidatoSuperior;
    }

    public String getDescricaoSituacaoCandidatoSuperior() {
        return DescricaoSituacaoCandidatoSuperior;
    }

    public void setDescricaoSituacaoCandidatoSuperior(String DescricaoSituacaoCandidatoSuperior) {
        this.DescricaoSituacaoCandidatoSuperior = DescricaoSituacaoCandidatoSuperior;
    }

    public String getCodigoSituacaoCandidato() {
        return CodigoSituacaoCandidato;
    }

    public void setCodigoSituacaoCandidato(String CodigoSituacaoCandidato) {
        this.CodigoSituacaoCandidato = CodigoSituacaoCandidato;
    }

    public String getDescricaoSituacaoCandidato() {
        return DescricaoSituacaoCandidato;
    }

    public void setDescricaoSituacaoCandidato(String DescricaoSituacaoCandidato) {
        this.DescricaoSituacaoCandidato = DescricaoSituacaoCandidato;
    }

    public String getCodigoSituacaoCandidatoTotal() {
        return CodigoSituacaoCandidatoTotal;
    }

    public void setCodigoSituacaoCandidatoTotal(String CodigoSituacaoCandidatoTotal) {
        this.CodigoSituacaoCandidatoTotal = CodigoSituacaoCandidatoTotal;
    }

    public String getDescricaoSituacaoCandidatoTotal() {
        return DescricaoSituacaoCandidatoTotal;
    }

    public void setDescricaoSituacaoCandidatoTotal(String DescricaoSituacaoCandidatoTotal) {
        this.DescricaoSituacaoCandidatoTotal = DescricaoSituacaoCandidatoTotal;
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

    public String getSeqLegenda() {
        return SeqLegenda;
    }

    public void setSeqLegenda(String SeqLegenda) {
        this.SeqLegenda = SeqLegenda;
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

    public String getTotalVotos() {
        return TotalVotos;
    }

    public void setTotalVotos(String TotalVotos) {
        this.TotalVotos = TotalVotos;
    }

    public String getVotoEmTransito() {
        return VotoEmTransito;
    }

    public void setVotoEmTransito(String VotoEmTransito) {
        this.VotoEmTransito = VotoEmTransito;
    }
}
