package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;
import java.util.Set;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    String matchingPasswordForUN(String username);
    User createUser(String email, String un, String password);
    Set<String> allCurrUserNames();
}
