package com.td.pact.dao;

import com.td.domain.Product;

public interface ProductDao extends BaseDao{

    
    public Product getProductById(String productId);
}
