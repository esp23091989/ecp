package com.ibis.ibisecp2.model.post;

/**
 * Created by danila on 03.11.16.
 */

public class DiaryPost extends BasePost {
    private String period;

    public DiaryPost(String login, String period) {
        this.period = period;
        this.login = login;
    }
}
