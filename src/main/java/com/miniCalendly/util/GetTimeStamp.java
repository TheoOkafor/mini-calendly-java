package com.miniCalendly.util;

import java.util.Date;
import java.sql.Timestamp;

public class GetTimeStamp {
    private Date date= new Date();
    private long time = date.getTime();

    private Timestamp timestamp = new Timestamp(time);

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
