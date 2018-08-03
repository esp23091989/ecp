package com.ibis.ibisecp2.helpers;

import com.ibis.ibisecp2.model.ScheduleResponse;

import rx.Observable;

/**
 * Created by danila on 28.10.16.
 */

public interface ScheduleLoaderHelper {
    Observable<ScheduleResponse> getSchedule(String clinicId, String depCode, String doctorId,
                                             String profCode, String positionCode, String beginDate);
}
