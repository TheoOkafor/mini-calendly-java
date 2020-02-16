package com.miniCalendly.model;

import com.miniCalendly.util.GetTimeStamp;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Long id;

    private Long mentorId;
    private Long userId;
    private String message;
    private String date_time;
    private Timestamp created_at;
    private Timestamp modified_at;

    public Booking() {}

    public Booking(Long mentorId, Long userId, String message, String date_time) {
        this.mentorId = mentorId;
        this.userId = userId;
        this.message = message;
        this.date_time = date_time;
        this.created_at = new GetTimeStamp().getTimestamp();
        this.modified_at = new GetTimeStamp().getTimestamp();
    }
}

