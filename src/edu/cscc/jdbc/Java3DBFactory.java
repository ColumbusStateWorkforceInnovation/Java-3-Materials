package edu.cscc.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.util.Properties;

public class Java3DBFactory {
    private static final String MYSQL_DB_URL = "MYSQL_DB_URL";
    private static final String MYSQL_DB_USERNAME = "MYSQL_DB_USERNAME";
    private static final String MYSQL_DB_PASSWORD = "MYSQL_DB_PASSWORD";

    public static MysqlDataSource buildDataSource() {
        Properties properties = buildConnectionProperties();

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(properties.getProperty(MYSQL_DB_URL));
        dataSource.setUser(properties.getProperty(MYSQL_DB_USERNAME));
        dataSource.setPassword(properties.getProperty(MYSQL_DB_PASSWORD));

        return dataSource;
    }

    private static Properties buildConnectionProperties() {
        Properties properties = new Properties();
        properties.setProperty(MYSQL_DB_URL, "jdbc:mysql://localhost:3306/java_3_db");
        properties.setProperty(MYSQL_DB_USERNAME, "root");
        properties.setProperty(MYSQL_DB_PASSWORD, "password");

        return properties;
    }
}
