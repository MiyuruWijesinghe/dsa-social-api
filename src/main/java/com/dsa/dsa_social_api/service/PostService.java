package com.dsa.dsa_social_api.service;

import com.dsa.dsa_social_api.model.Post;
import com.dsa.dsa_social_api.repository.InMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private InMemoryStore store;

    public Post create(Post post) {
        store.posts.put(post.getId(), post);
        return post;
    }

    public List<Post> getAll(String sort) {
        List<Post> list = new ArrayList<>(store.posts.values());

        if ("likes".equals(sort)) {
            list.sort((a, b) -> b.getLikes() - a.getLikes());
        }

        return list;
    }
}
