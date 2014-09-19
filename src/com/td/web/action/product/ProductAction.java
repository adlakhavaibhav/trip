package com.td.web.action.product;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import com.td.web.action.BaseAction;
import com.td.pact.service.ProductService;
import com.td.domain.Product;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: Feb 8, 2013
 * Time: 12:13:58 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ProductAction extends BaseAction {

    @Autowired
    private ProductService productService;

    @DontValidate
    @DefaultHandler
    public Resolution addToCart() {

        Product product = getProductService().getProductById("1");
        System.out.println("test");

        return null;
    }

    public ProductService getProductService() {
        return productService;
    }
}
