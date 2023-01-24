package com.usc.ranshop.service;

import com.usc.ranshop.entity.ProductInOrder;
import com.usc.ranshop.entity.User;

/**
 * Created By Zhu Lin on 1/3/2019.
 */
public interface ProductInOrderService {
    void update(String itemId, Integer quantity, User user);
    ProductInOrder findOne(String itemId, User user);
}
