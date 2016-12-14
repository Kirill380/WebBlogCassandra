package com.redkite.blog.controllers;

import com.redkite.blog.dao.PostDao;
import com.redkite.blog.model.Comment;
import com.redkite.blog.model.Post;
import com.redkite.blog.model.Vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class PostController {

  @Autowired
  private PostDao postDao;


  @RequestMapping(value = {"/", "/home"})
  public String home(Map<String, Object> model) {
    List<Post> posts = postDao.findAll();
    posts.sort((p1, p2) -> new Long(p2.getPublishDate().getTime()).compareTo(p1.getPublishDate().getTime()));
    model.put("posts", posts);
    return "home";
  }

  @RequestMapping(value = "/api/post/{id}/comment", method = RequestMethod.POST)
  public ResponseEntity<String> addComment(@PathVariable UUID id, @RequestBody Comment comment) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    comment.setPublishDate(new Date());
    comment.setEmail(auth.getName());
    postDao.addComment(id, comment);
    return ResponseEntity.ok("Success");
  }

  // figure out why should I return ResponseEntity<String>, because it is not restcontroller
  @RequestMapping(value = "/api/post", method = RequestMethod.POST)
  public ResponseEntity<String> createPost(@RequestBody Post post) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    post.setPublishDate(new Date());
    post.setAuthor(auth.getName());
    postDao.create(post);
    return ResponseEntity.ok("Success");
  }

  @RequestMapping(value = "/api/post/{id}", method = RequestMethod.DELETE)
  public void deletePost(@PathVariable UUID id) {
    postDao.deletePost(id);
  }

  @RequestMapping(value = "/api/post/{id}/vote", method = RequestMethod.POST)
  public ResponseEntity<String> voteForPost(@PathVariable UUID id, @RequestParam Boolean positive) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    postDao.addVote(id, new Vote(positive, auth.getName()));
    return ResponseEntity.ok("Success");
  }

}

