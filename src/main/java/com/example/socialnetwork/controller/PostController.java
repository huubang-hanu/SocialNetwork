package com.example.socialnetwork.controller;

import com.example.socialnetwork.entity.Post;
import com.example.socialnetwork.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/all")
    public List<Post> getAll(){
        return postService.getAll();
    }


    @GetMapping("/{id}")
    public Post findById(@PathVariable Integer id){
        return postService.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Post> add(@RequestBody Post post){
        Post savedPost = postService.add(post);
        return ResponseEntity.ok(savedPost);
    }

    public ResponseEntity delete(@PathVariable Integer id){
        if(postService.delete(id)){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }

    }
}
