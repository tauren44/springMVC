package com.mateacademy.springmvcexample.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class UserEntity extends DateEntity {

    private LocalDate dateOfBirth;
    private String name;
    private Integer salary;
    private String email;
    private Role role;
}
