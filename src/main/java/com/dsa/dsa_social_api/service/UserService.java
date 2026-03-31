package com.dsa.dsa_social_api.service;

import com.dsa.dsa_social_api.model.User;
import com.dsa.dsa_social_api.repository.InMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private InMemoryStore store;

    public User create(User user) {
        store.users.put(user.getId(), user);
        return user;
    }

    public User get(Long id) {
        return store.users.get(id);
    }
}
