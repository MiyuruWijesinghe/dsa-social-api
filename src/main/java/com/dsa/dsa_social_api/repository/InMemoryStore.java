package com.dsa.dsa_social_api.repository;

import com.dsa.dsa_social_api.dsa.CustomQueue;
import com.dsa.dsa_social_api.dsa.CustomStack;
import com.dsa.dsa_social_api.dsa.Graph;
import com.dsa.dsa_social_api.dsa.LinkedListFeed;
import com.dsa.dsa_social_api.model.Comment;
import com.dsa.dsa_social_api.model.Job;
import com.dsa.dsa_social_api.model.Post;
import com.dsa.dsa_social_api.model.User;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryStore {

    public Map<Long, User> users = new HashMap<>();
    public Map<Long, Post> posts = new HashMap<>();

    // Stack for undo
    public CustomStack<Post> postStack = new CustomStack<>();

    // Queue
    public CustomQueue<Job> jobQueue = new CustomQueue<>();

    // Linked List
    public LinkedListFeed feed = new LinkedListFeed();

    // Graph
    public Graph graph = new Graph();

    // Root comments per post
    public Map<Long, List<Comment>> commentsByPost = new HashMap<>();
}
