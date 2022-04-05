/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import interfaces.IServiceCatégoriee ;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.catégorie;
import utils.MaConnexion;

/**
 *
 * @author 21655
 */
public class ServiceCatégorie implements IServiceCatégoriee {
    //var
    MaConnexion instance = MaConnexion.getInstance();
    Connection cnx = instance.getCnx();

    
    public void createCatégorie(catégorie  p) {
        
        //request
        String req = "INSERT INTO `categorie`(`nom`) VALUES (?)";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, p.getNom());
          ;
            st.executeUpdate();
            System.out.println("catégorie ajoutée avec succes.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
        
    }

    @Override
    public List<catégorie> readCatégories() {
        ArrayList<catégorie> personnes = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM categorie ";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                personnes.add(new catégorie (rs.getInt(1), rs.getString("nom")));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return personnes;
    }

    @Override
    public void createPersonne(catégorie c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    public void DeleteCatégorie(int id) {
        try {

            if (id != 0) {
                String sql = "delete from categorie WHERE id=?";
                PreparedStatement st = cnx.prepareStatement(sql);
                st.setInt(1, id);
                st.executeUpdate();
                System.out.println("Catégorie deleted !");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
        public void updateCatégorie(catégorie c) {
        try {

            if (c.getId() != 0) {
                String sql = "UPDATE categorie  SET nom=? WHERE id=?";

                PreparedStatement st = cnx.prepareStatement(sql);
                st.setString(1, c.getNom());
               
                st.setInt(2, c.getId());
                st.executeUpdate();
                System.out.println("updated !");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    
    
}
