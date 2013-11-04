/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactmanager.service;

import com.contactmanager.model.Contact;
import java.util.List;

/**
 *
 * @author Manuel Birba
 */
public interface ContactStore {
    
    public void addContact(Contact contact) throws IllegalArgumentException;
    
    public void removeContact(Contact contact) throws IllegalArgumentException;
    
    public void removeContact(String email) throws IllegalArgumentException;
    
    public void edit(Contact contact) throws IllegalArgumentException;
    
    public List<Contact> getContacts();
    
    public List<Contact> searchContacts(String searchString);
    
    public Contact getContact(String email);
    
}
