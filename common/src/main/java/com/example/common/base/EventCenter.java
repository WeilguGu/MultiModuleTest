package com.example.common.base;

/**
 * Author : weilgu
 * Date   : 2020/12/19
 */
public class EventCenter<T> {

    /**
     * reserved data
     */
    private T data;

    /**
     * this code distinguish between different events
     */
    private int eventCode = -1;

    public EventCenter(int eventCode) {
        this(eventCode, null);
    }

    public EventCenter(int eventCode, T data) {
        this.eventCode = eventCode;
        this.data = data;
    }

    /**
     * get event code
     */
    public int getEventCode() {
        return this.eventCode;
    }

    /**
     * get event reserved data
     */
    public T getData() {
        return this.data;
    }
}
