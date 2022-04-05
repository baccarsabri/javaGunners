/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import interfaces.IServiceContrat ;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.catégorie;
import models.contrat;
import utils.MaConnexion;

/**
 *
 * @author 21655
 */
public class ServiceContrat implements IServiceContrat{
    
    
    //var
    MaConnexion instance = MaConnexion.getInstance();
    Connection cnx = instance.getCnx();

    
    public void createContrat(contrat  p) {
        
        //request
        String req = "INSERT INTO `contrat`( `user_client_id`, `user_freelancer_id`, `prix`, `created_at`, `statut`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, p.getUser_client_id());
            st.setInt(2, p.getUser_freelancer_id());
            st.setFloat(3, p.getPrix());
            st.setDate(4, p.getCreated_at());
            st.setString(5, p.getStatut());
            
            
         
          ;
            st.executeUpdate();
            System.out.println("Contrat ajoutée avec succes.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
        
    }

    public List<contrat> readcontrats() {
        ArrayList<contrat> personnes = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM contrat ";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                personnes.add(new contrat (rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4), rs.getDate(5), rs.getString(6)));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return personnes;
    }

   

   
    @Override
    public void Deletecontrat(int id) {
        try {

            if (id != 0) {
                String sql = "delete from contrat WHERE id=?";
                PreparedStatement st = cnx.prepareStatement(sql);
                st.setInt(1, id);
                st.executeUpdate();
                System.out.println("contrat deleted !");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    @Override
     public void updatecontrat(contrat c) {
        try {

            if (c.getId() != 0) {
                String sql = "UPDATE contrat  SET user_client_id=?,user_freelancer_id=?,prix=?,created_at=?,statut=? WHERE id=?";

                PreparedStatement st = cnx.prepareStatement(sql);
                   
            st.setInt(1, c.getUser_client_id());
            st.setInt(2, c.getUser_freelancer_id());
            st.setFloat(3, c.getPrix());
            st.setDate(4, c.getCreated_at());
            st.setString(5, c.getStatut());
               
                st.setInt(6, c.getId());
                st.executeUpdate();
                System.out.println("updated !");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
