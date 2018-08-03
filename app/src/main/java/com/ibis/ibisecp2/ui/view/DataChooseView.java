package com.ibis.ibisecp2.ui.view;

import com.ibis.ibisecp2.model.Schedule;

import java.util.List;

/**
 * Created by danila on 04.08.16.
 */
public interface DataChooseView {
    void showSchedule(List<Schedule> scheduleList);

    void addSchedule(List<Schedule> scheduleList);

    void showScheduleError();
}
