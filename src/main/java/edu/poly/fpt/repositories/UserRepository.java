package edu.poly.fpt.repositories;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.fpt.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	List<User> findByUsernameLikeOrderByUsername(String username);
	public User findByUsername(String username);
}
