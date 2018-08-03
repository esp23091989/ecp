package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.helpers.ScheduleLoaderHelper;
import com.ibis.ibisecp2.model.ScheduleResponse;
import com.ibis.ibisecp2.retrofit.EcpAp;
import com.ibis.ibisecp2.utils.RxUtil;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by danila on 28.10.16.
 */

public class ScheduleLoaderHelperImpl implements ScheduleLoaderHelper {

    private RxUtil rxUtil;
    private EcpAp ecpAp;

    @Inject
    public ScheduleLoaderHelperImpl(RxUtil rxUtil, EcpAp ecpAp) {
        this.rxUtil = rxUtil;
        this.ecpAp = ecpAp;
    }

    @Override
    public Observable<ScheduleResponse> getSchedule(String clinicId, String depCode, String doctorId,
                                                    String profCode, String positionCode,
                                                    String beginDate) {
        return ecpAp.getSchedule(clinicId, depCode, doctorId, profCode, positionCode, beginDate);
    }
}
