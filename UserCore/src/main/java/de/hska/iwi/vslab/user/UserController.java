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
    public ResponseEntity<Iterable<User>> getUser() {
        Iterable<User> allPolls = repo.findAll();
        return new ResponseEntity<>(allPolls, HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User user) {
        user = repo.save(user);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        if(!repo.existsById(userId)) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        User user = repo.findById(userId).get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<User> putUser(@PathVariable Long userId, @PathVariable String userName, @PathVariable String userPassword)
    {
        if(!repo.existsById(userId)) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        User user = repo.findById(userId).get();
        user.setId(userId);
        user.setName(userName);
        user.setPassword(userPassword);
        repo.save(user);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}