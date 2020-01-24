package com.seu.xyd.logic;

import com.seu.xyd.data.XYDErrors;
import com.seu.xyd.servlet.XYDWebParam;
import com.tn17.logic.LogicException;
import com.tn17.mysql.DBProcessException;

public class LogicUtil {
    public static final LogicException createException(XYDErrors err) {
        return new LogicException(err.getErrCode(), err.getErrMsg());
    }
        
    public static final LogicException createException(XYDErrors err, String appendMessage) {
        return new LogicException(err.getErrCode(), err.getErrMsg() + " " + appendMessage);
    }
        
    public static final LogicException createException(XYDErrors err, XYDWebParam param) {
        return new LogicException(err.getErrCode(), err.getErrMsg() + " " + param.getName());
    }
        
    public static final LogicException createByDBException(DBProcessException e) {
        return new LogicException(XYDErrors.DB_UNEXPECTED_ERROR.getErrCode(),
        		XYDErrors.DB_UNEXPECTED_ERROR.getErrMsg() + e.getMessage());
    }
}
