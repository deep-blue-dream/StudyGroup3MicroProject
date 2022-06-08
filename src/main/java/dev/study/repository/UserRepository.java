package dev.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.study.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsUserByUserMail (String email);

}
