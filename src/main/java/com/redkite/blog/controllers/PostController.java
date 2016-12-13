package com.redkite.blog.controllers;

import com.redkite.blog.dao.PostDao;
import com.redkite.blog.model.Comment;
import com.redkite.blog.model.Post;
import com.redkite.blog.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class PostController {

  @Autowired
  private PostDao postDao;


  @RequestMapping(value = {"/", "/home"})
  public String home(Map<String, Object> model) {
    List<Post> posts = postDao.findAll();
    model.put("posts", posts);
    return "home";
  }

  @RequestMapping(value = "/api/post/{id}/comment", method = RequestMethod.POST)
  public void addComment(@PathVariable Long id, @RequestBody Comment comment) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    comment.setPublishDate(new Date());
    comment.setEmail(auth.getName());
    postDao.addComment(id, comment);
  }

  @RequestMapping(value = "/api/post", method = RequestMethod.POST)
  public void createPost(@RequestBody Post post) {
    postDao.create(post);
  }

  @RequestMapping(value = "/api/post/{id}", method = RequestMethod.DELETE)
  public void deletePost(@PathVariable Long id) {
    postDao.deletePost(id);
  }

  @RequestMapping(value = "/api/post/{id}/vote", method = RequestMethod.POST)
  public void voteForPost(@PathVariable Long id, @RequestParam Boolean positive) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    postDao.addVote(id, new Vote(positive, auth.getName()));
  }

}

