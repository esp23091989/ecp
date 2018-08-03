package com.ibis.ibisecp2.helpers;

import com.ibis.ibisecp2.model.ErrorResponse;

import rx.Observable;

/**
 * Created by danila on 08.12.16.
 */

public interface ChangeDiaryHelper {
    Observable<ErrorResponse> changeDiary(String note, String note_date);
}
