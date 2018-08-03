package com.ibis.ibisecp2.model.post;

/**
 * Created by danila on 03.11.16.
 */

public class OmsInfoPost extends BasePost {
    private String fromDate;
    private String toDate;

    public OmsInfoPost(String login, String password, String fromDate, String toDate) {
        this.login = login;
        this.password = password;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
}
