package io.novatec.userservice.service;

import io.novatec.userservice.api.entity.User;
import io.novatec.userservice.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public Optional<User> getUserById(int userId) {
    return userRepository.findById(userId);
  }

  @Override
  public User addOrUpdateUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public void deleteUserById(int userId) {
    userRepository.deleteById(userId);
  }
}
