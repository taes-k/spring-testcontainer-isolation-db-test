package com.taes.kim.dbisolationtest.user.repository;

import com.taes.kim.dbisolationtest.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>
{
}
