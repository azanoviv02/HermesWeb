package com.hermes.web.config;

import com.hermes.Application;
import com.hermes.core.domain.accounts.AbstractAccount;
import com.hermes.core.domain.accounts.BasicAccount;
import com.hermes.core.domain.accounts.RepresentedAccount;
import com.hermes.core.domain.cargo.AbstractCargo;
import com.hermes.core.domain.cargo.Barrel;
import com.hermes.core.domain.cargo.Box;
import com.hermes.core.domain.employees.AbstractDriver;
import com.hermes.core.domain.employees.AbstractEmployee;
import com.hermes.core.domain.employees.BasicDriver;
import com.hermes.core.domain.hauls.AbstractHaul;
import com.hermes.core.domain.hauls.BasicHaul;
import com.hermes.core.domain.milestones.AbstractMilestone;
import com.hermes.core.domain.milestones.FinishMilestone;
import com.hermes.core.domain.milestones.StartMilestone;
import com.hermes.core.domain.orders.AbstractOrder;
import com.hermes.core.domain.orders.BasicOrder;
import com.hermes.core.domain.places.*;
import com.hermes.core.domain.vehicles.AbstractVehicle;
import com.hermes.core.domain.vehicles.BasicTruck;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ClassUtils;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = Application.class)
class JpaConfig {

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

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("useServerPrepStmts", "true");

        return new HikariDataSource(config);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);

        String entities = ClassUtils.getPackageName(Application.class);
        String converters = ClassUtils.getPackageName(Jsr310JpaConverters.class);
        entityManagerFactoryBean.setPackagesToScan(entities, converters);

        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, dialect);
        jpaProperties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, hbm2ddlAuto);
        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);

        sessionBuilder.addAnnotatedClasses(AbstractAccount.class);
        sessionBuilder.addAnnotatedClasses(BasicAccount.class);
        sessionBuilder.addAnnotatedClasses(RepresentedAccount.class);

        sessionBuilder.addAnnotatedClasses(AbstractPlace.class);
        sessionBuilder.addAnnotatedClasses(AbstractBase.class);
        sessionBuilder.addAnnotatedClasses(BasicCompanyBase.class);
        sessionBuilder.addAnnotatedClasses(BasicClientBase.class);
        sessionBuilder.addAnnotatedClasses(AbstractFix.class);
        sessionBuilder.addAnnotatedClasses(BasicFix.class);

        sessionBuilder.addAnnotatedClasses(AbstractMilestone.class);
        sessionBuilder.addAnnotatedClasses(StartMilestone.class);
        sessionBuilder.addAnnotatedClasses(FinishMilestone.class);

        sessionBuilder.addAnnotatedClasses(AbstractHaul.class);
        sessionBuilder.addAnnotatedClasses(BasicHaul.class);

        sessionBuilder.addAnnotatedClasses(AbstractEmployee.class);
        sessionBuilder.addAnnotatedClasses(AbstractDriver.class);
        sessionBuilder.addAnnotatedClasses(BasicDriver.class);

        sessionBuilder.addAnnotatedClasses(AbstractVehicle.class);
        sessionBuilder.addAnnotatedClasses(BasicTruck.class);

        sessionBuilder.addAnnotatedClasses(AbstractCargo.class);
        sessionBuilder.addAnnotatedClasses(Box.class);
        sessionBuilder.addAnnotatedClasses(Barrel.class);

        sessionBuilder.addAnnotatedClasses(AbstractOrder.class);
        sessionBuilder.addAnnotatedClasses(BasicOrder.class);

        System.out.println("Factory built!");
        return sessionBuilder.buildSessionFactory();
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(
                sessionFactory);

        return transactionManager;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
