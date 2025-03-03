package com.yash.tenantmanagement.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages = "com.yash.tenantmanagement")
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class SpringRootConfig {
	@Value("${database.driver}")
	private String driver;
	
	@Value("${database.url}")
	private String url;
	
    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    @Value("${hibernate.dialect}")
    private String dialect;

    @Value("${hibernate.show_sql}")
    private String showSql;

    @Value("${hibernate.format_sql}")
    private String formatSql;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;

    @Bean
	public BasicDataSource getDataSource() {
		//database related information
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		
		return basicDataSource;
	}
    
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
    	LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    	sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan("com.yash.tenantmanagement");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
    
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sf) {
    	HibernateTransactionManager txManager = new HibernateTransactionManager();
    	txManager.setSessionFactory(sf);
    	return txManager;
    }
    
    @Bean
    public Properties hibernateProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.show_sql", showSql);
        properties.put("hibernate.format_sql", formatSql);
        properties.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);
           return properties;
    }
    
    
	
}
