package com.example._02jpa.repository;

import com.example._02jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Create with IntelliJ IDEA.
 *
 * @author JocularChao
 * @date 2023/11/8 20:45
 * @Description
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    default void getUserByUsername() {

    }


}
