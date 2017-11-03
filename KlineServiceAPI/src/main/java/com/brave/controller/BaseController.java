package com.brave.controller;

import java.util.List;
import java.util.Map;

/**
 * 2017年7月4日 08:34:02
 * Created by Administrator on 2017/7/4.
 */
public class BaseController
{
    private static final String ERROR_CODE = "error";
    private static final String ERROR_MSG = "调用接口失败";
    
    private static final String SUCCESS_CODE = "success";
    private static final String SUCCESS_MSG = "调用接口成功";

    /**
     * 2017年7月4日 08:32:48
     * 返回成功信息   
     * @param param
     * @param objList
     * @return
     */
    public Map<String, Object> success(Map<String, Object> param, List<?> objList)
    {
        param.put("ResultCode", SUCCESS_CODE);
        param.put("ResultMsg", SUCCESS_MSG);
        param.put("ResultData", objList);
        return param;
    }

    /**
     * 2017年7月4日 08:33:53
     * 返回失败信息
     * @param param
     * @param msg
     * @return
     */
    public Map<String, Object> fail(Map<String, Object> param, String msg)
    {
        param.put("ResultCode", ERROR_CODE);
        param.put("ResultMsg", ERROR_MSG);
        param.put("ResultReason", msg);
        return param;
    }
    
    
    
    
}