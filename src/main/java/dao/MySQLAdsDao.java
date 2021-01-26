package dao;

import com.mysql.cj.jdbc.Driver;
import models.Ad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{

    private Connection connection;

    public MySQLAdsDao(Config config){

        try{
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public List<Ad> all() {
        List<Ad> out = new ArrayList<>();
        String query = "SELECT * FROM ads";
        try{
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);

            while(rs.next()){
                out.add( new Ad(
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }


        } catch (SQLException e){
            e.printStackTrace();
        }

        return out;
    }

    @Override
    public Ad getAdById(long id){
        Ad ad = new Ad();
        String query = String.format("SELECT * FROM ads WHERE id = %d", id);

        try{

            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);

            if(rs.next()){
                ad.setId(rs.getInt("id"));
                ad.setDescription(rs.getString("description"));
                ad.setTitle(rs.getString("title"));
                ad.setUserId(rs.getInt("user_id"));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return ad;
    }

    @Override
    public Long insert(Ad ad) {
        String query = String.format("INSERT INTO ads (user_id, title, description) values (%d, '%s', '%s')", ad.getUserId(), ad.getTitle(), ad.getDescription());

        try{

            Statement stm = connection.createStatement();
            stm.executeUpdate(query);

        } catch (SQLException e){
            e.printStackTrace();
        }

        return ad.getId();
    }
}
