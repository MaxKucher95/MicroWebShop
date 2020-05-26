package de.hska.iwi.vslab.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
  @Autowired
  private CategoryRepo repo;

  @RequestMapping(value = "/category", method = RequestMethod.GET)
  public ResponseEntity<Iterable<Category>> getCategories() {
      Iterable<Category> allPolls = repo.findAll();
      return new ResponseEntity<>(allPolls, HttpStatus.OK);
  }

  @RequestMapping(value = "/category", method = RequestMethod.POST)
  public ResponseEntity<?> addCategory(@RequestBody Category category) {
      category = repo.save(category);
      return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(value = "/category/{categoryID}", method = RequestMethod.GET)
  public ResponseEntity<Category> getCategory(@PathVariable Long categoryID) {
      if(!repo.existsById(categoryID)) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

      Category category = repo.findById(categoryID).get();
      return new ResponseEntity<>(category, HttpStatus.OK);
  }

  @RequestMapping(value = "/category/{categoryID}", method = RequestMethod.PUT)
  public ResponseEntity<Category> putCategory(
      @PathVariable Long categoryID,
      @PathVariable String name)
  {
      if(!repo.existsById(categoryID)) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

      Category category = repo.findById(categoryID).get();
      category.setName(name);
      repo.save(category);
      return new ResponseEntity<>(null, HttpStatus.OK);
  }

  @RequestMapping(value = "/category/{categoryID}", method = RequestMethod.DELETE)
  public ResponseEntity<Category> deleteCategory(@PathVariable Long categoryID) {
    if(!repo.existsById(categoryID)) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    Category category = repo.findById(categoryID).get();
    repo.delete(category);
    return new ResponseEntity<>(null, HttpStatus.OK);
  }

}