/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.Connection;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import models.User;
import services.ServiceUser;
import utils.MaConnexion;

/**
 *
 * @author bacca
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic he
        long millis=System.currentTimeMillis();  
        java.sql.Date now=new java.sql.Date(millis);  
        
     
        MaConnexion instance = MaConnexion.getInstance();
        Connection cnx = instance.getCnx();
        
        ServiceUser s=new ServiceUser();
        User user= s.UserDetails(1);
        User u;
        u = new User( "sabri@gmail.com" , "password" , "malek" , "abassisse" , now , "ok" , "ok" , true , "1234", now , false , 100, "tunis", 2015, "sabri");
        s.addUser(u);
  
        System.out.println(user);
    }
    
}
