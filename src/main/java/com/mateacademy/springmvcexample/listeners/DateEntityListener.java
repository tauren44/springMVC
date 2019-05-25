package com.mateacademy.springmvcexample.listeners;

import com.mateacademy.springmvcexample.model.DateEntity;

import javax.persistence.PrePersist;
import java.time.LocalDate;

public class DateEntityListener {
    @PrePersist
    public void prePersist(DateEntity entity) {
        entity.setDate(LocalDate.now());
    }
}
