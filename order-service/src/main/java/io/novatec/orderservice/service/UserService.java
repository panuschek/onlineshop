package io.novatec.orderservice.service;

import io.novatec.orderservice.entity.User;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "UserService", url = "http://localhost:8080")
public interface UserService {
  @RequestMapping(method = RequestMethod.GET, value = "/users")
  List<User> getUsers();

  @RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
  User getUserById(@PathVariable Integer userId);
}
