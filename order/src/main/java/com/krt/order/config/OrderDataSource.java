/*
 * Copyright (C) KRT, 2019 by kiterunner_t
 * TO THE HAPPY FEW
 */

package com.krt.order.config;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.krt.order.OrderConst;


@Configuration
@MapperScan(
        basePackages = OrderConst.MapperPackage,
        sqlSessionFactoryRef = "lineSqlSessionFactory"
)
public class OrderDataSource {
    static final String MAPPER_LOCATION = "classpath:sql/*.xml";
    static final String CONFIG_LOCATION = "classpath:mybatis.xml";

    @Value("${spring.datasource.url}") String url;
    @Value("${spring.datasource.username}") String username;
    @Value("${spring.datasource.password}") String password;


    @Bean(name = "lineDataSource")
    @Primary
    public DataSource lineDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);

        return new com.alibaba.fescar.rm.datasource.DataSourceProxy(druidDataSource);
    }


    @Bean(name = "lineTransactionManager")
    @Primary
    public DataSourceTransactionManager lineTransactionManager() {
        return new DataSourceTransactionManager(lineDataSource());
    }


    @Bean(name = "lineSqlSessionFactory")
    @Primary
    public SqlSessionFactory lineSqlSessionFactory(
            @Qualifier("lineDataSource") DataSource lineDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(lineDataSource);

        Resource[] mapperLocations = new PathMatchingResourcePatternResolver()
                .getResources(OrderDataSource.MAPPER_LOCATION);

        List<Resource> rs = new LinkedList<>();
        rs.addAll(Arrays.asList(mapperLocations));

        sessionFactory.setMapperLocations(rs.toArray(new Resource[rs.size()]));

        Resource r = new PathMatchingResourcePatternResolver().getResource(CONFIG_LOCATION);
        sessionFactory.setConfigLocation(r);
        return sessionFactory.getObject();
    }


    @Bean(name = "lineSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("lineSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

