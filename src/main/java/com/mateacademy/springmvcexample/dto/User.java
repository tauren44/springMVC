package com.mateacademy.springmvcexample.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@Accessors(chain = true)
public class User {

    private Long id;

    @Min(18)
    @Max(90)
    private Integer age;

    @Size(min = 2)
    private String name;

    @NotBlank
    private Integer salary;

    @Email
    private String email;
}
