package com.ibis.ibisecp2.model.post;

/**
 * Created by danila on 03.11.16.
 */

public class VisitPost extends BasePost {
    private String scheduleid;

    public VisitPost(String scheduleid, String login, String password) {
        this.scheduleid = scheduleid;
        this.login = login;
        this.password = password;
    }
}
