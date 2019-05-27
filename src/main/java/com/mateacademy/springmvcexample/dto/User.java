package com.mateacademy.springmvcexample.dto;

import com.mateacademy.springmvcexample.model.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Setter
@Getter
@Accessors(chain = true)
public class User {

    private Long id;

    private LocalDate dateOfBirth;

    @Size(min = 2)
    private String name;

    private Role role;

    @NotNull
    private Integer salary;

    @Email
    private String email;
}
