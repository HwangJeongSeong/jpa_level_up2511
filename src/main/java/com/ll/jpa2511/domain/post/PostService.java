package com.ll.jpa2511.domain.post;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Post not found"));
    }

    public List<Post> findByUsername(String username) {
        return postRepository.findByUsername(username);
    }

    @SneakyThrows
    public Optional<Post> findWithShareLockByid(Long id) {
        postRepository.findWithShareLockByid(id);
        Thread.sleep(10000);
        return postRepository.findWithShareLockByid(id);
    }
    public Optional<Post> findWithWriteLockById(Long id) {
        return postRepository.findWithWriteLockById(id);
    }

    @SneakyThrows
    @Transactional
    public Post modifyOptimistic(Long id) {
        Post post = postRepository.findById(id).orElseThrow();

        Thread.sleep(10_000);

        post.setUsername(post.getUsername() + "!");
        return post;
    }
}
