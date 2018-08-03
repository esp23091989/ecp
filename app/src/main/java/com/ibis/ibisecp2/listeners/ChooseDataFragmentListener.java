package com.ibis.ibisecp2.listeners;

import com.ibis.ibisecp2.model.Schedule;

import java.util.List;

/**
 * Created by danila on 04.12.15.
 */
public interface ChooseDataFragmentListener {
    void onChosenData(List<Schedule> freeTimeList, String dateMonth);
}
