package dev.study.service;

import dev.study.model.User;

import java.util.List;

public interface UserService {


    List<User> findAll();

    User save(User user);
}
