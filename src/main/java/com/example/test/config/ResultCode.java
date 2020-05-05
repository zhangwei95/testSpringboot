package com.example.test.config;

/**
 * 6位业务码
 */
public enum ResultCode {
	NOT_LOGGED_IN(301, "未登录,请先登录"),
	
    PARAM_NULL(401, "参数为空"),

    PARAM_ERROR(402, "参数异常"),

    OPERATION_SUCCESS(200, "操作成功"),

    OPERATION_CONCURRENCY_FAIL(1000, "正在处理，请勿重复提交，稍后再试！"),

    OPERATION_OCCUR_EXCEPTION(999999, "系统繁忙，请稍后再试"),

    DATA_NOT_FOUND(101, "没有找到数据"),

    SAVE_ERROR(102, "保存失败"),

    DELETE_FORBIDDEN(103, "文件夹存在数据，不可删除"),

    DELETE_ERROR(104, "删除失败"),


    ERROR(500, "系统错误"),
    INVALID(501, "非法操作"),

   ;


    private Integer resultCode;
    private String desc;

    ResultCode(Integer resultCode, String desc) {
        this.resultCode = resultCode;
        this.desc = desc;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }}
