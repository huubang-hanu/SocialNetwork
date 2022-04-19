package com.example.socialnetwork.service;

import com.example.socialnetwork.entity.Post;
import com.example.socialnetwork.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Rule;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class PostServiceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService ;

    @Test
    void findById() {
        when(postRepository.findById(1)).thenReturn(Optional.of(new Post(1,"Hello", "Hi")));
        assertEquals(1, postService.findById(1).getId());

    }

    @Test
    void whenFindByIdWithIdIsNotExit_thenThrowNoSuchElementException(){
        when(postRepository.findById(2)).thenThrow(NoSuchElementException.class);
        assertThrows(NoSuchElementException.class, () ->  postService.findById(2));
    }

    @Test
    void getAll() {
    }

    @Test
    void add() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}