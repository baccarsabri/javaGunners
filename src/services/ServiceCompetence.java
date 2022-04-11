/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IServiceCompetence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Competence;
import utils.MaConnexion;

/**
 *
 * @author admin
 */
public abstract class ServiceCompetence implements IServiceCompetence{
    
    //var
    MaConnexion instance = MaConnexion.getInstance();
    Connection cnx = instance.getCnx();

    @Override
    public void createCompetence(Competence c) {
        
        //request
        String req = "INSERT INTO `competence`(`nom`) VALUES (?)";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, c.getNom());
            st.executeUpdate(req);
            System.out.println("Competence ajoutée avec succes.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
        
    }

    
    public List<Competence> readCompetence() {
        ArrayList<Competence> competences = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM competence";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                competences.add(new Competence(rs.getInt(1), rs.getString("nom")));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return competences;
    }
    
    
    
    
    
    
    
}