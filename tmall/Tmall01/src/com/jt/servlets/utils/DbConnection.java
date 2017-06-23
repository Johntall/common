package com.jt.servlets.utils;

import java.beans.PropertyVetoException;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DbConnection {
    private static volatile DbConnection instance = null;

    private ComboPooledDataSource dataSource;

    private DbConnection() {
        if (dataSource == null) {
            dataSource = new ComboPooledDataSource();
            try {
                dataSource.setJdbcUrl("jdbc:mariadb://127.0.0.1:3306/tmall");
                dataSource.setUser("jttest");
                dataSource.setPassword("9933");
                dataSource.setDriverClass("org.mariadb.jdbc.Driver");
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        }

    }

    public static DbConnection getInstance() {
        if (instance == null) {
            synchronized (DbConnection.class) {
                if (instance == null) {
                    instance = new DbConnection();
                }
            }
        }
        return instance;
    }

    public QueryRunner getQueryRunner() {
        return new QueryRunner(dataSource);
    }


}


