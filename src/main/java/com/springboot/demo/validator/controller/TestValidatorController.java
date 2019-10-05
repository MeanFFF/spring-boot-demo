package com.springboot.demo.validator.controller;

import com.springboot.demo.validator.model.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-05 09:25:46
 * @since 1.0
 */
@RestController
@Validated
public class TestValidatorController {

    @GetMapping("/testValidator")
    public String test1(@NotNull(message = "{required}")String name, @NotNull(message = "{required}")@Email(message = "{invalid}") String email) {
        return name + email;
    }

    @GetMapping("/testValidatorModel")
    public String test1(@Valid User user) {
        return user.toString();
    }
}
