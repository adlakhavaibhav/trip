package com.td.impl.dao;

import org.springframework.stereotype.Repository;

import com.td.domain.Product;
import com.td.pact.dao.ProductDao;

@Repository
public class ProductDaoImpl extends BaseDaoImpl implements ProductDao {

    public Product getProductById(String productId) {
        return get(Product.class, productId);
    }
}
