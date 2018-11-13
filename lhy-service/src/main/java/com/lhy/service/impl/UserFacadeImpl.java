package com.lhy.service.impl;

import com.lhy.service.pojo.User;
import com.lhy.service.user.UserFacade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userFacade")
public class UserFacadeImpl implements UserFacade {



    @Override
    public User getById(int id) {
        User u = new User();
        u.setId(id);
        u.setAge(18);
        u.setUsername("牛呗");
        return null;
    }

    @Override
    public int addUser(User user) {
        return 1;
    }

    @Override
    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        User u1 = new User();
        u1.setId(1);
        u1.setAge(18);
        u1.setUsername("牛呗");

        User u2 = new User();
        u2.setId(2);
        u2.setAge(19);
        u2.setUsername("西决");

        User u3 = new User();
        u3.setId(3);
        u3.setAge(20);
        u3.setUsername("wooubeibei");

        list.add(u1);
        list.add(u2);
        list.add(u3);

        return list;
    }
}
