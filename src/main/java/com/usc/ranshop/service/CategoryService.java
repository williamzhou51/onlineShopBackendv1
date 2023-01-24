package com.usc.ranshop.service;

import com.usc.ranshop.beans.ProductCategory;

import java.util.List;

/**
 * Created By Zhu Lin on 3/10/2018.
 */
public interface CategoryService {

    List<ProductCategory> findAll();

    ProductCategory findByCategoryType(Integer categoryType);

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);


}
