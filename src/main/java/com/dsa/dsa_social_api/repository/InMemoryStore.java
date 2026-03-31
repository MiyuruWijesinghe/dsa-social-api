package com.dsa.dsa_social_api.repository;

import com.dsa.dsa_social_api.dsa.CustomQueue;
import com.dsa.dsa_social_api.dsa.CustomStack;
import com.dsa.dsa_social_api.model.Job;
import com.dsa.dsa_social_api.model.Post;
import com.dsa.dsa_social_api.model.User;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class InMemoryStore {

    public Map<Long, User> users = new HashMap<>();
    public Map<Long, Post> posts = new HashMap<>();

    // Stack for undo
    public CustomStack<Post> postStack = new CustomStack<>();

    // Queue
    public CustomQueue<Job> jobQueue = new CustomQueue<>();
}
