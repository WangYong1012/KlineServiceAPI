package com.brave.controller;

import com.alibaba.fastjson.JSONObject;
import com.brave.entity.*;
import com.brave.repository.*;
import com.brave.utils.CombineDataUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.*;

@Api("K线图服务配置API")
@Controller
@RequestMapping("/kline")
public class KLineController extends BaseController
{
    private static final Logger log = Logger.getLogger(KLineController.class);
    //一分钟获取
    @Autowired
    private TTradeMarketOneRepository tTradeMarketOneRepository;
    //五分钟获取
    @Autowired
    private TTradeMarketFiveRepository tTradeMarketFiveRepository;
    //十五分钟获取
    @Autowired
    private TTradeMarketFifteenRepository tTradeMarketFifteenRepository;
    //三十分钟获取
    @Autowired
    private TTradeMarketThirtyRepository tTradeMarketThirtyRepository;
    //一小时获取
    @Autowired
    private TTradeMarketHourRepository tTradeMarketHourRepository;
    //四小时获取
    //日线获取
    @Autowired
    private TTradeMarketDayRepository tTradeMarketDayRepository;
    //三日线获取
    //周线获取
    @Autowired
    private TTradeMarketWeekRepository tTradeMarketWeekRepository;
    //月线获取
    @Autowired
    private TTradeMarketMonthRepository tTradeMarketMonthRepository;
    
    @ApiOperation("插入测试数据使用")
    @ResponseBody
    @RequestMapping(value = "/insert", method = RequestMethod.GET, produces = "application/json")
    public String insertData(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            ClassLoader loader = ClassLoader.getSystemClassLoader();
            InputStream is = loader.getSystemResourceAsStream("data.json");
            System.out.println(is.available());
            
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return "读取文件成功";
    }
    
    
    
    
    
    /**
     * 2017年11月1日 09:33:50
     * K线图查询
     * @param type
     * @param request
     * @param response
     * @return
     */
    @ApiOperation("Kline实时获取")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "时间类型", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "symbol", value = "货币类型", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "needTickers", value = "时钟类型", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "数据大小", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "since", value = "开始时间", required = false, dataType = "string", paramType = "query")
    })
    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.GET, produces = "application/json")
    public JSONObject query(@Param("type") String type, @Param("symbol") String symbol, 
                            @Param("needTickers") String needTickers, @Param("size") String size, 
                            @Param("since") String since,
                            HttpServletRequest request, HttpServletResponse response)
    {
        log.info("Query Params : [ type = " + type + ", symbol = " + symbol + ", needTickers = " + needTickers 
            + ", size = " + size + ", since = " + since + " ]");
        Map<String, Object> param = new HashMap<String, Object>();
        try
        {
            List<? extends BaseEntity> tradeMarketList = null;
            switch (type.trim())
            {
                case "1min" : //一分钟K线
                    tradeMarketList = tTradeMarketOneRepository.findAll();
                    break;
                case "5min" : //五分钟K线
                    tradeMarketList = tTradeMarketFiveRepository.findAll();
                    break;
                case "15min" : //十五分钟K线
                    tradeMarketList = tTradeMarketFifteenRepository.findAll();
                    break;
                case "30min" : //三十分钟K线
                    tradeMarketList = tTradeMarketThirtyRepository.findAll();
                    break;
                case "1hour" : //一小时K线
                    tradeMarketList = tTradeMarketHourRepository.findAll();
                    break;
                case "4hour" : //四小时K线
                    
                    break;
                case "1day" : //一天K线
                    tradeMarketList = tTradeMarketDayRepository.findAll();
                    break;
                case "3day" : //三天K线
                    
                    break;
                case "1month" :
                    tradeMarketList = tTradeMarketMonthRepository.findAll();
                    break;
                case "1week" : //一周K线
                    tradeMarketList = tTradeMarketWeekRepository.findAll();
                    break;
                default: //默认（未带参数）不执行任何查询直接返回空集合
                    tradeMarketList = new ArrayList<>();
                    break;
            }
            //转化成为Json
            return JSONObject.parseObject(CombineDataUtil.combineData(tradeMarketList));
        }catch(Exception ex)
        {
            ex.printStackTrace();
            return JSONObject.parseObject(ex.getMessage());
        }
    }
}