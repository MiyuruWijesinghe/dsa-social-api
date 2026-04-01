package com.dsa.dsa_social_api.controller;

import com.dsa.dsa_social_api.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    private FollowService service;

    @PostMapping
    public String follow(@RequestParam Long userId,
                         @RequestParam Long targetId) {
        service.follow(userId, targetId);
        return "User " + userId + " started to follow User " + targetId + " successfully";
    }

    @GetMapping("/following/{id}")
    public List<Long> following(@PathVariable Long id) {
        return service.getFollowing(id);
    }

    @GetMapping("/followers/{id}")
    public List<Long> followers(@PathVariable Long id) {
        return service.getFollowers(id);
    }

    @GetMapping("/suggest-followers/{id}")
    public List<Long> suggestFollowers(@PathVariable Long id) {
        return service.getSuggestFollowers(id);
    }
}
