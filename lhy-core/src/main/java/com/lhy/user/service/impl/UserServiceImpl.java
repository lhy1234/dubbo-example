package com.lhy.user.service.impl;

import com.lhy.user.dao.UserMapper;
import com.lhy.user.enums.UserStatusEnum;
import com.lhy.user.model.User;
import com.lhy.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(Integer id) {

        return userMapper.selectById(id);
    }

    @Override
    public List<User> findByCustom(User user) {
        return null;
    }
}
