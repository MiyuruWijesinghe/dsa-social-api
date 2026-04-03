package com.dsa.dsa_social_api.controller;

import com.dsa.dsa_social_api.model.Comment;
import com.dsa.dsa_social_api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService service;

    @PostMapping
    public String add(@RequestBody Comment comment) {
        service.addComment(comment);
        return "Comment added";
    }

    @PostMapping("/reply")
    public String reply(@RequestParam Long parentId, @RequestBody Comment comment) {
        boolean added = service.addReply(parentId, comment);
        return added ? "Reply added" : "Parent comment not found";
    }

    @GetMapping("/{postId}")
    public List<Comment> get(@PathVariable Long postId) {
        return service.getComments(postId);
    }
}
