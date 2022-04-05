/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lancitounsidesk;

import java.sql.Connection;
import models.Projet;
import services.ServiceProjet;
import utils.MaConnexion;

/**
 *
 * @author malek
 */
public class LancitounsiDesk {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        MaConnexion instance = MaConnexion.getInstance();
        Connection cnx = instance.getCnx();
        System.out.println("connextion..."+cnx);
        
        Projet p=new Projet(2,"malek","aaaaaaaaaaaaaaaa",10,102,"pending");
        ServiceProjet s =new ServiceProjet();
         s.createProjet(p);
        s.updateProjet(10, "malik", "sdsqjdksghqdsqgd", 20, 400);
        s.detailProjet(1);
        System.out.println(s.readProjets());
        System.out.println(s.detailProjet(1));
        
        
    }
    
}
