package com.ibis.ibisecp2.utils.rx.zippers;

import android.util.Patterns;

import com.ibis.ibisecp2.model.AuthResponse;
import com.ibis.ibisecp2.model.ContactInfoResponse;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.model.auth.dto.UserInfoResponse;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

/**
 * Created by Юленька on 06.08.2018.
 */

public class AuthResponseZipper {

    @Inject
    public AuthResponseZipper() {
    }

    public AuthResponse transform(UserInfoResponse userInfoResponse, List<ContactInfoResponse> contactInfoResponses){
        Patient patient = new Patient();
        patient.setFirstName(userInfoResponse.getFirstName());
        patient.setMiddleName(userInfoResponse.getMiddleName());
        patient.setLastName(userInfoResponse.getLastName());
        patient.setSNILS(userInfoResponse.getSnils());

        for(ContactInfoResponse contactInfoResponse : contactInfoResponses){
            if(isEmail(contactInfoResponse.getValue()))
                patient.setEMail(contactInfoResponse.getValue());
            else if(isPhone(contactInfoResponse.getValue())){
                patient.setPhone(contactInfoResponse.getValue());
            }
        }

        AuthResponse authResponse = new AuthResponse();
        authResponse.setPeople(patient);
        return authResponse;
    }

    private static boolean isEmail(String email) {
        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE); // Set the email pattern string
        Matcher m = p.matcher(email); // Match the given string with the pattern
        return m.matches();
    }

    private static boolean isPhone(String phone) {
        Matcher m = Patterns.PHONE.matcher(phone); // Match the given string with the pattern
        return m.matches();
    }


}
