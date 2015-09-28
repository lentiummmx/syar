package mx.com.vepormas.syar.web.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import mx.com.vepormas.syar.web.Application;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = Application.class)
class JpaConfig implements TransactionManagementConfigurer {

    @Value("${dataSource.driverClassName}")
    private String driver;
    @Value("${dataSource.url}")
    private String url;
    @Value("${dataSource.username}")
    private String username;
    @Value("${dataSource.password}")
    private String password;
    @Value("${hibernate.dialect}")
    private String dialect;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;
    @Value("${dataSource.jndi}")
    private String jndi;

    @Bean
    public DataSource configureDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
	
	@Bean
	public DataSource jndiDataSource() {
		final JndiDataSourceLookup jndiDataSourceLookup = new JndiDataSourceLookup();
		jndiDataSourceLookup.setResourceRef(true);
		DataSource jndiDataSource = jndiDataSourceLookup.getDataSource(jndi);
		return jndiDataSource;
	}
	
	private JpaVendorAdapter jpaVendorAdapter() {
		EclipseLinkJpaVendorAdapter eclipseLinkJpaVendorAdapter = new EclipseLinkJpaVendorAdapter();
		eclipseLinkJpaVendorAdapter.setGenerateDdl(true);
		eclipseLinkJpaVendorAdapter.setShowSql(true);
		return eclipseLinkJpaVendorAdapter;
	}
	
	private Properties jpaProperties() {
		Properties jpaProperties = new Properties();

		jpaProperties.put("eclipselink.deploy-on-startup", "true");
		jpaProperties.put("eclipselink.ddl-generation", "create-or-extend-tables");
//		jpaProperties.put("eclipselink.ddl-generation", "drop-and-create-tables");
		jpaProperties.put("eclipselink.ddl-generation.output-mode", "database");
		jpaProperties.put("eclipselink.logging.level.sql", "FINE");
		jpaProperties.put("eclipselink.logging.parameters", "true");
		jpaProperties.put("eclipselink.weaving", "static");
		jpaProperties.put("eclipselink.weaving.lazy", "true");
		jpaProperties.put("eclipselink.weaving.internal", "true");
		jpaProperties.put("eclipselink.logging.level", "SEVERE");
		jpaProperties.put("eclipselink.jdbc.batch-writing", "JDBC");
		jpaProperties.put("eclipselink.jdbc.batch-writing.size", "1000");
        jpaProperties.put("eclipselink.jdbc.cache-statements","true");
        jpaProperties.put("eclipselink.jdbc.cache-statements.size","100");
        jpaProperties.put("eclipselink.cache.shared.default","false");
        jpaProperties.put("eclipselink.flush-clear.cache","Drop");
        jpaProperties.put("eclipselink.cache.size.default","5000");
        jpaProperties.put("eclipselink.target-database","PostgreSQL");

		return jpaProperties;
	}

    @Bean(name="entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean configureEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.cm.vacunas.web");
//        entityManagerFactoryBean.setDataSource(configureDataSource());
        entityManagerFactoryBean.setDataSource(jndiDataSource());

//        Properties jpaProperties = new Properties();
//        jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, dialect);
//        jpaProperties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, hbm2ddlAuto);
//        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        entityManagerFactoryBean.setJpaProperties(jpaProperties());

        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new JpaTransactionManager();
    }

	@Bean(name = "transactionManager")
	public JpaTransactionManager getTransactionManager() {
		JpaTransactionManager manager = new JpaTransactionManager();
		// ...
		return manager;
	}
}
