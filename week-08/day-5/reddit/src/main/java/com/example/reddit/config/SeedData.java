package com.example.reddit.config;

import com.example.reddit.model.Post;
import com.example.reddit.model.User;
import com.example.reddit.service.PostService;
import com.example.reddit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.listPost();

        if (posts.size() == 0) {

            User user1 = new User();
            User user2 = new User();

            user1.setName("user");
            user1.setPassword("password");

            user2.setName("admin");
            user2.setPassword("password");

            userService.save(user1);
            userService.save(user2);


            Post post1 = (new Post("Want bigger legs? Check this out!", "https://www.youtube.com/watch?v=p1u_EoG7Qyw"));
            Post post2 = (new Post("The Almighty Loaf", "https://www.youtube.com/watch?v=VAC-5BQnuXI"));
            Post post3 = (new Post("Best Bollywood Blockbuster", "https://www.youtube.com/watch?v=OVcwNoZdDko"));

            post1.setUser(user1);
            post2.setUser(user1);
            post3.setUser(user2);

            postService.savePost(post1);
            postService.savePost(post2);
            postService.savePost(post3);
        }
    }
}
