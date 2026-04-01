package com.dsa.dsa_social_api.service;

import com.dsa.dsa_social_api.repository.InMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    @Autowired
    private InMemoryStore store;

    public void follow(Long userId, Long targetId) {
        store.graph.follow(userId, targetId);
    }

    public List<Long> getFollowing(Long userId) {
        return store.graph.getFollowing(userId);
    }

    public List<Long> getFollowers(Long userId) {
        return store.graph.getFollowers(userId);
    }

    public List<Long> getSuggestFollowers(Long userId) {
        return store.graph.suggest(userId);
    }
}
