/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancitounsii;

import java.util.ArrayList;
import java.util.List;
import models.Competence;
import models.Msg;
import services.ServiceCompetence;
import services.ServiceMsg;

/**
 *
 * @author Oussama Fdhila
 */
public class LanciTounsii {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//COMPETENCE 
    ServiceCompetence comp = new ServiceCompetence() ;
    Competence c = new Competence("javascript");
   //Competence c2 = new Competence( 3, "chehine");

    
//comp.createCompetence(c);
//comp.updateCompetence(c2);
//comp.deleteCompetence(3);
 /*List<Competence> competences = new ArrayList();
        competences = comp.readCompetence(); 
        System.out.println(competences.toString());
        */
        List<Competence> competences ;
        //competences = comp.SearchByName("javascript");
        competences = comp.TriParName();
        System.out.println(competences.toString());
        
        
        
        
        
        //MESSAGE
        /* ServiceMsg m = new ServiceMsg() ;
         Msg m1        = new Msg("chehine zouari 3A49");
         
         
         m.createMsg(m1);
//m.updateMsg(m1);
//m.deleteCompetence(3);
 List<Msg> msgs = new ArrayList();
        msgs = m.readMsg(); 
        System.out.println(msgs.toString());
         */
         
         
                
    }
    
}
