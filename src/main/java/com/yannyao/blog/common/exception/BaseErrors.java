package com.yannyao.blog.common.exception;

/**
 * @Auther: YJY
 * @Date: 2018/9/13 10:08
 * @Description:
 */
public enum BaseErrors implements ApiErrors {
    JSON_FORMAT_ERROR(100002, "JSON格式错误", "服务器出小差了~"),
    SYSTEM_ERROR(100003, "%s", "服务器繁忙，请稍后重试"),
    SERVER_ERROR(10000018, "%s", "%s");

    private int result;
    private String errMsg;
    private String error;
    private String[] args;
    private String[] emArgs;

    BaseErrors(int result, String error, String errMsg) {
        this.result = result;
        this.error = error;
        this.errMsg = errMsg;
    }


    public BaseErrors setArgs(String... args) {
        this.args = args;
        return this;
    }

    public BaseErrors setEmArgs(String... emargs) {
        this.emArgs = emargs;
        return this;
    }

    public BaseErrors setResult(int result) {
        this.result = result;
        return this;
    }

    @Override
    public int getResult() {
        return this.result;
    }

    @Override
    public String getError() {

        if (args == null) {
            return this.error;
        } else {
            return String.format(error, args);
        }

    }

    @Override
    public String getErrMsg() {
        if (emArgs == null) {
            return this.errMsg;
        } else {
            return String.format(errMsg, emArgs);
        }
    }
}
