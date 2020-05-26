package de.hska.iwi.vslab.product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
  @Autowired
  private ProductRepo repo;

  @RequestMapping(value = "/products", method = RequestMethod.GET)
  public ResponseEntity<List<Product>> getProducts() {
      List<Product> list = new ArrayList<>();
      repo.findAll().forEach(e -> list.add(e));
      return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
  }

  @RequestMapping(value = "/products", method = RequestMethod.POST)
  public ResponseEntity<?> addProduct(@RequestBody Product product) {
      product = repo.save(product);
      return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(value = "/product/{productID}", method = RequestMethod.GET)
  public ResponseEntity<Product> getProduct(@PathVariable Long productID) {
      if(!repo.existsById(productID)) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

      Product product = repo.findById(productID).get();
      return new ResponseEntity<>(product, HttpStatus.OK);
  }

  @RequestMapping(value = "/product/{productID}/{name}/{details}/{price}/{category}", method = RequestMethod.PUT)
  public ResponseEntity<Product> putProduct(@PathVariable Long productID, @PathVariable String name, @PathVariable String details,
                                            @PathVariable double price, @PathVariable int category)
  {
      if(!repo.existsById(productID)) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

      Product prd = repo.findById(productID).get();
      prd.setName(name);
      prd.setDetails(details);
      prd.setPrice(price);
      prd.setCategory(category);
      repo.save(prd);
      return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(value = "/product/{productID}", method = RequestMethod.DELETE)
  public ResponseEntity<Product> deleteProduct(@PathVariable Long productID) {
      if(!repo.existsById(productID)) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

      repo.delete(repo.findById(productID).get());
      return new ResponseEntity<>(HttpStatus.OK);
  } 
}