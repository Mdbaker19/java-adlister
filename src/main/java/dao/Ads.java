package dao;

import models.Ad;

import java.util.List;

public interface Ads {
    List<Ad> all();
    Long insert(Ad ad);
    Ad getAdById(long id);
    List<Ad> byUser(int id);
    int findUserId(String userName);
}
