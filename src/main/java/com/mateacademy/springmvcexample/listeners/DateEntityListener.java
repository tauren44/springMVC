package com.mateacademy.springmvcexample.listeners;

import com.mateacademy.springmvcexample.model.DateEntity;

import javax.persistence.PrePersist;
import java.util.Date;

public class DateEntityListener {
    @PrePersist
    public void prePersist(DateEntity entity) {
        entity.setDate(new Date().getTime());
    }
}
