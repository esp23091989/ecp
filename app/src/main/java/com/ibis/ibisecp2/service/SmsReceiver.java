package com.ibis.ibisecp2.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.events.ConfirmSmsEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by comp on 20.03.17.
 */

public class SmsReceiver extends BroadcastReceiver {
    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(SMS_RECEIVED)) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                SmsMessage smsMessage = null;
                if (Build.VERSION.SDK_INT >= 19) { //KITKAT
                    SmsMessage[] msgs = Telephony.Sms.Intents.getMessagesFromIntent(intent);
                    if (msgs.length > -1) {
                        smsMessage = msgs[0];
                    }
                } else {
                    Object pdus[] = (Object[]) bundle.get("pdus");
                    if (pdus.length > -1) {
                        smsMessage = SmsMessage.createFromPdu((byte[]) pdus[0]);
                    }
                }
                if (smsMessage != null && smsMessage.getOriginatingAddress() != null
                        && smsMessage.getOriginatingAddress()
                        .equals(context.getString(R.string.gos_services))) {
                    String[] splitSms = smsMessage.getMessageBody().split(" ");
                    String code = splitSms[splitSms.length - 1];
                    EventBus.getDefault().post(new ConfirmSmsEvent(code));
                }
            }
        }
    }
}