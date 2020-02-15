package com.miniCalendly.model;

import com.miniCalendly.util.GetTimeStamp;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String name;
    private String time_zone;
    private Timestamp created_at;
    private Timestamp modified_at;

    public User() {}

    public User(String username, String name, String time_zone) {
        this.username = username;
        this.name = name;
        this.time_zone = time_zone;
        this.created_at = new GetTimeStamp().getTimestamp();
        this.modified_at = new GetTimeStamp().getTimestamp();
    }
}
