package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/users")
public class MainController {

    @Autowired
    private UserRepository userRepository;
    
    @PostMapping
    public @ResponseBody ResponseEntity<User> addUser(@RequestBody User userDetails) {

        User u = new User();
        u.setEmail(userDetails.getEmail());
        u.setName(userDetails.getName());
        userRepository.save(u);
        return ResponseEntity.ok(u);
        
    }

    @PutMapping(path = "{id}")
    public @ResponseBody ResponseEntity<User> updateUser(@RequestBody User userDetails, @PathVariable(value = "id") Integer userId) {
        User existingUser = userRepository.findById(userId).orElseThrow();

        existingUser.setId(userDetails.getId());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setName(userDetails.getName());

        final User updatedUser = userRepository.save(existingUser);
        return ResponseEntity.ok(updatedUser);
        
    }

    // get list of all users
    @GetMapping
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable(value = "id") Integer userId) {
        userRepository.deleteById(userId);
    }


}
