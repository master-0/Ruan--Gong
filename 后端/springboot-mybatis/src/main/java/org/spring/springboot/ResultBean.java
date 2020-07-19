package org.spring.springboot;

import java.util.Collection;

public class ResultBean<T> {
    private int code;
    private String message;
    private Collection<T> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }

    private ResultBean() {

    }

    public static ResultBean error(String id, int code, String message) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(code);
        resultBean.setMessage(message);
        http(id, Thread.currentThread().getStackTrace()[3].toString(), message + "-error");
        return resultBean;
    }

    public static ResultBean success(String id) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(0);
        resultBean.setMessage("success");
        http(id, Thread.currentThread().getStackTrace()[3].toString(), "success");
        return resultBean;
    }

    public static <V> ResultBean<V> success(String id, Collection<V> data) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(0);
        resultBean.setMessage("success");
        resultBean.setData(data);
        http(id, Thread.currentThread().getStackTrace()[3].toString(), "success");
        return resultBean;
    }

    public static boolean IsSuccess(ResultBean res) {
        return res.getCode() == 0;
    }

    private static void http(String id, String func, String state) {
        try {
            HttpClient.record(id + "---" + func + "---" + state + "!");
        } catch (Exception e) {
            try{
                HttpClient.record(e.toString());
            }catch (Exception e1){}
        }
    }
}

