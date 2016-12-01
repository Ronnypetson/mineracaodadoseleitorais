/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analise_dois_turnos.func;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import analise_dois_turnos.negocio.Candidatura;
import analise_dois_turnos.negocio.PerfilEleitor;

/**
 *
 * @author ronnypetsonss
 */
public interface ComparadorAbstratoCandidatoEleitor extends ActionListener {
    
    public void setGraficoCandidato(ArrayList<Candidatura> cands);
    
    public void setGraficoEleitor(ArrayList<PerfilEleitor> eleitores);
    
    public void setCorrelacao(String nomeMunicipio);
    
}
