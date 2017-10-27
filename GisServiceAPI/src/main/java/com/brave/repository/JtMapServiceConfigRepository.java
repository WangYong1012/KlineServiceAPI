package com.brave.repository;

import com.brave.entity.JtMapServiceConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/4.
 */
public interface JtMapServiceConfigRepository extends JpaRepository<JtMapServiceConfig, String>
{
    
    List<JtMapServiceConfig> findByLxbs(String lxbs);
    
    
}