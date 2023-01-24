package com.usc.ranshop.service.impl;


import com.usc.ranshop.exception.MyException;
import com.usc.ranshop.dao.OrderDao;
import com.usc.ranshop.dao.ProductInOrderDao;
import com.usc.ranshop.dao.ProductInfoDao;
import com.usc.ranshop.dao.UserDao;
import com.usc.ranshop.beans.OrderMain;
import com.usc.ranshop.beans.ProductInOrder;
import com.usc.ranshop.beans.ProductInfo;
import com.usc.ranshop.enums.OrderStatusEnum;
import com.usc.ranshop.enums.ResultEnum;
import com.usc.ranshop.service.OrderService;
import com.usc.ranshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created By Zhu Lin on 3/14/2018.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Autowired
    UserDao userDao;
    @Autowired
    ProductInfoDao productInfoDao;
    @Autowired
    ProductService productService;
    @Autowired
    ProductInOrderDao productInOrderDao;

    @Override
    public Page<OrderMain> findAll(Pageable pageable) {
        return orderDao.findAllByOrderByOrderStatusAscCreateTimeDesc(pageable);
    }

    @Override
    public Page<OrderMain> findByStatus(Integer status, Pageable pageable) {
        return orderDao.findAllByOrderStatusOrderByCreateTimeDesc(status, pageable);
    }

    @Override
    public Page<OrderMain> findByBuyerEmail(String email, Pageable pageable) {
        return orderDao.findAllByBuyerEmailOrderByOrderStatusAscCreateTimeDesc(email, pageable);
    }

    @Override
    public Page<OrderMain> findByBuyerPhone(String phone, Pageable pageable) {
        return orderDao.findAllByBuyerPhoneOrderByOrderStatusAscCreateTimeDesc(phone, pageable);
    }

    @Override
    public OrderMain findOne(Long orderId) {
        OrderMain orderMain = orderDao.findByOrderId(orderId);
        if(orderMain == null) {
            throw new MyException(ResultEnum.ORDER_NOT_FOUND);
        }
        return orderMain;
    }

    @Override
    @Transactional
    public OrderMain finish(Long orderId) {
        OrderMain orderMain = findOne(orderId);
        if(!orderMain.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            throw new MyException(ResultEnum.ORDER_STATUS_ERROR);
        }

        orderMain.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        orderDao.save(orderMain);
        return orderDao.findByOrderId(orderId);
    }

    @Override
    @Transactional
    public OrderMain cancel(Long orderId) {
        OrderMain orderMain = findOne(orderId);
        if(!orderMain.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            throw new MyException(ResultEnum.ORDER_STATUS_ERROR);
        }

        orderMain.setOrderStatus(OrderStatusEnum.CANCELED.getCode());
        orderDao.save(orderMain);

        // Restore Stock
        Iterable<ProductInOrder> products = orderMain.getProducts();
        for(ProductInOrder productInOrder : products) {
            ProductInfo productInfo = productInfoDao.findByProductId(productInOrder.getProductId());
            if(productInfo != null) {
                productService.increaseStock(productInOrder.getProductId(), productInOrder.getCount());
            }
        }
        return orderDao.findByOrderId(orderId);

    }
}
