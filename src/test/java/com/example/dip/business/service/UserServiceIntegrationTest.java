package com.example.dip.business.service;

import com.example.dip.dataaccess.UserRepository;
import com.example.dip.dataaccess.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  // Uses real H2 instead of an embedded DB
@Transactional  // Ensures rollback after each test
class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testCreateUser() {
        User user = new User("Alice", "alice@example.com");
        User savedUser = userService.createUser(user);

        assertNotNull(savedUser.getId());
        assertEquals("Alice", savedUser.getName());
        assertEquals("alice@example.com", savedUser.getEmail());
    }

    @Test
    void testGetAllUsers() {

        List<User> users = userService.getAllUsers();

        assertEquals(2, users.size());
    }

    @Test
    void testGetUserById() {
        User user = userRepository.save(new User( "David", "david@example.com"));

        Optional<User> foundUser = userService.getUserById(user.getId());

        assertTrue(foundUser.isPresent());
        assertEquals("David", foundUser.get().getName());
    }

    @Test
    void testDeleteUser() {
        User user = userRepository.save(new User( "Eve", "eve@example.com"));
        Long userId = user.getId();

        userService.deleteUser(userId);

        Optional<User> deletedUser = userRepository.findById(userId);
        assertFalse(deletedUser.isPresent());
    }
}
