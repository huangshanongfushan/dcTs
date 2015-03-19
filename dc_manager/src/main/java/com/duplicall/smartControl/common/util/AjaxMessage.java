package com.duplicall.smartControl.common.util;


/**
 * ajax请求后返回的信息
 * @Description 
 * @author mli
 * @date 2014年3月13日 下午10:52:20 
 * @version V1.3.1
 * @param <T>
 */
public class AjaxMessage<T> {
    private boolean success;

    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AjaxMessage [success=" + success + ", message=" + message + "]";
    }

}

