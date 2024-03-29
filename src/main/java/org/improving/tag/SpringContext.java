package org.improving.tag;

import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
 import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Scanner;
//import java.util.Random;

//auto-wiring: follow the norms so developers don't need to write as many codes
@Configuration

@ComponentScan("org.improving.tag")//scan the package whose classes have a component and memorize it

public class SpringContext {
    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

        @Bean
        public DataSource createDataSource () {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/tag?serverTimezone=UTC");
            dataSource.setUsername("EmilyStacylocal");
            dataSource.setPassword("bootcamp2019Improving");
            return dataSource;
            //@Bean =>register the following line as a result in Spring
            //public Random getRandom() {return new Random();}
        }

        @Bean
        @Autowired
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate((dataSource));
        }

    }
