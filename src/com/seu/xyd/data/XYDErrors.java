package com.seu.xyd.data;

public enum XYDErrors {
    UNKNOWN(1, "未知错误"),
    WRONG_TYPE_OF_FILE(2, "错误的文件格式"),
    IO_ERROR_WHEN_READ_FILE(3, "读文件错误"),
    FAIL_PARSE_JSON(4, "解析json出错"),
    NO_SUCH_USER(10, "不存在该用户"),
    NO_SUCH_PROJECT(11, "不存在该项目"),
    NO_SUCH_PIC(12, "不存在该图片"),
    SIGN_IN_FAIL(19, "登录失败。"),
    
    IO_UNEXPECTED_ERROR(98, "发生意外的流错误"),
    DB_UNEXPECTED_ERROR(99, "发生意外的数据库错误")
    ;

    private final int errCode;
    private final String errMsg;

    XYDErrors(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
