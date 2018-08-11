package com.ibis.ibisecp2.utils.rx.mappers;


import com.ibis.ibisecp2.model.Child;
import com.ibis.ibisecp2.model.auth.dto.UserInfoResponse;

import java.util.List;

import javax.inject.Inject;

public class ChildrenMapper {

    @Inject
    public ChildrenMapper() {
    }

    public Child transform(UserInfoResponse userInfoResponse){
        Child child = new Child();
        child.setFirstName(userInfoResponse.getFirstName());
        child.setMiddleName(userInfoResponse.getMiddleName());
        child.setLastName(userInfoResponse.getLastName());
        child.setBirthDate(userInfoResponse.getBirthDate());
        child.setGender(userInfoResponse.getGender());
        child.setSNILS(userInfoResponse.getSnils());
        return child;
    }
}
