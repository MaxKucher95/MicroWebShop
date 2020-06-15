package de.hska.iwi.vslab.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserRepo repo;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> getUsers() {
        Iterable<User> allPolls = repo.findAll();

        User user = new User();
        user.setFirstName("oauth");
        user.setLastName("lastName");
        user.setUserName("oauthuser");
        user.setPassword("oauthpassword");
        user.setRole("USER");
        repo.save(user);
        return new ResponseEntity<>(allPolls, HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User user) {
        user = repo.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        if(!repo.existsById(userId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        User user = repo.findById(userId).get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<User> putUser(
        @PathVariable Long userId,
        @PathVariable String firstName,
        @PathVariable String lastName, 
        @PathVariable String userName, 
        @PathVariable String userPassword,
        @PathVariable String role)
    {
        if(!repo.existsById(userId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        User user = repo.findById(userId).get();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserName(userName);
        user.setPassword(userPassword);
        user.setRole(role);
        repo.save(user);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable Long userId)
    {
        if(!repo.existsById(userId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repo.delete(repo.findById(userId).get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public ResponseEntity<User> login(@RequestParam(name = "username", required = true) String username,
        @RequestParam(name = "password", required = true) String password) {

      Iterable<User> users = repo.findAll();
      for(User u: users){
        if (u.getUserName().equals(username)) {
          if (u.getPassword().equals(password)) {
            return new ResponseEntity<>(u, HttpStatus.ACCEPTED);
          } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
          }
        }
      }

      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}