package de.hska.iwi.vslab.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
  @Autowired
  private ProductRepo repo;

  @RequestMapping(value = "/products", method = RequestMethod.GET)
  public ResponseEntity<Iterable<Product>> getProducts() {
      Iterable<Product> allPolls = repo.findAll();
      return new ResponseEntity<>(allPolls, HttpStatus.OK);
  }

  @RequestMapping(value = "/products", method = RequestMethod.POST)
  public ResponseEntity<?> addProduct(@RequestBody Product product) {
      product = repo.save(product);
      return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(value = "/product/{productID}", method = RequestMethod.GET)
  public ResponseEntity<Product> getProduct(@PathVariable Long productId) {
      if(!repo.existsById(productId)) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

      Product product = repo.findById(productId).get();
      return new ResponseEntity<>(product, HttpStatus.OK);
  }

  @RequestMapping(value = "/product/{productID}", method = RequestMethod.PUT)
  public ResponseEntity<Product> putProduct(@PathVariable Long productId, @PathVariable String name, @PathVariable String details,
                                            @PathVariable double price, @PathVariable int category)
  {
      if(!repo.existsById(productId)) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

      Product prd = repo.findById(productId).get();
      prd.setName(name);
      prd.setDetails(details);
      prd.setPrice(price);
      prd.setCategory(category);
      repo.save(prd);
      return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(value = "/product/{productID}", method = RequestMethod.DELETE)
  public ResponseEntity<Product> deleteProduct(@PathVariable Long productId) {
      if(!repo.existsById(productId)) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

      repo.delete(repo.findById(productId).get());
      return new ResponseEntity<>(HttpStatus.OK);
  } 
}