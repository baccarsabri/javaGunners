/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.List;
import models.Portfolio;
import services.ServicePortfolio;
import models.Review;
import services.ServiceReview;

/**
 *
 * @author YOGA
 */
public class Lancitounsi {
    public static void main (String[] args) 
    {

         ServicePortfolio portSer=new ServicePortfolio();
    
       Portfolio p= new Portfolio("java", "syrineee");
       Portfolio p1= new Portfolio("web","syrine");
       Portfolio p2= new Portfolio("weeeb", "good");
       
       
       
          
    
    portSer.createPortfolio(p);
          //portSer.modifier_portfolio(p2,"weeeb");
   portSer.supprimer_portfolio(p2);
          List<Portfolio> portfolios = new ArrayList();
        portfolios = portSer.readPortfolio(); 
        System.out.println(portfolios.toString());
   

        

  // ServiceReview revSer=new ServiceReview();
     //   Review r= new Review(20,"syrine");
      // Review r2= new Review(4, "good");
        
            

    
        
  // revSer.createReview(r2);
   // portSer.modifier_review(r2,4);
    //portSer.supprimer_review(r2,30);
     //List<Review> reviews = new ArrayList();
      //  reviews = revSer.readReviews(); 
       // System.out.println(reviews.toString());

    }
    

}
