package com.usc.ranshop.service.impl;


import com.usc.ranshop.exception.MyException;
import com.usc.ranshop.dao.CartDao;
import com.usc.ranshop.dao.OrderDao;
import com.usc.ranshop.dao.ProductInOrderDao;
import com.usc.ranshop.dao.UserDao;
import com.usc.ranshop.beans.Cart;
import com.usc.ranshop.beans.OrderMain;
import com.usc.ranshop.beans.ProductInOrder;
import com.usc.ranshop.beans.User;
import com.usc.ranshop.enums.ResultEnum;
import com.usc.ranshop.service.CartService;
import com.usc.ranshop.service.ProductService;
import com.usc.ranshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

/**
 * Created By Zhu Lin on 3/11/2018.
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    ProductService productService;
    @Autowired
    OrderDao orderDao;
    @Autowired
    UserDao userDao;

    @Autowired
    ProductInOrderDao productInOrderDao;
    @Autowired
    CartDao cartDAO;
    @Autowired
    UserService userService;

    @Override
    public Cart getCart(User user) {
        return user.getCart();
    }

    @Override
    @Transactional
    public void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user) {
        Cart finalCart = user.getCart();
        productInOrders.forEach(productInOrder -> {
            Set<ProductInOrder> set = finalCart.getProducts();
            Optional<ProductInOrder> old = set.stream().filter(e -> e.getProductId().equals(productInOrder.getProductId())).findFirst();
            ProductInOrder prod;
            if (old.isPresent()) {
                prod = old.get();
                prod.setCount(productInOrder.getCount() + prod.getCount());
            } else {
                prod = productInOrder;
                prod.setCart(finalCart);
                finalCart.getProducts().add(prod);
            }
            productInOrderDao.save(prod);
        });
        cartDAO.save(finalCart);

    }

    @Override
    @Transactional
    public void delete(String itemId, User user) {
        if(itemId.equals("") || user == null) {
            throw new MyException(ResultEnum.ORDER_STATUS_ERROR);
        }

        var op = user.getCart().getProducts().stream().filter(e -> itemId.equals(e.getProductId())).findFirst();
        op.ifPresent(productInOrder -> {
            productInOrder.setCart(null);
            productInOrderDao.deleteById(productInOrder.getId());
        });
    }

    @Override
    @Transactional
    public void checkout(User user) {
        // Creat an order
        OrderMain order = new OrderMain(user);
        orderDao.save(order);

        // clear cart's foreign key & set order's foreign key& decrease stock
        user.getCart().getProducts().forEach(productInOrder -> {
            productInOrder.setCart(null);
            productInOrder.setOrderMain(order);
            productService.decreaseStock(productInOrder.getProductId(), productInOrder.getCount());
            productInOrderDao.save(productInOrder);
        });

    }
}
