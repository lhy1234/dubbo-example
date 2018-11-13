package com.lhy.service.impl;

import com.lhy.service.pojo.Product;
import com.lhy.service.user.ProductFacade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("productFacade")
public class ProductFacadeImpl implements ProductFacade {


    @Override
    public List<Product> getProducts() {
        Product pro1 = new Product();
        pro1.setId(1);
        pro1.setProductName("手机");
        Product pro2= new Product();
        pro2.setId(2);
        pro2.setProductName("电脑");
        List<Product> list = new ArrayList<>();
        list.add(pro1);
        list.add(pro2);
        return list;
    }
}
