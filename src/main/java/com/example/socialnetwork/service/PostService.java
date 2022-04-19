package com.example.socialnetwork.service;

import com.example.socialnetwork.entity.Post;
import com.example.socialnetwork.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(Integer id) {
        return postRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Post's Id is not exist"));
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Post add(Post post){
        return postRepository.save(post);
    }

    public Post update(Integer id, Post newPost){

      Post updatedPost = postRepository.findById(id).map(post -> {
           post.setTitle(newPost.getTitle());
           post.setDetail(newPost.getDetail());
           return post;
       }).orElseThrow(()-> new NoSuchElementException("Post's Id is not exist"));

     return postRepository.save(updatedPost);
    }

    public boolean delete(Integer id){
       Post post = postRepository.findById(id).get();

        if (post != null){
            postRepository.delete(post);
            return true;
        } else {
            throw new NoSuchElementException("Post is not exist");
        }

    }
}
