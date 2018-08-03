package com.ibis.ibisecp2.events;

/**
 * Created by danila on 20.02.17.
 */

public class EventCalendar {
    long _id;
    private String eventId;
    private String caseNumber;

    public EventCalendar() {
    }

    public EventCalendar(long _id, String caseNumber, String eventId) {
        this.caseNumber = caseNumber;
        this.eventId = eventId;
        this._id = _id;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }
}
