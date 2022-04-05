/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import models.Projet;

/**
 *
 * @author malek
 */
public interface IServiceProjet {
    public void createProjet(Projet p);
    public List<Projet> readProjets();
    public void updateProjet(int id,String nom,String description,double min_salaire,double max_salaire);
    public void deleteProjet(int id);
    public Projet detailProjet(int id);
    
}
