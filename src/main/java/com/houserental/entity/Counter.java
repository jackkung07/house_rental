package com.houserental.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by cheyikung on 4/17/16.
 *
 * this is for auto increment id for each database in Mongodb
 * Not yet been used
 *
 *
 * Before using counter, user must go to mongodb and manually
 * create database counter for it
 *
 * db.counters.insert({_id: "XXX", seq: NumberLong("0") })
 *
 * note: XXX represents the collection name that your want to use
 */

@Document(collection = "counter")
public class Counter {
    @Id
    private String id;
    private long seq;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }
}
