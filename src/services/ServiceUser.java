/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.InterfaceUser;
import java.sql.Statement;
import utils.MaConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.User;

/**
 *
 * @author bacca
 */
public class ServiceUser implements InterfaceUser{
    
    MaConnexion instance = MaConnexion.getInstance();
    Connection cnx = instance.getCnx();
    

    @Override
    public User UserDetails(int id) {
        
        User user = new User();
        
        try {
           
            String req = "SELECT * FROM user where id="+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) { 
                user.setId(rs.getInt(1));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setDate_naissance(rs.getDate("date_naissance"));
                user.setDescription(rs.getString("description"));
                user.setProfession(rs.getString("profession"));
                user.setVerified(rs.getBoolean("verified"));
                user.setCode(rs.getString("code"));
                user.setCreated_at(rs.getDate("created_at"));
                user.setBanned(rs.getBoolean("banned"));
                user.setBids(rs.getInt("bids"));
                user.setAddress(rs.getString("address"));
                user.setCode_postal(rs.getInt("code_postal"));
                user.setPhoto(rs.getString("photo"));
                
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return user;
    }
    public User addUser(User user){
        //request
        String req = "INSERT INTO `User`(`email`, `password`, `nom`, `prenom`, `date_naissance`, `description` , `profession` , `verified` , `code` , `created_at` ,  `banned` ,`bids` , `address` , `code_postal` , `photo`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, user.getEmail());
            st.setString(2, user.getPassword());
            st.setString(3, user.getNom());
            st.setString(4, user.getPrenom());
            st.setDate(5, user.getDate_naissance());
            st.setString(6, user.getDescription());
            st.setString(7, user.getProfession());
            st.setBoolean(8, user.isVerified());
            st.setString(9, user.getCode());
            st.setDate(10, user.getCreated_at());
            st.setBoolean(11 , user.isBanned());
            st.setInt(12, user.getBids());
            st.setString(13, user.getAddress());
            st.setInt(14, user.getCode_postal());
            st.setString(15, user.getPhoto());
            
            
            st.executeUpdate();
            System.out.println("User ajoutée avec succes.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        return user;
        
    }
    
}
