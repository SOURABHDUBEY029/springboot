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

@Slf4j
@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    public boolean saveMessageService(Contact contact){
        boolean isSaved = false;
        contact.setStatus(ESchoolConstants.OPEN);
        contact.setCreatedBy(ESchoolConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());

        int result = contactRepository.saveContactMessage(contact);
        if(result > 0){
            isSaved = true;
        }

        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(ESchoolConstants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int id, String updatedBy){
        boolean isUpdated = false;
        int result = contactRepository.updateMsgStatus(id, ESchoolConstants.CLOSE, updatedBy);
        if(result > 0){
            isUpdated = true;
        }

        return isUpdated;
    }

}
