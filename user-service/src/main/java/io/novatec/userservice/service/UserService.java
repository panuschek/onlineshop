package io.novatec.userservice.service;

import io.novatec.userservice.api.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
  List<User> getAllUsers();
  Optional<User> getUserById(int userId);
  User addOrUpdateUser(User user);
  void deleteUserById(int userId);
}
