package com.youfan.utils;

import java.sql.*;
import java.util.Map;
import java.util.Set;

public class DorisDbUtils {

    public static void  insertdata(String tablename , Map<String,Object> data,Set<String> intFieldSet){
        String resultsql = "insert into ";
        resultsql += tablename+ "(";
        String valueSql = "(";
        Set<Map.Entry<String,Object>> sets = data.entrySet();
        for(Map.Entry<String,Object> entry:sets){
            String fieldName = entry.getKey();
            Object valueString = entry.getValue();
            if(valueString.getClass().getName().equals("java.lang.")){

            }
            resultsql += fieldName +",";
            if(intFieldSet.contains(fieldName)){
                valueSql += valueString+",";
            }else {
                valueSql += "'"+valueString + "',";
            }

        }
        resultsql = resultsql.substring(0,resultsql.length()-1)+")";
        valueSql = valueSql.substring(0,valueSql.length()-1)+")";
        resultsql = resultsql + " values "+ valueSql;
        System.out.println("dorios db 插sql sql = "+resultsql);
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            statement.execute(resultsql);
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    private static Connection getConnection(String address,String driverClassName,String username,String password){
        try {
            Class.forName(driverClassName);
            Connection connection = DriverManager.getConnection(address,username,password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private static Connection getConnection(String address){
        try {
            String driverClassName = "com.mysql.jdbc.Driver";
            Class.forName(driverClassName);
            String username = "youfan";
            String password = "youfan";
            Connection connection = DriverManager.getConnection(address,username,password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Connection getConnection(){
        try {
            String address = "jdbc:mysql://192.168.37.163:9030/youfan_db";
            String driverClassName = "com.mysql.jdbc.Driver";
            Class.forName(driverClassName);
            String username = "youfan";
            String password = "youfan";
            Connection connection = DriverManager.getConnection(address,username,password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet queryBySql(String address, String driverClassName, String username, String password, String sql){
            Connection connection = getConnection(address, driverClassName, username, password);
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static ResultSet queryBySql(String address,  String sql){
        String driverClassName = "com.mysql.jdbc.Driver";
        String username = "youfan";
        String password = "youfan";
        return  queryBySql(address, driverClassName, username, password, sql);
    }

    public static ResultSet queryBySql(String sql){
        String address = "jdbc:mysql://192.168.37.163:9030/youfan_db";
        String driverClassName = "com.mysql.jdbc.Driver";
        String username = "youfan";
        String password = "youfan";
        return  queryBySql(address, driverClassName, username, password, sql);
    }


}
