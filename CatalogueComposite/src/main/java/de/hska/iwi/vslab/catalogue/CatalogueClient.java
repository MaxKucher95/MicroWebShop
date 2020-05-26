package de.hska.iwi.vslab.catalogue;

import java.util.LinkedHashMap;
import java.util.Map;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@Component
@RestController
public class CatalogueClient {
    private final Map<Long, Category> categoryCache = new LinkedHashMap<Long, Category>();
    private final Map<Long, Product> productCache = new LinkedHashMap<Long, Product>();

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(commandProperties = { @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2") })
    @RequestMapping(value = "/catalogue/{categoryID}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCategory(Long categoryID) {
        LinkedHashMap<Long, Product> products = restTemplate.getForObject("http://product-service/products", LinkedHashMap.class);

        for(Map.Entry<Long, Product> entry : products.entrySet()) {
            Product product = entry.getValue();
            if(product.getCategory() == categoryID) {
                restTemplate.delete("http://product-service/product/" + product.getId(), Product.class);
            }
        }

        restTemplate.delete("http://category-service/category/" + categoryID, Category.class);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public Category getCategoryCache(Long categoryID) {
        return categoryCache.getOrDefault(categoryID, new Category());
    }

    public Product getProductCache(Long productID) {
        return productCache.getOrDefault(productID, new Product());
    }
}