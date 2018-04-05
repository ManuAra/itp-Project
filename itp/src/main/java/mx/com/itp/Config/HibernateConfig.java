package mx.com.itp.Config;

import static org.hibernate.cfg.AvailableSettings.C3P0_ACQUIRE_INCREMENT;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS;
import static org.hibernate.cfg.AvailableSettings.C3P0_MIN_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_TIMEOUT;
import static org.hibernate.cfg.AvailableSettings.DRIVER;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.PASS;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.URL;
import static org.hibernate.cfg.AvailableSettings.USER;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import mx.com.itp.entity.FileManager;
import mx.com.itp.entity.ProjectFile;
import mx.com.itp.entity.UserDetail;
import mx.com.itp.entity.UserExperience;
import mx.com.itp.entity.UserProject;
import mx.com.itp.entity.UserSkill;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:hibernate-application.properties")
@ComponentScans(value = { @ComponentScan("mx.com.itp.service"),
					@ComponentScan("mx.com.itp.dao")	})
public class HibernateConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean  = new LocalSessionFactoryBean();
		
		Properties props = new Properties();
		
		//JDBC Components
		props.put(DRIVER, env.getProperty("mysql.driver"));
		props.put(URL, env.getProperty("mysql.jdbcUrl"));
		props.put(USER, env.getProperty("mysql.username"));
		props.put(PASS, env.getProperty("mysql.password"));
		
		//Hibernate properties
		props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
	    props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
	    
	    //C3PO properties
	    props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
	    props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
	    props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
	    props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
	    props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
	    
	    factoryBean.setHibernateProperties(props);
	    factoryBean.setAnnotatedClasses(UserDetail.class, 
	    								   UserProject.class,
	    								   ProjectFile.class,
	    								   UserExperience.class,
	    								   UserSkill.class);
	    
	    return factoryBean;
	}
	
	@Bean
	  public HibernateTransactionManager getTransactionManager() {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	    transactionManager.setSessionFactory(getSessionFactory().getObject());
	    return transactionManager;
	  }
	
}
