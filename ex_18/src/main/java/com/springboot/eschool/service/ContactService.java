package com.springboot.eschool.service;

import com.springboot.eschool.constants.ESchoolConstants;
import com.springboot.eschool.model.Contact;
import com.springboot.eschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    public boolean saveMessageService(Contact contact){
        boolean isSaved = false;
        contact.setStatus(ESchoolConstants.OPEN);
//        contact.setCreatedBy(ESchoolConstants.ANONYMOUS);
//        contact.setCreatedAt(LocalDateTime.now());

        Contact savedContact = contactRepository.save(contact);
        if(savedContact != null && savedContact.getContactId() > 0){
            isSaved = true;
        }

        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
//        List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(ESchoolConstants.OPEN);
        List<Contact> contactMsgs = contactRepository.findByStatus(ESchoolConstants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int id){
        boolean isUpdated = false;
//        int result = contactRepository.updateMsgStatus(id, ESchoolConstants.CLOSE, updatedBy);
        Optional<Contact> contact = contactRepository.findById(id);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(ESchoolConstants.CLOSE);
//            contact1.setUpdatedBy(updatedBy);
//            contact1.setUpdatedAt(LocalDateTime.now());
        });
        Contact updatedContact = contactRepository.save(contact.get());
        if(updatedContact != null && updatedContact.getUpdatedBy() != null){
            isUpdated = true;
        }

        return isUpdated;
    }

}
