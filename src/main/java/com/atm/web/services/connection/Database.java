package com.atm.web.services.connection;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.atm.web.services.model.Product;
import com.atm.web.services.model.Setting;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan({ "com.atm.web.services.service",
		"com.atm.web.services.model", "com.atm.web.services.controller",  
		"com.atm.web.services.repository" }) })
public class Database {

	private static final Log log = LogFactory.getLog(Database.class);

	public Properties hibernateProperties() {
		Properties props = new Properties();
		props.put(Environment.FORMAT_SQL, "true");
		props.put(Environment.HBM2DDL_AUTO, "validate");
		props.put(Environment.SHOW_SQL, "false");
		return props;
	}

	@Primary
	@Bean(name = "dataSource", destroyMethod = "close")
	public static DataSource dataSource() {
		HikariConfig config = new HikariConfig();

		String springProfilesActive = System.getenv("SPRING_PROFILES_ACTIVE");
		log.info("SPRING_PROFILES_ACTIVE: " + springProfilesActive);
		if (StringUtils.isNotBlank(springProfilesActive)) {

			// Cloud
			log.info("TDP_DB_DRIVER: " + System.getenv("TDP_DB_DRIVER"));
			config.setDriverClassName(System.getenv("TDP_DB_DRIVER"));

			log.info("TDP_DB_URL: " + System.getenv("TDP_DB_URL"));
			config.setJdbcUrl(System.getenv("TDP_DB_URL"));
			log.info("TDP_DB_USR: " + System.getenv("TDP_DB_USR"));
			config.setUsername(System.getenv("TDP_DB_USR"));
			log.info("TDP_DB_PW: " + System.getenv("TDP_DB_PW"));
			config.setPassword(System.getenv("TDP_DB_PW"));
			log.info("TDP_DB_MIN_POOL: " + System.getenv("TDP_DB_MIN_POOL"));
			config.setMinimumIdle(Integer.parseInt(System.getenv("TDP_DB_MIN_POOL")));
			log.info("TDP_DB_MAX_POOL: " + System.getenv("TDP_DB_MAX_POOL"));
			config.setMaximumPoolSize(Integer.parseInt(System.getenv("TDP_DB_MAX_POOL")));
			log.info("FIN DE LA CONF DATASOURCE");
		} else {
			config.setDriverClassName("org.postgresql.Driver");
			config.setUsername("admin_hogar@app-hogar");
			config.setPassword("Atm#1787");
			config.setJdbcUrl(
					"jdbc:postgresql://app-hogar.postgres.database.azure.com:5432/postgres?currentSchema=public&sslmode=require&characterEncoding=utf-8&ApplicationName=Local");
			config.setMinimumIdle(Integer.parseInt("2"));
			config.setMaximumPoolSize(Integer.parseInt("3"));
		}

		config.setConnectionTestQuery("SELECT current_timestamp");

		config.setConnectionTimeout(Integer.parseInt("20000"));
		config.setIdleTimeout(Integer.parseInt(("30000")));

		return new HikariDataSource(config);
	}

}
