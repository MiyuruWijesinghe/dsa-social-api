package com.dsa.dsa_social_api.service;

import com.dsa.dsa_social_api.model.Comment;
import com.dsa.dsa_social_api.repository.InMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private InMemoryStore store;

    // Add root comment
    public void addComment(Comment comment) {
        store.commentsByPost.computeIfAbsent(comment.getPostId(), k -> new ArrayList<>()).add(comment);
    }

    // Add reply (TREE recursion)
    public boolean addReply(Long commentId, Comment reply) {
        for (List<Comment> comments : store.commentsByPost.values()) {
            for (Comment c : comments) {
                if (findAndAddReply(c, commentId, reply)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Recursive DFS
    private boolean findAndAddReply(Comment current, Long targetId, Comment reply) {
        if (current.getId().equals(targetId)) {
            current.getReplies().add(reply);
            return true;
        }

        for (Comment child : current.getReplies()) {
            if (findAndAddReply(child, targetId, reply)) {
                return true;
            }
        }
        return false;
    }

    // Get full tree
    public List<Comment> getComments(Long postId) {
        return store.commentsByPost.getOrDefault(postId, new ArrayList<>());
    }
}
