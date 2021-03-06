package com.avla.test.repositories;


import com.avla.test.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserById(Long userId);
    User findUserByEmailAndPassword(String email, String password);

}
