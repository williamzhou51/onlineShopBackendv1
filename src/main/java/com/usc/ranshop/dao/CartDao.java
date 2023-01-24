package com.usc.ranshop.dao;

import com.usc.ranshop.beans.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By Zhu Lin on 1/2/2019.
 */

public interface CartDao extends JpaRepository<Cart, Integer> {
}
