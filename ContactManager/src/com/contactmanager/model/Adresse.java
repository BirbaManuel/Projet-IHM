/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactmanager.model;

/**
 *
 * @author Manuel Birba
 */
public class Adresse {
    
    private String numero;
    private String rue;
    private String codePostal;
    private String ville;
    private boolean delete;

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Adresse other = (Adresse) obj;
        if ((this.numero == null) ? (other.numero != null) : !this.numero.equals(other.numero)) {
            return false;
        }
        if ((this.rue == null) ? (other.rue != null) : !this.rue.equals(other.rue)) {
            return false;
        }
        if ((this.codePostal == null) ? (other.codePostal != null) : !this.codePostal.equals(other.codePostal)) {
            return false;
        }
        if ((this.ville == null) ? (other.ville != null) : !this.ville.equals(other.ville)) {
            return false;
        }
        return true;
    }
    
    
}
