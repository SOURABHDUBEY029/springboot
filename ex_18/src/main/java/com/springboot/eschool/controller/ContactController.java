package com.springboot.eschool.controller;

import com.springboot.eschool.model.Contact;
import com.springboot.eschool.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@Controller
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String displayContact(Model model){
        model.addAttribute("contact", new Contact());
        return "contact.html";
    }

    @RequestMapping(value="/saveMsg", method = POST)
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if(errors.hasErrors()){
            log.error("Contact form validation restricted due to : " + errors.toString());
            return "contact.html";
        }
        contactService.saveMessageService(contact);
        contactService.setCounter(contactService.getCounter()+1);
        log.info("Number of times the form submitted is : " + contactService.getCounter());
        return "redirect:/contact";
    }
}
