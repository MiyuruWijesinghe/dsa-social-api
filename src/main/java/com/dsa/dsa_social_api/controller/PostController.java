package com.dsa.dsa_social_api.controller;

import com.dsa.dsa_social_api.model.Post;
import com.dsa.dsa_social_api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService service;

    @PostMapping
    public Post create(@RequestBody Post post) {
        return service.create(post);
    }

    @GetMapping
    public List<Post> get(@RequestParam(required = false) String sort) {
        return service.getAll(sort);
    }
}
