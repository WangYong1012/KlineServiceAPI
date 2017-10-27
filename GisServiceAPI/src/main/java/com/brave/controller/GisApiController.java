package com.brave.controller;

import com.alibaba.fastjson.JSONObject;
import com.brave.entity.JtDataDictionary;
import com.brave.entity.JtMapServiceConfig;
import com.brave.repository.JtDataDictionaryRepository;
import com.brave.repository.JtMapServiceConfigRepository;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2017年7月4日 11:15:36
 * 地图配置信息查询控制器
 * Created by Administrator on 2017/7/4.
 */
@Api("地图配置信息API")
@RequestMapping("/gis/config")
@RestController
public class GisApiController extends BaseController
{
    @Autowired
    private JtMapServiceConfigRepository repository;
    @Autowired
    private JtDataDictionaryRepository dictRepository;
    //日志记录类
    private static final Logger log = Logger.getLogger(GisApiController.class);
    /**
     * 2017年7月4日 11:14:32
     * 获取地图配置列表
     * @param request
     * @param response
     * @return
     */
    @ApiOperation("获取地图配置信息列表")
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public String list(HttpServletRequest request, HttpServletResponse response)
    {
        //定义返回信息
        Map<String, Object> param = new HashMap<String, Object>();
        try
        {
            List<JtMapServiceConfig> mapConfigList = repository.findAll();
            return JSONObject.toJSONString(success(param, this.constructorMap(mapConfigList)));
        }catch(Exception ex)
        {
            //出现异常时，把异常信息返回到接口内容中，便于排查问题
            ex.printStackTrace();
            return JSONObject.toJSONString(fail(param, ex.getMessage()));
        }
    }

    /**
     * 2017年7月7日 10:17:30
     * 获取当前的数据字典极其对应的子类数据字典
     * @param parentCode
     * @return
     */
    @ApiOperation("通过字典编码获取当前节点及其子节点的字典数据")
    @ApiImplicitParam(name = "parentCode", value = "字典编码", required = true, dataType = "string", paramType = "path")
    @ResponseBody
    @RequestMapping(value = "/listDict/{parentCode}", method = RequestMethod.GET, produces = "application/json")
    public String getDictByParentId(@PathVariable("parentCode") String parentCode)
    {
        Map<String, Object> param = new HashMap<String, Object>();
        try
        {
            List<JtDataDictionary> resultList = new ArrayList<JtDataDictionary>(20);
            //使用字典编码进行查询
            List<JtDataDictionary> parentDict = dictRepository.findByZdbm(parentCode);
            if(null != parentDict && 0 < parentDict.size())
            {
                resultList.add(parentDict.get(0));
                String parentId = parentDict.get(0).getFid();
                List<JtDataDictionary> childDictList = dictRepository.findByParentID(parentId);
                if(null != childDictList && 0 < childDictList.size())
                {
                    resultList.addAll(childDictList);
                }
            }
            return JSONObject.toJSONString(success(param, resultList));
        }catch(Exception ex)
        {
            ex.printStackTrace();
            log.error(ex.getMessage());
            return JSONObject.toJSONString(fail(param, ex.getMessage()));
        }
    }

    /**
     * 2017年7月7日 11:19:15
     * 使用类型标识查询出对应的记录
     * @param lxbs
     * @return
     */
    @ApiOperation("通过字典编码获取当前节点及其子节点的字典数据")
    @ApiImplicitParam(name = "lxbs", value = "类型标识", required = true, dataType = "string", paramType = "path")
    @ResponseBody
    @RequestMapping(value = "/listByLxbs/{lxbs}", method = RequestMethod.GET, produces = "application/json")
    public String listByType(@PathVariable("lxbs") String lxbs)
    {
        Map<String, Object> param = new HashMap<String, Object>();
        try
        {
            List<JtMapServiceConfig> mapConfigList = repository.findByLxbs(lxbs);
            //集合逻辑处理
            return JSONObject.toJSONString(success(param, this.constructorMap(mapConfigList)));
        }catch(Exception ex)
        {
            ex.printStackTrace();
            return JSONObject.toJSONString(fail(param, ex.getMessage()));
        }
    }
    
    private List<Map<String, Object>> constructorMap(List<JtMapServiceConfig> mapConfigList)
    {
        List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>(20);
        if(null != mapConfigList && mapConfigList.size() > 0) {
            for (JtMapServiceConfig config : mapConfigList) {
                Map<String, Object> resultMap = new HashMap<String, Object>();
                StringBuilder url = new StringBuilder();
                url.append("http://").append(config.getIp()).append(":")    //IP拼接
                        .append(config.getDkh())                            //端口号拼接
                        .append("/arcgis/rest/services/")                   //固定路径拼接
                        .append(config.getFwmc())                           //服务名称拼接
                        .append("/")
                        .append(config.getFwgnlx().trim())
                        .append("/");                             //固定路径拼接
                if (null != config.getTcid() && config.getTcid().length() > 0)
                {
                    url.append(config.getTcid());                          //图层ID拼接
                }
                resultMap.put("url", url.toString());
                resultMap.put("sftjtckz", config.getSftjtckz());
                resultMap.put("dtfwmc", config.getDtfwmc());
                resultMap.put("dtfwpzlx", config.getDtfwpzlx());
                resultMap.put("fwlx", config.getFwlx());
                resultMap.put("tcxh", config.getTcxh());
                resultMap.put("lxbs", config.getLxbs());
                resultMap.put("xzqbs", config.getXzqbs());
                resultMap.put("dtdwmk", config.getDtdwmk());
                returnList.add(resultMap);
            }
        }
        return returnList;
    }
}