package com.lhy.user.service;

import com.lhy.user.model.User;

import java.util.List;

public interface IUserService {


    public User getById(Integer id);


    public List<User> findByCustom(User user);
}
