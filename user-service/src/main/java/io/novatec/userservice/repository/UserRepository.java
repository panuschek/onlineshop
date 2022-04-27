package io.novatec.userservice.repository;

import io.novatec.userservice.api.entity.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
  List<User> findAll();
}
