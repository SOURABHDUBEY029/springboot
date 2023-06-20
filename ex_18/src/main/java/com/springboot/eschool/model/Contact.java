package com.springboot.eschool.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
//@Entity
public class Contact extends BaseEntity {

    private int contactId;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, message = "Name must be at least 3 character long")
    private String name;

    @NotBlank(message = "Mobile Number must not be blank")
//    @Pattern(regexp = "([0-9]{10})", message = "Mobile number must be 10 digits")
    @Pattern(regexp="[6789][0-9]{9}")
    private String mobileNum;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please Provide a valid Email")
    private String email;

    @NotBlank(message = "Subject must not be blank")
    @Size(min = 5, message = "Subject must be at least 5 character long")
    private String subject;

    @NotBlank(message = "Message must not be blank")
    @Size(min = 10, message = "Message must be at least 10 charcter long")
    private String message;

    private String status;

}
