/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactmanager.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



/**
 *
 * @author Manuel Birba
 */
public class Contact {
    
    private String nom;
    private String preNom;
    @NotNull
    @Size(min=1, max=40)
    private String email;
    private Date dateNaissance;
    private boolean actif;
    private String dateNaissanceString; 
    private List<Adresse> adresses = new LinkedList<Adresse>(); 

    public String getDateNaissanceString() {
        return dateNaissanceString;
    }

    public void setDateNaissanceString(String dateNaissanceString) {
        this.dateNaissanceString = dateNaissanceString;
    }

    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPreNom() {
        return preNom;
    }

    public void setPreNom(String preNom) {
        this.preNom = preNom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date DateNaissance) {
        this.dateNaissance = DateNaissance;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
    
    public void addAdresse(Adresse adresse){
        adresses.add(adresse);
    }
    
    public void removeAdresse(Adresse adresse){
        adresses.remove(adresse);
    }

    public List<Adresse> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
    }
    
    
}
