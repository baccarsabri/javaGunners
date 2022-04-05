/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanci;

import java.util.ArrayList;
import java.util.List;
import models.catégorie;
import models.contrat;
import services.ServiceCatégorie;
import services.ServiceContrat;

/**
 *
 * @author 21655
 */
public class Lanci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         ServiceCatégorie cat= new ServiceCatégorie();
         ServiceContrat ca= new ServiceContrat();
         
         catégorie res=new catégorie("yass");

        
         java.util.Date date = new java.util.Date();
         java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
         
         contrat aj=new contrat(1,1,77,sqlDate,"a");
         contrat up=new contrat(4445,1,1,77,sqlDate,"pending");
      
        ca.createContrat(aj);
        ca.updatecontrat(up);
        
        
        
         catégorie upp=new catégorie(4457,"sam");
         cat.updateCatégorie(upp);
         cat.DeleteCatégorie(4462);

      
      //affiche catégorie  
        cat.createCatégorie(res);
        List<catégorie> catégories = new ArrayList();
        catégories = cat.readCatégories(); 
        System.out.println(catégories.toString());
       
        //affiche contrat 
       ca.createContrat(aj);
        List<contrat> contrats = new ArrayList();
        contrats = ca.readcontrats(); 
        System.out.println(contrats.toString()); 
        
        
        
        
    }
    
}
