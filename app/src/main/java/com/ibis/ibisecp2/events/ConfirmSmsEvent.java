package com.ibis.ibisecp2.events;

/**
 * Created by comp on 21.03.17.
 */

public class ConfirmSmsEvent {
    private String code;

    public ConfirmSmsEvent(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
