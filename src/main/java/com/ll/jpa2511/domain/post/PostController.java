package com.ll.jpa2511.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/{id}")
    public Post showPost(@PathVariable("id") Long id) {
        return postService.getPost(id);
    }

    @GetMapping("/findWithShareLockByid/{id}")
    public Post findWithShareLockByid(@PathVariable("id") Long id) {
        return postService.findWithShareLockByid(id).orElse(null);
    }

    @GetMapping("/findByUsername/{username}")
    public List<Post> findByUsername(@PathVariable("username") String username) {
        return postService.findByUsername(username);
    }

    @GetMapping("/findWithWriteLockById/{id}")
    public Post findWithWriteLockById(@PathVariable Long id) {
        return postService.findWithWriteLockById(id).orElse(null);
    }


    @GetMapping("/modify/optimistic/{id}")
    public Post modifyOptimistic(@PathVariable Long id) {
        return postService.modifyOptimistic(id);
    }
}