package com.village.soa.service.domain.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenwei18 on 2016/8/25.
 */
public class BaseResult implements Serializable {

    private static final long serialVersionUID = -916254239820953837L;
    /**
     * 是否成功
     */
    private boolean success = false;
    /**
     * 结果码
     */
    private int resultCode;
    /**
     * 错误信息 （包括入参）
     */
    private String errorMsg;

    private Map<String,Object> result = new HashMap<String,Object>();

    public BaseResult(){}

    public BaseResult(boolean success, String errorMsg, int resultCode){
        this.success = success;
        this.errorMsg = errorMsg;
        this.resultCode = resultCode;
    }

    public Object addDefaultModel(String key, Object obj) {
        return getResult().put(key,obj);
    }

    @Override
    public String toString() {
        return "ResultBase{" +
                "success=" + success +
                ", resultCode=" + resultCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

	public Map<String,Object> getResult() {
		return result;
	}

	public void setResult(Map<String,Object> result) {
		this.result = result;
	}
}
