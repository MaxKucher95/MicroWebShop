package de.hska.iwi.vslab.catalogue;

import java.util.LinkedHashMap;
import java.util.Map;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CatalogueClient {
    private final Map<Long, Category> categoryCache = new LinkedHashMap<Long, Category>();
    private final Map<Long, Product> productCache = new LinkedHashMap<Long, Product>();

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "deleteCategoryCache", commandProperties = {
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2") })
    public void deleteCategory(Long categoryID) {
        Iterable<Product> products = restTemplate.getForObject("http://product-service/products", Iterable.class);
        while(products.iterator().hasNext()) {
            Product product = products.iterator().next();
            if(product.getCategory() == categoryID) {
                restTemplate.delete("http://prduct-service/product/" + product.getId(), Product.class);
            }
        }
        restTemplate.delete("http://category-service/category/" + categoryID, Category.class);
    }

    public Category getCategoryCache(Long categoryID) {
        return categoryCache.getOrDefault(categoryID, new Category());
    }

    public Product getProductCache(Long productID) {
        return productCache.getOrDefault(productID, new Product());
    }
}