package lk.hotelManagement.backend.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
public class DBConfig {

    @Autowired
    private Environment env;

    @Bean(name = "reservation-named-param-jdbc")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("reservation-datasource") DataSource dataSource) throws PropertyVetoException {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean(name = "reservation-trasc-mgr")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("reservation-datasource") DataSource dataSource) throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "reservation-datasource")
    public DataSource popsaxonyDataSource() {

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(env.getProperty("reservation.jdbc.url"));
        config.setUsername(env.getProperty("reservation.jdbc.user"));
        config.setPassword(env.getProperty("reservation.jdbc.pass"));
        config.setMaximumPoolSize(Integer.parseInt(env.getProperty("reservation.jdbc.connectionPool")));
        //config.setMaxLifetime(1800000);
        config.setLeakDetectionThreshold(120000);
//        config.addDataSourceProperty("oracle.jdbc.timezoneAsRegion","false");
        return new HikariDataSource(config);
    }

    @Bean
    @ConditionalOnMissingBean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Logger logger(InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}
