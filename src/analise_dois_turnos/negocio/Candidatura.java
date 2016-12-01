/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analise_dois_turnos.negocio;

import java.util.Arrays;

/**
 *
 * @author ronnypetsonss
 */
public class Candidatura extends Votavel {
    private String NomeCandidato;
    private String SeqCandidato;
    private String NumeroCandidato;
    private String CPFCandidato;
    private String NomeUrnaCandidato;
    private String CodigoLegenda;
    private String SiglaLegenda;
    private String ComposicaoLegenda;
    private String NomeLegenda;
    private String DescricaoOcupacao;
    private String DataNascimento;
    private String NumTituloEleitoral;
    private String IdadeNaEleicao;
    private String DescricaoSexo;
    private String DescricaoGrauInstrucao;
    private String DescricaoEstadoCivil;
    private String DescricaoCorRaca;
    private String CodigoNacionalidade;
    private String SiglaUFNascimento;
    private String CodigoMunicipioNascimento;
    private String NomeMunicipioNascimento;
    private String DespesaMaximaCampanha;
    private String CodigoTotalizacaoTurno;
    private String EmailCandidato;
    private int totalVotos;

    public Candidatura() {
        this.totalVotos = 0;
    }
    
    public Candidatura(String[] entry) {
        // Carregado do arquivo de texto
        super(Arrays.copyOfRange(entry, 27, 34));
        this.DescricaoCargo = entry[9];
        this.NomeCandidato = entry[10];
        this.SeqCandidato = entry[11];
        this.NumeroCandidato = entry[12];
        this.CPFCandidato = entry[13];
        this.NomeUrnaCandidato = entry[14];
        this.NumeroPartido = entry[17];
        this.SiglaPartido = entry[18];
        this.NomePartido = entry[19];
        this.CodigoLegenda = entry[20];
        this.SiglaLegenda = entry[21];
        this.ComposicaoLegenda = entry[22];
        this.NomeLegenda = entry[23];
        this.DescricaoOcupacao = entry[25];
        this.DataNascimento = entry[26];
        this.NumTituloEleitoral = entry[27];
        this.IdadeNaEleicao = entry[28];
        this.DescricaoSexo = entry[30];
        this.DescricaoGrauInstrucao = entry[32];
        this.DescricaoEstadoCivil = entry[34];
        this.DescricaoCorRaca = entry[36];
        this.CodigoNacionalidade = entry[37];
        this.SiglaUFNascimento = entry[39];
        this.CodigoMunicipioNascimento = entry[40];
        this.NomeMunicipioNascimento = entry[41];
        this.DespesaMaximaCampanha = entry[42];
        this.CodigoTotalizacaoTurno = entry[43];
        this.EmailCandidato = entry[45];
        // ID
        //
        this.totalVotos = 0;
    }
    
    @Override
    public void setAll(String[] entry){
        // Carregado do banco
        this.NomeCandidato = entry[0];
        this.NumeroCandidato = entry[1];
        this.CPFCandidato = entry[2];
        this.NomeUrnaCandidato = entry[3];
        this.NumeroPartido = entry[4];
        this.SiglaPartido = entry[5];
        this.NomePartido = entry[6];
        this.CodigoLegenda = entry[7];
        this.SiglaLegenda = entry[8];
        this.ComposicaoLegenda = entry[9];
        this.NomeLegenda = entry[10];
        this.DescricaoOcupacao = entry[11];
        this.DataNascimento = entry[12];
        this.NumTituloEleitoral = entry[13];
        this.IdadeNaEleicao = entry[14];
        this.DescricaoSexo = entry[15];
        this.DescricaoGrauInstrucao = entry[16];
        this.DescricaoEstadoCivil = entry[17];
        this.DescricaoCorRaca = entry[18];
        this.CodigoNacionalidade = entry[19];
        this.SiglaUFNascimento = entry[20];
        this.CodigoMunicipioNascimento = entry[21];
        this.NomeMunicipioNascimento = entry[22];
        this.DespesaMaximaCampanha = entry[23];
        this.CodigoTotalizacaoTurno = entry[24];
        this.EmailCandidato = entry[25];
        // ID (27 + 1)
        this.DescricaoCargo = entry[27];
        this.SeqCandidato = entry[28];
    }
    
    public String getNomeCandidato() {
        return NomeCandidato;
    }

    public void setNomeCandidato(String NomeCandidato) {
        this.NomeCandidato = NomeCandidato;
    }

    public String getSeqCandidato() {
        return SeqCandidato;
    }

    public void setSeqCandidato(String SeqCandidato) {
        this.SeqCandidato = SeqCandidato;
    }

    public String getNumeroCandidato() {
        return NumeroCandidato;
    }

    public void setNumeroCandidato(String NumeroCandidato) {
        this.NumeroCandidato = NumeroCandidato;
    }

