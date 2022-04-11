/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancitounsii;

import java.util.ArrayList;
import java.util.List;
import models.Competence;
import services.ServiceCompetence;

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

        ServiceCompetence RecSer=new ServiceCompetence() {};
    Competence c = new Competence( "pedriiiii");
    
RecSer.createCompetence(c);

 List<Competence> competences = new ArrayList();
        competences = RecSer.readCompetence(); 
        System.out.println(competences.toString());
                
    }
    
}
