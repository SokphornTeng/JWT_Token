package com.SpringSecurity.My_Test.Practice_4.Repository;

import com.SpringSecurity.My_Test.Practice_4.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);
    Optional<User> findByUserName(String username);

}
