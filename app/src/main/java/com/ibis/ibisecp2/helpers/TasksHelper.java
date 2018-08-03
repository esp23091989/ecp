package com.ibis.ibisecp2.helpers;

import com.ibis.ibisecp2.model.Tasks;

import rx.Observable;

/**
 * Created by danila on 14.12.16.
 */

public interface TasksHelper {
    Observable<Tasks> getTasks();
}
