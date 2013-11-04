/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactmanager.controller;

import com.contactmanager.model.Contact;
import com.contactmanager.service.ContactStore;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author Manuel Birba
 */

@Controller
@RequestMapping(value = "/contacts")  
public class ContactManagerController{
    
    private final static Logger logger = Logger.getLogger(ContactManagerController.class.getName());
    
    public ContactManagerController(){
        
    }
    
    @Autowired
    private ContactStore contactStore; 

    @RequestMapping(value = "addNew", method = RequestMethod.GET)  
    public ModelAndView addNewContact() {                                 
        ModelAndView modelAndView = new ModelAndView("addNew");
        modelAndView.addObject("contact",new Contact());
        return modelAndView;                                          
    }

    @RequestMapping(method = RequestMethod.GET)  
    public ModelAndView get() {                                 
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("message","Welcome to Contact Manager API");
        return modelAndView;                                          
    }
    
    @RequestMapping(value="home", method = RequestMethod.GET)  
    public ModelAndView getHome() {                                 
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("message","Welcome to Contact Manager API");
        return modelAndView;                                          
    }
    
    @RequestMapping(value = "addContact", method = RequestMethod.POST)  
    public ModelAndView addNewContact(@ModelAttribute("contact") @Valid Contact contact,
		BindingResult result){
        ModelAndView modelAndView = new ModelAndView();
        if(result.hasErrors()){
            modelAndView.setViewName("addNew");
            modelAndView.addObject("contact",contact);
            return modelAndView;
        }
        try {
            contactStore.addContact(contact);
        } catch (IllegalArgumentException ex) {
            java.util.logging.Logger.getLogger(ContactManagerController.class.getName()).log(Level.SEVERE, null, ex);
            result.rejectValue("email", null, "Email already exists");
            modelAndView.setViewName("addNew");
            modelAndView.addObject("contact",contact);
            return modelAndView;
        }
        String message = "Contact added succesfully with Email ID : " + contact.getEmail();
        modelAndView.setViewName("home");
        modelAndView.addObject("message",message);
        return modelAndView;
    }
    
    @RequestMapping(value = "search", method = RequestMethod.GET)  
    public ModelAndView getSearchPage(){
        ModelAndView modelAndView = new ModelAndView();
        List<Contact> contacts = new LinkedList<Contact>();
        modelAndView.setViewName("search");
        modelAndView.addObject("contacts",contacts);
        return modelAndView;
    }
    
    @RequestMapping(value = "doSearch", method = RequestMethod.GET)  
    public ModelAndView searchContacts(@RequestParam("searchString") String search){
        ModelAndView modelAndView = new ModelAndView();
        List<Contact> contacts = null;
        contacts = contactStore.searchContacts(search); 
        modelAndView.setViewName("search");
        modelAndView.addObject("contacts",contacts);
        return modelAndView;
    }

    @RequestMapping(value = "editContacts", method = RequestMethod.GET)  
    public ModelAndView editContacts(){
        ModelAndView modelAndView = new ModelAndView();
        List<Contact> contacts = contactStore.getContacts(); 
        modelAndView.setViewName("edit");
        modelAndView.addObject("contacts",contacts);
        return modelAndView;
    }
    
    @RequestMapping(value = "edit", method = RequestMethod.GET)  
    public ModelAndView editContact(@RequestParam("email") String email){
    ModelAndView modelAndView = new ModelAndView();
        Contact contact = contactStore.getContact(email); 
        modelAndView.setViewName("editContact");
        modelAndView.addObject("contact",contact);
        return modelAndView;
    }
    
    @RequestMapping(value = "doEdit", method = RequestMethod.POST)  
    public ModelAndView editContact(@ModelAttribute("contact") Contact contact){
        ModelAndView modelAndView = new ModelAndView();
        contactStore.edit(contact); 
        String message = "Contact edited sucessfully with Email ID : " + contact.getEmail();
        modelAndView.setViewName("home");
        modelAndView.addObject("message",message);
        return modelAndView;
    }
    
    @RequestMapping(value = "delete", method = RequestMethod.GET)  
    public ModelAndView deleteContact(@RequestParam("email") String email){
        ModelAndView modelAndView = new ModelAndView();
        contactStore.removeContact(email); 
        String message = "Contact removed with Email ID : " + email;
        modelAndView.setViewName("home");
        modelAndView.addObject("message",message);
        return modelAndView;
    }
    
    public void setContactStore(ContactStore contactStore) {
        this.contactStore = contactStore;
    }
    

    
}
