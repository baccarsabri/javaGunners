/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancitounsii;

import java.util.ArrayList;
import java.util.List;
import models.Reclamation;
import services.ServiceReclamation;


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

        ServiceReclamation Rec=new ServiceReclamation();
        java.util.Date date = new java.util.Date();
java.sql.Date myDate = new java.sql.Date(date.getTime());
    Reclamation r = new Reclamation("benzemaa", myDate, "pending");   
    Reclamation r2 = new Reclamation(5,6, "cristianooo", myDate, "pending");    

//Rec.createReclamation(r);
//Rec.updateReclamation(r2);
Rec.deleteReclamation(21);
 List<Reclamation> reclamations;
        reclamations = Rec.readReclamation(); 
        System.out.println(reclamations.toString()); 
/*ServiceFichier Fich=new ServiceFichier();
         Fichier f=new Fichier(5,"a");   
         Fichier f2=new Fichier(3,5,"suiiiii");    

Fich.createFichier(f);
//Fich.updateFichier(f2);
//Fich.deleteFichier(4);
 List<Fichier> fichiers;
        fichiers = Fich.readFichier(); 
        System.out.println(fichiers.toString());      */
    }   
}
