/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import models.User;

/**
 *
 * @author bacca
 */
public interface InterfaceTransaction {
    
    public void transaction(User user , String type);
    
}