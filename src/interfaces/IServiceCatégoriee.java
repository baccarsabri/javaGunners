/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.util.List;
import models.catégorie;
/**
 *
 * @author 21655
 */
public interface IServiceCatégoriee {
     //CRUD
    public void createPersonne(catégorie  c);
    public List<catégorie> readCatégories();
    public void DeleteCatégorie(int id);
    public void updateCatégorie(catégorie c);

}
