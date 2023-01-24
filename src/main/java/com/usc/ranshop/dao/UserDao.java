package com.usc.ranshop.dao;


import com.usc.ranshop.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created By Zhu Lin on 3/13/2018.
 */

public interface UserDao extends JpaRepository<User, String> {
    User findByEmail(String email);
    Collection<User> findAllByRole(String role);

}
