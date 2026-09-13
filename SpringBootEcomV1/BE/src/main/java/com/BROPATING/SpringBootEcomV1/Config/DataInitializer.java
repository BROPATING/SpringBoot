package com.BROPATING.SpringBootEcomV1.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
public class DataInitializer {

    @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);

        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        // Explicitly points to your file inside the package structure
        populator.addScript(new ClassPathResource("com/BROPATING/SpringBootEcomV1/Config/defaultData.sql"));

        initializer.setDatabasePopulator(populator);
        return initializer;
    }
}