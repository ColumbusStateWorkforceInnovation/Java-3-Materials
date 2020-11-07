package edu.cscc.jdbc.exercise;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.util.Properties;

public class DataSourceFactory {

    public static final String MYSQL_DB_URL = "MYSQL_DB_URL";
    public static final String MYSQL_DB_USERNAME = "MYSQL_DB_USERNAME";
    public static final String MYSQL_DB_PASSWORD = "MYSQL_DB_PASSWORD";

    public static DataSource buildDataSource(Properties properties) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(properties.getProperty(MYSQL_DB_URL));
        dataSource.setUser(properties.getProperty(MYSQL_DB_USERNAME));
        dataSource.setPassword(properties.getProperty(MYSQL_DB_PASSWORD));

        return dataSource;
    }
}
