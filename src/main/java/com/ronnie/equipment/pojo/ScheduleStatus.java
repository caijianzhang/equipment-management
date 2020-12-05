package com.ronnie.equipment.pojo;

public enum ScheduleStatus {
    SCHEDULING(0),
    ACTING(1),
    DONE(2);

    int status;
    ScheduleStatus(int status) {
        this.status = status;
    }
}