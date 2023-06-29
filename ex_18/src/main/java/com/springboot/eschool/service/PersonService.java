package com.springboot.eschool.service;

import com.springboot.eschool.constants.ESchoolConstants;
import com.springboot.eschool.model.Person;
import com.springboot.eschool.model.Roles;
import com.springboot.eschool.repository.PersonRepository;
import com.springboot.eschool.repository.RolesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(ESchoolConstants.STUDENT_ROLE);

        role.setRoleName("Lead");

        person.setRoles(role);
        person = personRepository.save(person);
        if(person != null && person.getPersonId() > 0){
            isSaved = true;
        }

        return isSaved;
    }
}
