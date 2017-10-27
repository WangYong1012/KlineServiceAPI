package com.brave.repository;

import com.brave.entity.JtDataDictionary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/7 0007.
 */
public interface JtDataDictionaryRepository extends JpaRepository<JtDataDictionary, String>
{
    /**
     * 2017年7月7日 10:17:12
     * 使用父类编码获取到下级的字段数据
     * @param parentID
     * @return
     */
    List<JtDataDictionary> findByParentID(String parentID);

    /**
     * 2017年7月7日 11:02:10
     * 使用字典编码查询出对应的结果集
     * @param zdbm
     * @return
     */
    List<JtDataDictionary> findByZdbm(String zdbm);
    
    
}