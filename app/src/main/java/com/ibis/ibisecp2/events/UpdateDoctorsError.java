package com.ibis.ibisecp2.events;

/**
 * Created by comp on 26.04.17.
 */

public class UpdateDoctorsError {
    private Throwable mThrowable;

    public UpdateDoctorsError() {
    }

    public UpdateDoctorsError(Throwable throwable) {
        mThrowable = throwable;
    }

    public Throwable getThrowable() {
        return mThrowable;
    }

    public void setThrowable(Throwable throwable) {
        mThrowable = throwable;
    }
}
