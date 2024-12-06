package com.sankuai.inf.leaf.server.config;

import com.sankuai.inf.leaf.exception.InitException;
import com.sankuai.inf.leaf.service.SegmentService;
import com.sankuai.inf.leaf.service.SnowflakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class LoadService {

    @Autowired
    LeafSpringBootProperties properties;

    @Bean
    @ConditionalOnProperty(prefix = "leaf.segment", name = "enable",havingValue = "true")
    public SegmentService loadSegment() throws SQLException, InitException {
        return  new SegmentService(properties.getSegment().getUrl(),properties.getSegment().getDriver(),
                properties.getSegment().getUsername(),properties.getSegment().getPassword());
    }

    @Bean
    @ConditionalOnProperty(prefix = "leaf.snowflake", name = "enable",havingValue = "true")
    public SnowflakeService loadSnowflake() throws InitException {
        return new SnowflakeService(properties.getSnowflake().getAddress(),properties.getSnowflake().getPort());
    }




}
