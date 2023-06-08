package kz.bitlab.techorda.techboot2.beans;

import kz.bitlab.techorda.techboot2.dbconnect.DBConnector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

@Configuration
public class beanConfig {
    @Bean
    public DBConnector connection(){
        DBConnector dbConnector=new DBConnector("jdbc:mysql://localhost:3306/techbootdb", "root", "");
        return dbConnector;

    }
}
