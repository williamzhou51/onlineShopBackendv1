package com.usc.ranshop.service.impl;

import com.usc.ranshop.beans.ProductInfo;
import com.usc.ranshop.enums.ProductStatusEnum;
import com.usc.ranshop.exception.MyException;
import com.usc.ranshop.dao.ProductInfoDao;
import com.usc.ranshop.service.CategoryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductInfoDao productInfoDao;

    @Mock
    private CategoryService categoryService;

    private ProductInfo productInfo;

    @Before
    public void setUp() {
        productInfo = new ProductInfo();
        productInfo.setProductId("1");
        productInfo.setProductStock(10);
        productInfo.setProductStatus(1);
    }

    @Test
    public void increaseStockTest() {
        when(productInfoDao.findByProductId(productInfo.getProductId())).thenReturn(productInfo);

        productService.increaseStock("1", 10);

        Mockito.verify(productInfoDao, Mockito.times(1)).save(productInfo);
    }

    @Test(expected = MyException.class)
    public void increaseStockExceptionTest() {
        productService.increaseStock("1", 10);
    }

    @Test
    public void decreaseStockTest() {
        when(productInfoDao.findByProductId(productInfo.getProductId())).thenReturn(productInfo);

        productService.decreaseStock("1", 9);

        Mockito.verify(productInfoDao, Mockito.times(1)).save(productInfo);
    }

    @Test(expected = MyException.class)
    public void decreaseStockValueLesserEqualTest() {
        when(productInfoDao.findByProductId(productInfo.getProductId())).thenReturn(productInfo);

        productService.decreaseStock("1", 10);
    }

    @Test(expected = MyException.class)
    public void decreaseStockExceptionTest() {
        productService.decreaseStock("1", 10);
    }

    @Test
    public void offSaleTest() {
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());

        when(productInfoDao.findByProductId(productInfo.getProductId())).thenReturn(productInfo);

        productService.offSale("1");

        Mockito.verify(productInfoDao, Mockito.times(1)).save(productInfo);
    }

    @Test(expected = MyException.class)
    public void offSaleStatusDownTest() {
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());

        when(productInfoDao.findByProductId(productInfo.getProductId())).thenReturn(productInfo);

        productService.offSale("1");
    }

    @Test(expected = MyException.class)
    public void offSaleProductNullTest() {
        when(productInfoDao.findByProductId(productInfo.getProductId())).thenReturn(null);

        productService.offSale("1");
    }

    @Test
    public void onSaleTest() {
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());

        when(productInfoDao.findByProductId(productInfo.getProductId())).thenReturn(productInfo);

        productService.onSale("1");

        Mockito.verify(productInfoDao, Mockito.times(1)).save(productInfo);
    }

    @Test(expected = MyException.class)
    public void onSaleStatusUpTest() {
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());

        when(productInfoDao.findByProductId(productInfo.getProductId())).thenReturn(productInfo);

        productService.onSale("1");
    }

    @Test(expected = MyException.class)
    public void onSaleProductNullTest() {
        when(productInfoDao.findByProductId(productInfo.getProductId())).thenReturn(null);

        productService.offSale("1");
    }

    @Test
    public void updateTest() {
        productService.update(productInfo);

        Mockito.verify(productInfoDao, Mockito.times(1)).save(productInfo);
    }

    @Test(expected = MyException.class)
    public void updateProductStatusBiggerThenOneTest() {
        productInfo.setProductStatus(2);

        productService.update(productInfo);
    }

    @Test
    public void deleteTest() {
        when(productInfoDao.findByProductId(productInfo.getProductId())).thenReturn(productInfo);

        productService.delete("1");

        Mockito.verify(productInfoDao, Mockito.times(1)).delete(productInfo);
    }

    @Test(expected = MyException.class)
    public void deleteProductNullTest() {
        productService.delete("1");
    }
}
