package com.ll.jpa2511.global.initData;

import com.ll.jpa2511.domain.post.Post;
import com.ll.jpa2511.domain.post.PostRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitData {
    @Bean
    public ApplicationRunner applicationRunner(PostRepository postRepository) {
        return args -> {
            if (postRepository.count() > 0) {
                return;
            }

            postRepository.saveAll(List.of(
                    Post.builder().username("alice").title("Hello World").content("First post content").build(),
                    Post.builder().username("bob").title("Locking Demo").content("Example content for lock test").build(),
                    Post.builder().username("alice").title("Second Entry").content("Additional sample content").build()
            ));
        };
    }
}
