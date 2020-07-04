package com.hackathon.sailors.pregnancyaggregate.api.repo;

import com.hackathon.sailors.pregnancyaggregate.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByNameAndPassword(String name, String password);
}
