package com.usc.ranshop.dao;

import com.usc.ranshop.beans.ProductInOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By Zhu Lin on 3/14/2018.
 */
public interface ProductInOrderDao extends JpaRepository<ProductInOrder, Long> {

}
