package com.michaelryan.carryon.repository;

import com.michaelryan.carryon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * This interface provides the contract for Spring Data Abstraction to
 * implement - this enables abstraction that hides application logic from
 * non-necessary access
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    List<User> findAllUsersByDomain(String domain);

    @Query("SELECT u FROM User u WHERE u.created > ?1")
    List<User> findAllUsersAfterDate(LocalDateTime date);

    @Query("SELECT u FROM User u WHERE u.created < ?1")
    List<User> findAllUsersBeforeDate(LocalDateTime date);
}
