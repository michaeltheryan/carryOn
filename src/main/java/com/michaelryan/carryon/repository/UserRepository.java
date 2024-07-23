package com.michaelryan.carryon.repository;

import com.michaelryan.carryon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface provides the contract for Spring Data Abstraction to
 * implement - this enables abstraction that hides application logic from
 * non-necessary access
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.email NOT LIKE '.com'")
    List<User> findNotComUsers();

    @Query("SELECT u FROM User u WHERE u.email = '.gov'")
    List<User> findAllGovUsers();

    @Query("SELECT u FROM User u WHERE u.created < '2024-06-01'")
    List<User> findAllUsersBeforeJune();
}
