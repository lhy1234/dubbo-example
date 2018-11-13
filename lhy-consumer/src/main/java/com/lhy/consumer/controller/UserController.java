package com.lhy.consumer.controller;




import com.lhy.service.pojo.Account;
import com.lhy.service.pojo.Product;
import com.lhy.service.pojo.User;
import com.lhy.service.user.AccountFacade;
import com.lhy.service.user.ProductFacade;
import com.lhy.service.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private ProductFacade productFacade;

    @Autowired
    private AccountFacade accountFacade;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @RequestMapping("/toHelloPage")
    public String toHelloPage(){
        return "hello";
    }


    @RequestMapping("/getUsers")
    public @ResponseBody List<User> getUsers(){
        List<User> list = userFacade.getUsers();
        return list;
    }

    @RequestMapping("/getProducts")
    public @ResponseBody List<Product> getProducts(){
        List<Product> list = productFacade.getProducts();
        return list;
    }

    @RequestMapping("/addAccount")
    public @ResponseBody String addAccount(){
        int k = accountFacade.addAccount(new Account());
        if(k==1){
            return "success";
        }else{
            return "fail";
        }

    }


}
