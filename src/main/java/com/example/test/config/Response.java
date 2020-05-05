package com.example.test.config;



import java.io.Serializable;
import java.text.MessageFormat;

public class Response<T> implements Serializable {
    private Integer code;
    private String  desc;
    private T       data;

    private boolean success = true;

    public Response() {
    }

    private Response(Integer code, String desc, T data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder<T> {
        private Integer code = 200;
        private String  desc = "成功";
        private T       data;

        public Builder() {
        }

        public Builder baseResponse(ResultCode resultCode) {
            this.code = resultCode.getResultCode();
            this.desc = resultCode.getDesc();
            return this;
        }

        public Builder baseResponse(ResultCode resultCode, Object... objs) {
            this.code = resultCode.getResultCode();
            this.desc = MessageFormat.format(resultCode.getDesc(), objs);
            return this;
        }

        public Builder baseResponse(Integer code, String message) {
            this.code = code;
            this.desc = message;
            return this;
        }

        public Builder result(T data) {
            this.data = data;
            return this;
        }

        public Response build() {
            return new Response(this.code, this.desc, this.data);
        }
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return "200".equals(String.valueOf(code.intValue()));
    }
}
