/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactmanager.service;

import com.contactmanager.model.Adresse;
import com.contactmanager.model.Contact;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Manuel Birba
 */
public class InMemoryContactStore implements ContactStore {
    
    private Map<String, Contact> contacts = new HashMap<String, Contact>();
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
    private Logger logger = Logger.getLogger(InMemoryContactStore.class.getName());
    
    private boolean isEmpty(String value){
        return ((value == null) || (value.trim().length() == 0));
    }
            
    public void addContact(Contact contact) throws IllegalArgumentException{
        if(contact == null){
            return;
        }
        if(contacts.containsKey(contact.getEmail())){
            throw new IllegalArgumentException("Contact with Email " + contact.getEmail() + " already exists");
        }
        contacts.put(contact.getEmail(), contact);
        Iterator itr = contact.getAdresses().iterator();
        while(itr.hasNext()){
            Adresse a = (Adresse) itr.next();
            if(a.isDelete()){
                itr.remove();
            }
        }
        try{
            if(!isEmpty(contact.getDateNaissanceString()))
            contact.setDateNaissance(format.parse(contact.getDateNaissanceString()));
        }catch(Exception e){
            e.printStackTrace();
//            logger.severe(e.getLocalizedMessage());
        }
        
    }
    
    public void removeContact(Contact contact) throws IllegalArgumentException{
        if(contact == null){
            return;
        }
        if(!contacts.containsKey(contact.getEmail())){
            throw new IllegalArgumentException("No Contact Exists with Email " + contact.getEmail());
        }
        contacts.remove(contact.getEmail());
    }        
    
    public void edit(Contact contact) throws IllegalArgumentException{
        
        if(contact == null){
            return;
        }
        if(!contacts.containsKey(contact.getEmail())){
            throw new IllegalArgumentException("No Contact Exists with Email " + contact.getEmail());
        }
        contacts.remove(contact.getEmail());
        Iterator itr = contact.getAdresses().iterator();
        while(itr.hasNext()){
            Adresse a = (Adresse) itr.next();
            if(a.isDelete()){
                itr.remove();
            }
        }
        try{
            if(!isEmpty(contact.getDateNaissanceString()))
            contact.setDateNaissance(format.parse(contact.getDateNaissanceString()));
        }catch(Exception e){
            e.printStackTrace();
        }
        contacts.put(contact.getEmail(), contact);
    }
    
    public List<Contact> getContacts(){
        List<Contact> contactList = new LinkedList<Contact>();
        for(Contact c : contacts.values()){
            contactList.add(c);
        }
        return contactList;
    }
    
    public List<Contact> searchContacts(String searchString){
        List<Contact> contactList = new LinkedList<Contact>();
        if(isEmpty(searchString))
            return contactList;
        for(String email : contacts.keySet()){
            if(email.toLowerCase().contains(searchString.toLowerCase())){
                contactList.add(contacts.get(email));
            }
        }
        return contactList;
    }

    @Override
    public Contact getContact(String email) {
        return contacts.get(email);
    }

    @Override
    public void removeContact(String email) throws IllegalArgumentException {
        if(email == null)
            return;
        if(!contacts.containsKey(email)){
            throw new IllegalArgumentException("No contact Exists with email : " + email);
        }
        contacts.remove(email);
    }
    
}