    public String getCPFCandidato() {
        return CPFCandidato;
    }

    public void setCPFCandidato(String CPFCandidato) {
        this.CPFCandidato = CPFCandidato;
    }

    public String getNomeUrnaCandidato() {
        return NomeUrnaCandidato;
    }

    public void setNomeUrnaCandidato(String NomeUrnaCandidato) {
        this.NomeUrnaCandidato = NomeUrnaCandidato;
    }

    public String getCodigoLegenda() {
        return CodigoLegenda;
    }

    public void setCodigoLegenda(String CodigoLegenda) {
        this.CodigoLegenda = CodigoLegenda;
    }

    public String getSiglaLegenda() {
        return SiglaLegenda;
    }

    public void setSiglaLegenda(String SiglaLegenda) {
        this.SiglaLegenda = SiglaLegenda;
    }

    public String getComposicaoLegenda() {
        return ComposicaoLegenda;
    }

    public void setComposicaoLegenda(String ComposicaoLegenda) {
        this.ComposicaoLegenda = ComposicaoLegenda;
    }

    public String getNomeLegenda() {
        return NomeLegenda;
    }

    public void setNomeLegenda(String NomeLegenda) {
        this.NomeLegenda = NomeLegenda;
    }

    public String getDescricaoOcupacao() {
        return DescricaoOcupacao;
    }

    public void setDescricaoOcupacao(String DescricaoOcupacao) {
        this.DescricaoOcupacao = DescricaoOcupacao;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public String getNumTituloEleitoral() {
        return NumTituloEleitoral;
    }

    public void setNumTituloEleitoral(String NumTituloEleitoral) {
        this.NumTituloEleitoral = NumTituloEleitoral;
    }

    public String getIdadeNaEleicao() {
        return IdadeNaEleicao;
    }

    public void setIdadeNaEleicao(String IdadeNaEleicao) {
        this.IdadeNaEleicao = IdadeNaEleicao;
    }

    public String getDescricaoSexo() {
        return DescricaoSexo;
    }

    public void setDescricaoSexo(String DescricaoSexo) {
        this.DescricaoSexo = DescricaoSexo;
    }

    public String getDescricaoGrauInstrucao() {
        return DescricaoGrauInstrucao;
    }

    public void setDescricaoGrauInstrucao(String DescricaoGrauInstrucao) {
        this.DescricaoGrauInstrucao = DescricaoGrauInstrucao;
    }

    public String getDescricaoEstadoCivil() {
        return DescricaoEstadoCivil;
    }

    public void setDescricaoEstadoCivil(String DescricaoEstadoCivil) {
        this.DescricaoEstadoCivil = DescricaoEstadoCivil;
    }

    public String getDescricaoCorRaca() {
        return DescricaoCorRaca;
    }

    public void setDescricaoCorRaca(String DescricaoCorRaca) {
        this.DescricaoCorRaca = DescricaoCorRaca;
    }

    public String getCodigoNacionalidade() {
        return CodigoNacionalidade;
    }

    public void setCodigoNacionalidade(String CodigoNacionalidade) {
        this.CodigoNacionalidade = CodigoNacionalidade;
    }

    public String getSiglaUFNascimento() {
        return SiglaUFNascimento;
    }

    public void setSiglaUFNascimento(String SiglaUFNascimento) {
        this.SiglaUFNascimento = SiglaUFNascimento;
    }

    public String getCodigoMunicipioNascimento() {
        return CodigoMunicipioNascimento;
    }

    public void setCodigoMunicipioNascimento(String CodigoMunicipioNascimento) {
        this.CodigoMunicipioNascimento = CodigoMunicipioNascimento;
    }

    public String getNomeMunicipioNascimento() {
        return NomeMunicipioNascimento;
    }

    public void setNomeMunicipioNascimento(String NomeMunicipioNascimento) {
        this.NomeMunicipioNascimento = NomeMunicipioNascimento;
    }

    public String getDespesaMaximaCampanha() {
        return DespesaMaximaCampanha;
    }

    public void setDespesaMaximaCampanha(String DespesaMaximaCampanha) {
        this.DespesaMaximaCampanha = DespesaMaximaCampanha;
    }

    public String getCodigoTotalizacaoTurno() {
        return CodigoTotalizacaoTurno;
    }

    public void setCodigoTotalizacaoTurno(String CodigoTotalizacaoTurno) {
        this.CodigoTotalizacaoTurno = CodigoTotalizacaoTurno;
    }

    public String getEmailCandidato() {
        return EmailCandidato;
    }

    public void setEmailCandidato(String EmailCandidato) {
        this.EmailCandidato = EmailCandidato;
    }
    
    public int getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(int totalVotos) {
        this.totalVotos = totalVotos;
    }
}
