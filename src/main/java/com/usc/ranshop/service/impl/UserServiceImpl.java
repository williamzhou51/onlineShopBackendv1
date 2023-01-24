package com.usc.ranshop.service.impl;


import com.usc.ranshop.exception.MyException;
import com.usc.ranshop.dao.CartDao;
import com.usc.ranshop.dao.UserDao;
import com.usc.ranshop.beans.Cart;
import com.usc.ranshop.beans.User;
import com.usc.ranshop.enums.ResultEnum;
import com.usc.ranshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created By Zhu Lin on 3/13/2018.
 */
@Service
@DependsOn("passwordEncoder")
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserDao userDao;
    @Autowired
    CartDao cartDAO;

    @Override
    public User findOne(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public Collection<User> findByRole(String role) {
        return userDao.findAllByRole(role);
    }

    @Override
    @Transactional
    public User save(User user) {
        //register
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            User savedUser = userDao.save(user);

            // initial Cart
            Cart savedCart = cartDAO.save(new Cart(savedUser));
            savedUser.setCart(savedCart);
            return userDao.save(savedUser);

        } catch (Exception e) {
            throw new MyException(ResultEnum.VALID_ERROR);
        }

    }

    @Override
    @Transactional
    public User update(User user) {
        User oldUser = userDao.findByEmail(user.getEmail());
        oldUser.setPassword(passwordEncoder.encode(user.getPassword()));
        oldUser.setName(user.getName());
        oldUser.setPhone(user.getPhone());
        oldUser.setAddress(user.getAddress());
        return userDao.save(oldUser);
    }

}
