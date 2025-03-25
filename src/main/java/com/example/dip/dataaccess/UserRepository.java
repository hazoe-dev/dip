package com.example.dip.dataaccess;

import com.example.dip.dataaccess.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
