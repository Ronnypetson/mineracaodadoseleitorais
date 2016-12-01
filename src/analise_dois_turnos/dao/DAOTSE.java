/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analise_dois_turnos.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

import analise_dois_turnos.negocio.*;

/**
 *
 * @author ronnypetsonss
 */
public class DAOTSE extends AbstractElectionDAO {

    
    //
    
    public DAOTSE() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance(); // Client
        password = "123";
        dbURL = "jdbc:derby://localhost:1527/db_test1";
        userName = "ronny";
    }

    /* @Override
     public void connect() throws SQLException {
     dbConnection
     = DriverManager.getConnection(dbURL, userName, password);
     } */
    /* @Override
     public void disconnect() throws SQLException {
     // stmt.close();
     dbConnection.close();
     } */
    // Inserts
    public void insertAllBemDeCandidato() throws SQLException, IOException {
        BemDeCandidatoFileTableReader ftr = new BemDeCandidatoFileTableReader();
        try {
            ftr.getAll();
            stmt = dbConnection.createStatement();
            int i = getCount("BemDeCandidato");
            for (Object ob : ftr.getRows()) {
                BemDeCandidato bc = (BemDeCandidato) ob;
                query = String.format("insert into BemDeCandidato values ('%s',"
                        + " '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d)",
                        bc.getAnoEleicao(), bc.getDescricaoEleicao(),
                        bc.getSiglaUF(), bc.getSeqCandidato(),
                        bc.getCodigoTipoDeBem(), bc.getDescricaoTipoDeBem(),
                        bc.getDetalheBem(), bc.getValorBem(), i++);
                stmt.execute(query);
                // stmt.close();
            }
            stmt.close();
        } catch (IOException e) {
        }
    }
    
    public void insertAllCandidatura() throws SQLException, IOException {
        CandidaturaFileTableReader ftr = new CandidaturaFileTableReader();
        try {
            ftr.getAll();
            stmt = dbConnection.createStatement();
            int i = getCount("Candidatura");
            for (Object ob : ftr.getRows()) {
                Candidatura cand = (Candidatura) ob;
                query = String.format("insert into Candidatura values ('%s',"
                        + "'%s','%s','%s','%s','%s','%s','%s','%s','%s','%s',"
                        + "'%s','%s','%s','%s','%s','%s','%s','%s','%s','%s',"
                        + "'%s','%s','%s','%s','%s','%s',%d,'%s')",
                        cand.getNomeCandidato(), cand.getSeqCandidato(),
                        cand.getNumeroCandidato(), cand.getCPFCandidato(),
                        cand.getNomeUrnaCandidato(), cand.getNumeroPartido(),
                        cand.getSiglaPartido(), cand.getNomePartido(), cand.getCodigoLegenda(),
                        cand.getSiglaLegenda(), cand.getComposicaoLegenda(),
                        cand.getNomeLegenda(), cand.getDescricaoOcupacao(),
                        cand.getDataNascimento(), cand.getNumTituloEleitoral(),
                        cand.getIdadeNaEleicao(), cand.getDescricaoSexo(),
                        cand.getDescricaoGrauInstrucao(), cand.getDescricaoEstadoCivil(),
                        cand.getDescricaoCorRaca(), cand.getCodigoNacionalidade(),
                        cand.getSiglaUFNascimento(), cand.getCodigoMunicipioNascimento(),
                        cand.getNomeMunicipioNascimento(), cand.getDespesaMaximaCampanha(),
                        cand.getCodigoTotalizacaoTurno(), cand.getEmailCandidato(), i++,
                        cand.getDescricaoCargo());
                stmt.execute(query);
                //stmt.close();
            }
            stmt.close();
        } catch (IOException e) {
        }
    }
    
    public void insertAllLegenda() throws SQLException, IOException {
        FileTableReader ftr = new LegendaFileTableReader();
        try {
            ftr.getAll();
            stmt = dbConnection.createStatement();
            int i = getCount("Legenda");
            for (Object ob : ftr.getRows()) {
                Legenda leg = (Legenda) ob;
                query = String.format("insert into Legenda values ('%s',"
                        + " '%s', '%s', '%s', '%s', '%s', '%s', %d)",
                        leg.getTipoLegenda(), leg.getNumeroPartido(),
                        leg.getSiglaPartido(), leg.getNomePartido(),
                        leg.getSiglaColigacao(), leg.getComposicaoColigacao(),
                        leg.getSeqColigacao(), i++);
                stmt.execute(query);
                // stmt.close();
            }
            stmt.close();
        } catch (IOException e) {
        }
    }

    public void insertAllPerfilEleitor() throws SQLException, IOException {
        FileTableReader ftr = new PerfilEleitorFileTableReader();
        try {
            ftr.getAll();
            stmt = dbConnection.createStatement();
            int i = getCount("PerfilEleitor");
            for (Object ob : ftr.getRows()) {
                PerfilEleitor pel = (PerfilEleitor) ob;
                query = String.format("insert into PerfilEleitor values ('%s',"
                        + " '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d)",
                        pel.getPeriodo(), pel.getUF(), pel.getMunicipio(),
                        pel.getCodigoMunicipioTSE(), pel.getNumZona(), pel.getSexo(),
                        pel.getFaixaEtaria(), pel.getGrauDeEscolaridade(),
                        pel.getQtdNoPerfil(), i++);
                stmt.execute(query);
                // stmt.close();
            }
            stmt.close();
        } catch (IOException e) {
        }
    }
    
    public void insertAllVotacaoCandidato() throws SQLException, IOException {
        FileTableReader ftr = new VotacaoCandidatoFileTableReader();
        try {
            ftr.getAll();
            stmt = dbConnection.createStatement();
            int i = getCount("VotacaoCandidato");
            for (Object ob : ftr.getRows()) {
                VotacaoCandidato vc = (VotacaoCandidato) ob;
                query = String.format("insert into VotacaoCandidato values ('%s',"
                        + " '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s',"
                        + " '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s',"
                        + " %d, '%s', '%s', '%s', '%s', '%s', '%s')",
                        vc.getNumeroCandidato(), vc.getSeqCandidato(),
                        vc.getNomeCandidato(), vc.getNomeUrnaCandidato(),
                        vc.getCodigoSituacaoCandidatoSuperior(),
                        vc.getDescricaoSituacaoCandidatoSuperior(),
                        vc.getCodigoSituacaoCandidato(),
                        vc.getDescricaoSituacaoCandidato(),
                        vc.getCodigoSituacaoCandidatoTotal(),
                        vc.getDescricaoSituacaoCandidatoTotal(),
                        vc.getNumeroPartido(), vc.getSiglaPartido(),
                        vc.getSeqLegenda(), vc.getNomeColigacao(),
                        vc.getComposicaoLegenda(), vc.getTotalVotos(),
                        vc.getVotoEmTransito(), i++, vc.getCodigoMunicipio(),
                        vc.getNomeMunicipio(), vc.getNumZona(), vc.getCodigoCargo(),
                        vc.getNumTurno(), vc.getSiglaUF());
                stmt.execute(query);
                // stmt.close();
            }
            stmt.close();
        } catch (IOException e) {
        }
    }

    public void insertAllVotacaoPartido() throws SQLException, IOException {
        FileTableReader ftr = new VotacaoPartidoFileTableReader();
        try {
            ftr.getAll();
            stmt = dbConnection.createStatement();
            int i = 0;
            for (Object ob : ftr.getRows()) {
                VotacaoPartido vp = (VotacaoPartido) ob;
                query = String.format("insert into VotacaoPartido values ('%s',"
                        + " '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d)",
                        vp.getTipoLegenda(), vp.getNomeColigacao(),
                        vp.getComposicaoLegenda(), vp.getSiglaPartido(),
                        vp.getNumeroPartido(), vp.getNomePartido(),
                        vp.getQtdVotosNominais(), vp.getQtdVotosLegenda(),
                        vp.getVotoEmTransito(), i++);
                stmt.execute(query);
                // stmt.close();
            }
            stmt.close();
        } catch (IOException e) {
        }
    }

    public void insertAllVotacaoSecao() throws SQLException, IOException {
        FileTableReader ftr = new VotacaoSecaoFileTableReader();
        try {
            ftr.getAll();
            stmt = dbConnection.createStatement();
            int i = 0;
            for (Object ob : ftr.getRows()) {
                VotacaoSecao vs = (VotacaoSecao) ob;
                query = String.format("insert into VotacaoSecao values ('%s',"
                        + " '%s', '%s', '%s', %d)",
                        vs.getNumZona(), vs.getNumSecao(),
                        vs.getNumeroDoVotavel(), vs.getQtdVotos(), i++);
                stmt.execute(query);
                // stmt.close();
            }
            stmt.close();
        } catch (IOException e) {
        }
    }
    
    // Query
    public ArrayList<PerfilEleitor> getPerfisEleitores(String regiao) throws SQLException {
        regiao = regiao.toUpperCase();
        String condition;
        if(this.UF.contains(regiao)){
            condition = " CAST( UF AS VARCHAR(128) ) = " + "'\"" + regiao + "\"'";
        } else {
            condition = " CAST( Municipio AS VARCHAR(128) ) = " + "'\"" + regiao + "\"'";
        }
        query = String.format("select * from PerfilEleitor"
                        + " where " + condition);
        Statement select = dbConnection.createStatement();
        ResultSet results = select.executeQuery(query);
        //
        ArrayList<PerfilEleitor> perfis = new ArrayList<PerfilEleitor>();
        int columnCount = results.getMetaData().getColumnCount();
        while (results.next()) {
            PerfilEleitor perf = new PerfilEleitor();
            String entry[] = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                entry[i] = results.getString(i + 1);
            }
            perf.setAll(entry);
            perfis.add(perf);
        }
        // perfis = this.ordenaPerfisDeEleitorPorDominancia(perfis);
        /* perfis.sort(new Comparator<PerfilEleitor>() {
            @Override
            public int compare(PerfilEleitor o1, PerfilEleitor o2) {
                int a = Integer.parseInt(o1.getQtdNoPerfil().replaceAll("[\\D]", ""));
                int b = Integer.parseInt(o2.getQtdNoPerfil().replaceAll("[\\D]", ""));
                return Integer.compare(b, a);
            }
        }); */

        return this.ordenaPerfisDeEleitorPorDominancia(perfis);
    }

    public ArrayList<PerfilEleitor> getPerfisEleitoresMunicipio(String municipio) throws SQLException {
        municipio = municipio.toUpperCase();
        /* String condition;
        if(this.UF.contains(municipio)){
            condition = 
        } */
        query = String.format("select * from PerfilEleitor"
                        + " where CAST( Municipio AS VARCHAR(128) ) = '\"%s\"' ", municipio);
        Statement select = dbConnection.createStatement();
        ResultSet results = select.executeQuery(query);
        //
        ArrayList<PerfilEleitor> perfis = new ArrayList<PerfilEleitor>();
        int columnCount = results.getMetaData().getColumnCount();
        while (results.next()) {
            PerfilEleitor perf = new PerfilEleitor();
            String entry[] = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                entry[i] = results.getString(i + 1);
            }
            perf.setAll(entry);
            perfis.add(perf);
        }
        perfis.sort(new Comparator<PerfilEleitor>() {
            @Override
            public int compare(PerfilEleitor o1, PerfilEleitor o2) {
                int a = Integer.parseInt(o1.getQtdNoPerfil().replaceAll("[\\D]", ""));
                int b = Integer.parseInt(o2.getQtdNoPerfil().replaceAll("[\\D]", ""));
                return Integer.compare(b, a);
            }
        });

        return perfis;
    }

    public ArrayList<PerfilEleitor> getPerfisEleitoresZona(String zona) throws SQLException {
        query = String.format("select * from PerfilEleitor"
                        + " where CAST( NumZona AS VARCHAR(128) ) = '\"%s\"' ", zona);
        Statement stmt = dbConnection.createStatement();
        ResultSet results = stmt.executeQuery(query);
        //
        ArrayList<PerfilEleitor> perfis = new ArrayList<PerfilEleitor>();
        int columnCount = results.getMetaData().getColumnCount();
        while (results.next()) {
            PerfilEleitor perf = new PerfilEleitor();
            String entry[] = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                entry[i] = results.getString(i + 1);
            }
            perf.setAll(entry);
            perfis.add(perf);
        }
        return perfis;
    }
    
    public ArrayList<Candidatura> getPerfisCandidaturas(String regiao, String cargo, final boolean ordByGastos) throws SQLException {
        regiao = regiao.toUpperCase();
        cargo = cargo.toUpperCase();
        //
        String localidade;
        if(this.UF.contains(regiao)){
            localidade = " AND CAST( VotacaoCandidato.SiglaUF AS VARCHAR(128) ) = "
                    + "'\"" + regiao + "\"'";
        } else {
            localidade
                = " AND CAST( VotacaoCandidato.NomeMunicipio AS VARCHAR(128) ) = "
                    + "'\"" + regiao + "\"'";
        }
        //
        query =   " SELECT * FROM Candidatura"
                + " INNER JOIN VotacaoCandidato"
                + " ON "
                // + " CAST( Candidatura.SeqCandidato AS VARCHAR(128) ) = "
                // + " CAST( VotacaoCandidato.SeqCandidato AS VARCHAR(128) ) "
                + " Candidatura.SeqCandidato = VotacaoCandidato.SeqCandidato"
                + " WHERE "
                + " CAST( CANDIDATURA.DESCRICAOCARGO AS VARCHAR(128) ) = "
                + " '\"" + cargo + "\"'"
                + localidade;
        //
        Statement select = dbConnection.createStatement();
        ResultSet results = select.executeQuery(query);
        //
        ArrayList<String[]> entries = new ArrayList<String[]>();
        int columnCount = results.getMetaData().getColumnCount();
        while (results.next()) {
            String entry[] = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                entry[i] = results.getString(i + 1);
            }
            entries.add(entry);
        }
        //
        // Calcular a dominancia dos candidatos
        // Calcular os gastos de campanha
        //
        /* TreeMap<String, Candidatura> dominancias = new TreeMap<String, Candidatura>();
        ArrayList<Candidatura> perfis = new ArrayList<Candidatura>();
        // TreeSet<String> hperfis = new TreeSet<String>();
        for (String[] entry : entries) {
            Candidatura cand = new Candidatura();
            cand.setAll(entry);
            // perfis.add(cand);
            String seq = cand.getSeqCandidato();
            int votes = Integer.parseInt(entry[44].replaceAll("[\\D]", ""));
            if(dominancias.containsKey(seq)){
                int total = dominancias.get(seq).getTotalVotos();
                dominancias.get(seq).setTotalVotos(total + votes);
            } else {
                dominancias.put(seq, cand);
            }
        }
        //
        for(Candidatura c: dominancias.values()){
            perfis.add(c);
        }
        //
        perfis.sort(new Comparator<Candidatura>(){
            @Override
            public int compare(Candidatura o1, Candidatura o2) {
                if(ordByGastos){
                    int a = Integer.parseInt(o1.getDespesaMaximaCampanha().replaceAll("[\\D]", ""));
                    int b = Integer.parseInt(o2.getDespesaMaximaCampanha().replaceAll("[\\D]", ""));
                    return Integer.compare(b, a);
                } else {
                    return Integer.compare(o2.getTotalVotos(), o1.getTotalVotos());
                }
            }
        }); */
        //
        if(ordByGastos){
            return this.ordenaCandidaturasPorGastos(entries);
        } else {
            return this.ordenaCandidaturasPorDominancia(entries);
        }
    }
    
    public ArrayList<VotacaoCandidato> getPerfisVotacao(String regiao, String cargo) throws SQLException {
        regiao = regiao.toUpperCase();
        cargo = cargo.toUpperCase();
        //
        String localidade;
        if(this.UF.contains(regiao)){
            localidade = " AND CAST( VotacaoCandidato.SiglaUF AS VARCHAR(128) ) = "
                    + "'\"" + regiao + "\"'";
        } else {
            localidade
                = " AND CAST( VotacaoCandidato.NomeMunicipio AS VARCHAR(128) ) = "
                    + "'\"" + regiao + "\"'";
        }
        //
        query =   " SELECT * FROM VotacaoCandidato"
                + " INNER JOIN Candidatura"
                + " ON "
                // + " CAST( Candidatura.SeqCandidato AS VARCHAR(128) ) = "
                // + " CAST( VotacaoCandidato.SeqCandidato AS VARCHAR(128) ) "
                + " Candidatura.SeqCandidato = VotacaoCandidato.SeqCandidato"
                + " WHERE "
                + " CAST( CANDIDATURA.DESCRICAOCARGO AS VARCHAR(128) ) = "
                + " '\"" + cargo + "\"'"
                + localidade;
        //
        Statement select = dbConnection.createStatement();
        ResultSet results = select.executeQuery(query);
        //
        ArrayList<String[]> entries = new ArrayList<String[]>();
        int columnCount = results.getMetaData().getColumnCount();
        while (results.next()) {
            String entry[] = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                entry[i] = results.getString(i + 1);
            }
            entries.add(entry);
        }
        //
        // Calcular a dominancia dos candidatos
        // Calcular os gastos de campanha
        //
        // TreeMap<String, Candidatura> dominancias = new TreeMap<String, Candidatura>();
        ArrayList<VotacaoCandidato> perfis = new ArrayList<VotacaoCandidato>();
        // TreeSet<String> hperfis = new TreeSet<String>();
        for (String[] entry : entries) {
            VotacaoCandidato cand = new VotacaoCandidato();
            cand.setAll(entry);
            perfis.add(cand);
            String seq = cand.getSeqCandidato();
            // int votes = Integer.parseInt(entry[44].replaceAll("[\\D]", ""));
            /* if(dominancias.containsKey(seq)){
                int total = dominancias.get(seq).getTotalVotos();
                dominancias.get(seq).setTotalVotos(total + votes);
            } else {
                dominancias.put(seq, cand);
            } */
        }
        //
        /* for(Candidatura c: dominancias.values()){
            perfis.add(c);
        } */
        //
        perfis.sort(new Comparator<VotacaoCandidato>(){
            @Override
            public int compare(VotacaoCandidato o1, VotacaoCandidato o2) {
                int a = Integer.parseInt(o1.getNumZona().replaceAll("[\\D]", ""));
                int b = Integer.parseInt(o2.getNumZona().replaceAll("[\\D]", ""));

                int c = Integer.parseInt(o1.getTotalVotos().replaceAll("[\\D]", ""));
                int d = Integer.parseInt(o2.getTotalVotos().replaceAll("[\\D]", ""));

                if (a == b) {
                    return Integer.compare(d, c);
                } else {
                    return Integer.compare(a, b);
                }
            }
        });
        //
        return perfis;
    }
    
    public ArrayList<Candidatura> getPerfisCandidaturasMunicipio(String municipio) throws SQLException {
        municipio = municipio.toUpperCase();
        query = String.format("SELECT * FROM Candidatura"
                + " INNER JOIN VotacaoCandidato"
                + " ON "
                + " CAST( Candidatura.SeqCandidato AS VARCHAR(128) ) = "
                + " CAST( VotacaoCandidato.SeqCandidato AS VARCHAR(128) ) "
                + " WHERE CAST( VotacaoCandidato.NomeMunicipio AS VARCHAR(128) ) = '\"%s\"' ", municipio);
        Statement stmt = dbConnection.createStatement();
        ResultSet results = stmt.executeQuery(query);
        //
        ArrayList<String[]> entries = new ArrayList<String[]>();
        int columnCount = results.getMetaData().getColumnCount();
        while (results.next()) {
            String entry[] = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                entry[i] = results.getString(i + 1);
            }
            entries.add(entry);
        }
        entries.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] arg0, String[] arg1) {
                int a = Integer.parseInt(arg0[43].replaceAll("[\\D]", ""));
                int b = Integer.parseInt(arg1[43].replaceAll("[\\D]", ""));
                return Integer.compare(b, a);
            }
        });

        ArrayList<Candidatura> perfis = new ArrayList<Candidatura>();
        for (String[] entry : entries) {
            Candidatura cand = new Candidatura();
            cand.setAll(entry);
            perfis.add(cand);
        }

        return perfis;
    }

    public ArrayList<VotacaoCandidato> getVotacaoCandidatos(String municipio) throws SQLException {
        municipio = municipio.toUpperCase();
        query = String.format("SELECT * FROM VotacaoCandidato "
                + " WHERE CAST( VotacaoCandidato.NomeMunicipio AS VARCHAR(128) ) = '\"%s\"' "
                , municipio);
        Statement select = dbConnection.createStatement();
        ResultSet results = select.executeQuery(query);
        //
        ArrayList<String[]> entries = new ArrayList<String[]>();
        int columnCount = results.getMetaData().getColumnCount();
        while (results.next()) {
            String entry[] = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                entry[i] = results.getString(i + 1);
            }
            entries.add(entry);
        }
        entries.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] arg0, String[] arg1) {
                int a = Integer.parseInt(arg0[20].replaceAll("[\\D]", ""));
                int b = Integer.parseInt(arg1[20].replaceAll("[\\D]", ""));

                int c = Integer.parseInt(arg0[15].replaceAll("[\\D]", ""));
                int d = Integer.parseInt(arg1[15].replaceAll("[\\D]", ""));

                if (a == b) {
                    return Integer.compare(d, c);
                } else {
                    return Integer.compare(a, b);
                }
            }
        });

        ArrayList<VotacaoCandidato> perfis = new ArrayList<VotacaoCandidato>();
        for (String[] entry : entries) {
            VotacaoCandidato cand = new VotacaoCandidato();
            cand.setAll(entry);
            perfis.add(cand);
        }

        return perfis;
    }

    public ArrayList<Candidatura> getPerfisCandidaturasSecao(String secao) throws SQLException {
        secao = secao.toUpperCase();
        query = String.format("SELECT * FROM Candidatura"
                + " INNER JOIN VotacaoSecao"
                + " ON "
                + " CAST( Candidatura.NumeroCandidato AS VARCHAR(128) ) = "
                + " CAST( VotacaoSecao.NumeroDoVotavel AS VARCHAR(128) ) "
                + " WHERE CAST( VotacaoSecao.NumSecao AS VARCHAR(128) ) = '\"%s\"' ", secao);
        Statement stmt = dbConnection.createStatement();
        ResultSet results = stmt.executeQuery(query);
        //
        ArrayList<Candidatura> perfis = new ArrayList<Candidatura>();
        int columnCount = results.getMetaData().getColumnCount();
        while (results.next()) {
            Candidatura perf = new Candidatura();
            String entry[] = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                entry[i] = results.getString(i + 1);
            }
            perf.setAll(entry);
            perfis.add(perf);
        }
        return perfis;
    }
    
    //
    @Override
    public ArrayList<Candidatura> ordenaCandidaturasPorDominancia(ArrayList<String[]> entries){
        TreeMap<String, Candidatura> dominancias = new TreeMap<String, Candidatura>();
        ArrayList<Candidatura> perfis = new ArrayList<Candidatura>();
        // TreeSet<String> hperfis = new TreeSet<String>();
        for (String[] entry : entries) {
            Candidatura cand = new Candidatura();
            cand.setAll(entry);
            // perfis.add(cand);
            String seq = cand.getSeqCandidato();
            int votes = Integer.parseInt(entry[43].replaceAll("[\\D]", ""));
            if(dominancias.containsKey(seq)){
                int total = dominancias.get(seq).getTotalVotos();
                dominancias.get(seq).setTotalVotos(total + votes);
            } else {
                dominancias.put(seq, cand);
            }
        }
        //
        for(Candidatura c: dominancias.values()){
            perfis.add(c);
        }
        //
        perfis.sort(new Comparator<Candidatura>(){
            @Override
            public int compare(Candidatura o1, Candidatura o2) {
                return Integer.compare(o2.getTotalVotos(), o1.getTotalVotos());
            }
        });
        return perfis;
    }
    //
    
    //
    @Override
    public ArrayList<Candidatura> ordenaCandidaturasPorGastos(ArrayList<String[]> entries){
        TreeMap<String, Candidatura> dominancias = new TreeMap<String, Candidatura>();
        ArrayList<Candidatura> perfis = new ArrayList<Candidatura>();
        // TreeSet<String> hperfis = new TreeSet<String>();
        for (String[] entry : entries) {
            Candidatura cand = new Candidatura();
            cand.setAll(entry);
            // perfis.add(cand);
            String seq = cand.getSeqCandidato();
            int votes = Integer.parseInt(entry[43].replaceAll("[\\D]", ""));
            if(dominancias.containsKey(seq)){
                int total = dominancias.get(seq).getTotalVotos();
                dominancias.get(seq).setTotalVotos(total + votes);
            } else {
                dominancias.put(seq, cand);
            }
        }
        //
        for(Candidatura c: dominancias.values()){
            perfis.add(c);
        }
        //
        perfis.sort(new Comparator<Candidatura>(){
            @Override
            public int compare(Candidatura o1, Candidatura o2) {
                int a = Integer.parseInt(o1.getDespesaMaximaCampanha().replaceAll("[\\D]", ""));
                int b = Integer.parseInt(o2.getDespesaMaximaCampanha().replaceAll("[\\D]", ""));
                return Integer.compare(b, a);
            }
        });
        return perfis;
    }
    //
    
    public ResultSet get(String tableName) throws SQLException { // throws SQLException
        query = "select * from " + tableName;
        Statement stmt = dbConnection.createStatement();
        ResultSet results = stmt.executeQuery(query);
        //stmt.close();
        return results;
    }

    // Delete
    public void clearTable(String tableName) throws SQLException {
        String query = "delete from " + tableName + " where true";
        Statement stmt = dbConnection.createStatement();
        stmt.execute(query);
        stmt.close();
    }

    // Print query result
    public int getCount(String tableName) throws SQLException{
        String query = "select count(*) from " + tableName;
        Statement stmt = dbConnection.createStatement();
        ResultSet results = stmt.executeQuery(query);
        if(results.next())
            return results.getInt(1);
        else
            return 0;
    }
    
    public void printGet(String tableName) throws SQLException {
        ResultSet results;
        results = get(tableName);
        int columnCount = results.getMetaData().getColumnCount();
        while (results.next()) { // results.toString()
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(" | " + results.getString(i));
            }
            System.out.println();
        }
    }

    public void printGet(ResultSet results) throws SQLException {
        int columnCount = results.getMetaData().getColumnCount();
        while (results.next()) { // results.toString()
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(" | " + results.getString(i));
            }
            System.out.println();
        }
    }
}
