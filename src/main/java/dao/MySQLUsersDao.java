package dao;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLUsersDao {

    private Connection connection;

//    public MySQLAdsDao(Config config){
//
//        try{
//            DriverManager.registerDriver(new Driver());
//            this.connection = DriverManager.getConnection(
//                    config.getUrl(),
//                    config.getUser(),
//                    config.getPassword()
//            );
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
//
//    }

}
