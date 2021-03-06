package com.mateacademy.springmvcexample.model;

import com.mateacademy.springmvcexample.listeners.DateEntityListener;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
@EntityListeners(value = DateEntityListener.class)
public class DateEntity extends Entity {
    private Long date;
}
