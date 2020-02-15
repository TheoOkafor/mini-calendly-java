package com.miniCalendly.model;

import com.miniCalendly.util.GetTimeStamp;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
public class Opening {
    @Id
    @GeneratedValue
    private Long id;

    private Long owner;
    private String date_time;
    private Timestamp created_at;
    private Timestamp modified_at;

    public Opening() {}

    public Opening(Long owner, String date_time) {
        this.owner = owner;
        this.date_time = date_time;
        this.created_at = new GetTimeStamp().getTimestamp();
        this.modified_at = new GetTimeStamp().getTimestamp();
    }
}

