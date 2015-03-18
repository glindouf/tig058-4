/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.manager.gui.controller;

import club.db.Query;
/**
 *
 * @author phcr
 */
public class Register {
        
        public static void RegisterMember(club.domain.register.Register model) throws Exception {
        if (model.validate()) {
            try {
                Query.insertMember(model);
            } catch (Exception e) {
                throw e;
            }
        } else {
            Exception ex = new Exception("All fields must have values", null);
            throw ex;
        }
    }
    
    public static void UpdateMember(club.domain.register.Register model) throws Exception {
        if (model.validate()) {
            
        } else {
            Exception ex = new Exception("All fields must have values", null);
            throw ex;
        }
    }
    
}
