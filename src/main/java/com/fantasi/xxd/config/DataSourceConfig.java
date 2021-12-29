package com.fantasi.xxd.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xxd
 * @date 2019/12/17 14:43
 */
@Configuration
@MapperScan("com.fantasi.xxd.dao")
public class DataSourceConfig {

    /**
     * db1 数据库源配置
     * @return
     */
    @Bean("db1")
    @ConfigurationProperties(prefix = "config.datasource.db1")
    public DataSource db1Source(){
        return DataSourceBuilder.create().build();
    }

    /**
     * db2 数据库源配置
     * @return
     */
    @Bean("db2")
    @ConfigurationProperties(prefix = "config.datasource.db2")
    public DataSource db2Source(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 动态数据库配置
     * @return
     */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource(){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //默认数据源
        dynamicDataSource.setDefaultTargetDataSource(db1Source());

        //配置多数据源
        Map<Object, Object> dsMap = new HashMap<>(5);
        dsMap.put("db1", db1Source());
        dsMap.put("db2", db2Source());

        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

//    @Bean("sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource")DataSource dynamicDataSource, MybatisProperties mybatisProperties) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dynamicDataSource);
//        bean.setConfiguration(mybatisProperties.getConfiguration());
////        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResource("classpath*:/mapper/**/**Mapper.xml"));
////        bean.setTypeAliasesPackage("com.fantasi.xxd.**.entity.**;com.fantasi.xxd.**.vo.**");
//        return bean.getObject();
//    }

    /**
     * 配置@Transactional注解事务
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dynamicDataSource());
    }
//    public PlatformTransactionManager transactionManager(@Qualifier("dynamicDataSource")DataSource dynamicDataSource){
//        return new DataSourceTransactionManager(dynamicDataSource);
//    }
}
