package com.usc.ranshop.service;

import com.usc.ranshop.beans.ProductInOrder;
import com.usc.ranshop.beans.Cart;
import com.usc.ranshop.beans.User;

import java.util.Collection;

/**
 * Created By Zhu Lin on 3/10/2018.
 */
public interface CartService {
    Cart getCart(User user);

    void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

    void delete(String itemId, User user);

    void checkout(User user);
}
