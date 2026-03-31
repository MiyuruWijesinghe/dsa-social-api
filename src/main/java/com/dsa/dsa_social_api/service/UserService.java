package com.dsa.dsa_social_api.service;

import com.dsa.dsa_social_api.model.User;
import com.dsa.dsa_social_api.repository.InMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

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


    public List<User> searchByName(String name) {
        List<User> result = new ArrayList<>();

        for (User user : store.users.values()) {
            if (user.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(user);
            }
        }
        return result;
    }
}
