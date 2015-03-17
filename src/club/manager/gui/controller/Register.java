/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.manager.gui.controller;

import club.db.Query;
import club.domain.Member;

/**
 *
 * @author phcr
 */
public class Register {
    
    public static Member model;
    
    public static boolean validateModel() {
        return (model.getId() != null && !model.getId().equals("") ||
                model.getGivenname() != null && !model.getGivenname().equals("") ||
                model.getSurname() != null && !model.getSurname().equals("") ||
                model.getEmail() != null && !model.getEmail().equals("") ||
                model.getGender() > -1 ||
                model.getBirthdate() > -1 ||
                model.getJoindate() > -1
                );
    }
    
    public static void RegisterMember() throws Exception {
        if (validateModel()) {
            
        } else {
            Exception InvalidModelException = null; // Will add the codes later
            throw InvalidModelException;
        }
    }
    
    public static void UpdateMember() throws Exception {
        if (validateModel()) {
            
        } else {
            Exception InvalidModelException = null;
            throw InvalidModelException;
        }
    }
    
}
