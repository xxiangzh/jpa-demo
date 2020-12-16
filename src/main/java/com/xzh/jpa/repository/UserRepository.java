package com.xzh.jpa.repository;

import com.xzh.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findFirstByUsername(String username);

    @Query("FROM User WHERE username=:username")
    User findByQuery(@Param("username") String username);

    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findByUsernameWithJpql(@Param("username") String username);

    @Query(value = "SELECT u.* FROM t_user u WHERE u.username = :username", nativeQuery = true)
    User findByUsernameWithSql(@Param("username") String username);

    @Query(value = "SELECT u.* FROM t_user u WHERE u.username = ?1", nativeQuery = true)
    User findByUsernameWithSqlNo(String username);

    @Query(value = "SELECT u.* FROM t_user u WHERE (:#{#user.username} IS NULL OR u.username =:#{#user.username}) AND (:#{#user.deleteFlag} IS NULL OR u.delete_flag =:#{#user.deleteFlag})", nativeQuery = true)
    List<User> findByEntityWithSql(@Param("user") User user);
}