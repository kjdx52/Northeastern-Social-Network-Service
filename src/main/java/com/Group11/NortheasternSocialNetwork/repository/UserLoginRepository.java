package com.Group11.NortheasternSocialNetwork.repository;
import com.Group11.NortheasternSocialNetwork.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
    // Custom queries or methods if needed
}