package com.ibis.ibisecp2.model.post;

/**
 * Created by danila on 03.11.16.
 */

public class SaveDiary extends BasePost {
    private String note;
    private String date;

    public SaveDiary(String note, String date, String login, String password) {
        this.note = note;
        this.date = date;
        this.login = login;
        this.password = password;
    }
}
