package io.novatec.userservice.controller;

import io.novatec.userservice.api.NotFoundException;
import io.novatec.userservice.api.entity.User;
import io.novatec.userservice.service.UserService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  // GET
  @GetMapping("/users")
  public List<User> getAllUsers() {
    log.info("Receieved GET request to /users");
    return userService.getAllUsers();
  }

  @GetMapping("/users/{userId}")
  public User getUserById(@PathVariable Integer userId) throws NotFoundException {
    log.info("Receieved GET request to /users/{}", userId);
    var userOptional = userService.getUserById(userId);

    return userOptional.orElseThrow(NotFoundException::new);
  }

  // POST
  @PostMapping("/users")
  public User registerUser(@RequestBody User user) {
    log.info("Received POST request to /users with requestBody {}", user);
    return userService.addOrUpdateUser(user);
  }

  // PUT
  @PutMapping("/users/{userId}")
  public User editUser(@PathVariable Integer userId, @RequestBody User user) {
    log.info("Received PUT request to /users/{} with requestBody {}", userId, user);
    user.setUserId(userId);
    return userService.addOrUpdateUser(user);
  }

  // DELETE
  @DeleteMapping("/users/{userId}")
  public ResponseEntity deleteUser(@PathVariable Integer userId) {
    log.info("Received DELETE request to /users/{}", userId);
    userService.deleteUserById(userId);

    return ResponseEntity.ok().build();
  }
}
