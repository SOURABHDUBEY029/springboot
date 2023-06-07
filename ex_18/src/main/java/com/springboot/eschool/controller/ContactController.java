package com.springboot.eschool.controller;

import com.springboot.eschool.model.Contact;
import com.springboot.eschool.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String displayContact(){
        return "contact.html";
    }

    @RequestMapping(value="/saveMsg", method = POST)
    public ModelAndView saveMessage(Contact contact){
        contactService.saveMessageService(contact);
        return new ModelAndView("redirect:/contact");
    }
}
