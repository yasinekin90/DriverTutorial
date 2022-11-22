package utils;


import java.sql.*;

public class MyConnection {
    //url,username,password
    //Connection,statement


    Connection connection;
    Statement statement;
    String url;
    String username;
    String password;


    public MyConnection(String url,String username,String password){

        try {
            this.url=url;
            this.username=username;
            this.password=password;

            connection= DriverManager.getConnection(url, username, password);
            statement=connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ResultSet getResultSet(String sql){
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void tearDown(){
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
