package com.lhy.service.user;


import com.lhy.service.pojo.User;

import java.util.List;

public interface UserFacade {

    public User getById(int id);

    public int addUser(User user);

    public List<User> getUsers();
}
