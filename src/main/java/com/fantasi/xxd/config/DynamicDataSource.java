package com.fantasi.xxd.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 配置动态数据源
 * @author xxd
 * @date 2019/12/17 14:52
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDB();
    }
}
