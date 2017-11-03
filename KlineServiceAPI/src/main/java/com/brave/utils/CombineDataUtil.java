package com.brave.utils;

import com.alibaba.fastjson.JSONObject;
import com.brave.entity.BaseEntity;
import com.brave.entity.KLineBaseEntity;
import org.springframework.beans.BeanUtils;

import java.util.*;

public class CombineDataUtil
{


    /**
     * 2017年11月1日 10:27:04
     * 组装数据需要用到的实体类
     * @param tradeList
     * @return
     */
    public static String combineData(List<? extends BaseEntity> tradeList)
    {
        Map<String, Object> innerMap = new HashMap<String, Object>();
        Map<String, Object> outerMap = new HashMap<String, Object>();
        innerMap.put("contractUnit", "BGC");
        innerMap.put("USDCNY", 6.9064);
        List<List<Object>> outerList = new ArrayList<List<Object>>();
        KLineBaseEntity baseEntity = new KLineBaseEntity();
        for (Object trade : tradeList)
        {
            BeanUtils.copyProperties(trade, baseEntity);
            LinkedList<Object> innerList = new LinkedList<Object>();
            innerList.add(baseEntity.getTimel());
            innerList.add(baseEntity.getOpenprice());
            innerList.add(baseEntity.getHighprice());
            innerList.add(baseEntity.getLowprice());
            innerList.add(baseEntity.getCloseprice());
            innerList.add(baseEntity.getTurnover());
            outerList.add(innerList);
        }
        innerMap.put("data", outerList);
        innerMap.put("marketName", "BGC");
        innerMap.put("moneyType", "CNY");
        innerMap.put("symbol", "BGC");
        outerMap.put("datas", innerMap);
        outerMap.put("des", "");
        outerMap.put("isSuc", true);
        outerMap.put("cachetime", System.currentTimeMillis());
        return JSONObject.toJSONString(outerMap);
    }
    
    
}
