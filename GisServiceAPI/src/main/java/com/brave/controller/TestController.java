package com.brave.controller;

import com.alibaba.fastjson.JSONObject;
import com.brave.entity.TestIndexDTO;
import com.brave.entity.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Api("测试DTO方法")
@RestController
@RequestMapping("/test")
public class TestController extends BaseController
{
    
    @ApiOperation("测试DTO首页")
    @ApiImplicitParam(name = "testIndexDTO", value = "首页传输实体", required = true, dataType = "TestIndexDTO")
    @RequestMapping(value = "/index", method = RequestMethod.POST, produces = "application/json")
    public String index(@RequestBody TestIndexDTO testIndexDTO)
    {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try
        {
            UserInfo user = new UserInfo();

            BeanUtils.copyProperties(testIndexDTO, user);
            
            
            System.out.println(JSONObject.toJSONString(testIndexDTO));
            System.out.println(JSONObject.toJSONString(user));
            
            convert(user, user);
            
            
            return JSONObject.toJSONString(success(resultMap, null));
        }catch(Exception ex)
        {
            ex.printStackTrace();
            return JSONObject.toJSONString(fail(resultMap, ex.getMessage()));
        }
    }
    
    public static void convert(Object source, Object target) throws NoSuchFieldException, IllegalAccessException
    {
        Class class_source = source.getClass();
        Class class_target = target.getClass();
        
        
        
        
        
        
    }
}