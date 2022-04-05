/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IServiceReclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Reclamation;
import utils.MaConnexion;

/**
 *
 * @author Oussama Fdhila
 */
public class ServiceReclamation implements IServiceReclamation{
    
    //var
    MaConnexion instance = MaConnexion.getInstance();
    Connection cnx = instance.getCnx();

    public void createReclamation(Reclamation r) {
        //request
        String req = "INSERT INTO `reclamation`(`description`, `date_de_reclamation`, `statut`) VALUES (?,?,?)";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, r.getDescription());
            st.setDate(2, r.getDate_de_reclamation());
            st.setString(3, r.getStatut());
            st.executeUpdate();
            System.out.println("Reclamation ajoutée avec succés.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
        
    }

    public List<Reclamation> readReclamation() {
        ArrayList<Reclamation> reclamations = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM reclamation";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                reclamations.add(new Reclamation(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getDate("date_de_reclamation"), rs.getString(5)));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return reclamations;
    }
public void deleteReclamation(int id) {
        try {

            if (id != 0) {
                String sql = "delete from reclamation WHERE id=?";
                PreparedStatement st = cnx.prepareStatement(sql);
                st.setInt(1, id);
                st.executeUpdate();
                System.out.println("Réclamation supprimée !");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        public void updateReclamation(Reclamation r) {
        try {

            if (r.getId() != 0) {
                String sql = "UPDATE reclamation  SET projet_id=?,description=?,date_de_reclamation=?,statut=? WHERE id=?";

                PreparedStatement st = cnx.prepareStatement(sql);
                                st.setInt(1, r.getProjet_id());

                st.setString(2, r.getDescription());
                st.setDate(3, r.getDate_de_reclamation());
                st.setString(4, r.getStatut());
                st.setInt(5, r.getId());
                st.executeUpdate();
                System.out.println("la réclamation est à jour !");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    
    
    
    
    
    
}