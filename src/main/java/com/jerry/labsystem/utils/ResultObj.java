package com.jerry.labsystem.utils;

import lombok.Data;

@Data
public class ResultObj {
    private Integer code;
    private String msg;
    private Object data;

    public ResultObj(Integer code) {
        this.code = code;
    }

    public ResultObj(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultObj(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static final ResultObj ADD_SUCCESS = new ResultObj(SysConstant.CODE_SUCCESS, SysConstant.ADD_SUCCESS);
    public static final ResultObj ADD_ERROR = new ResultObj(SysConstant.CODE_ERROR, SysConstant.ADD_ERROR);

    public static final ResultObj UPDATE_SUCCESS = new ResultObj(SysConstant.CODE_SUCCESS, SysConstant.UPDATE_SUCCESS);
    public static final ResultObj UPDATE_ERROR = new ResultObj(SysConstant.CODE_ERROR, SysConstant.UPDATE_ERROR);

    public static final ResultObj DELETE_SUCCESS = new ResultObj(SysConstant.CODE_SUCCESS, SysConstant.DELETE_SUCCESS);
    public static final ResultObj DELETE_ERROR = new ResultObj(SysConstant.CODE_ERROR, SysConstant.DELETE_ERROR);
}
