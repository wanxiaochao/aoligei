package com.aoligei.sub_data_table.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.db0.url}")
    private String url0;
    @Value("${spring.datasource.db0.username}")
    private String username0;
    @Value("${spring.datasource.db0.password}")
    private String password0;
    @Value("${spring.datasource.db0.driverClassName}")
    private String driverClassName0;

    @Value("${spring.datasource.db1.url}")
    private String url1;
    @Value("${spring.datasource.db1.username}")
    private String username1;
    @Value("${spring.datasource.db1.password}")
    private String password1;
    @Value("${spring.datasource.db1.driverClassName}")
    private String driverClassName1;


    @Bean
    public DataSource dataSource(){

        DruidDataSource ds0 = new DruidDataSource();
        ds0.setUrl(url0);
        ds0.setUsername(username0);
        ds0.setPassword(password0);
        ds0.setDriverClassName(driverClassName0);
        DruidDataSource ds1 = new DruidDataSource();
        ds1.setUrl(url1);
        ds1.setUsername(username1);
        ds1.setPassword(password1);
        ds1.setDriverClassName(driverClassName1);

        Map<String,DataSource> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put("ds0",ds0);
        dataSourceMap.put("ds1",ds1);

        //ShardingDataSourceFactory.createDataSource(dataSourceMap,)

        return ds0;


    }

}
