package com.redkite.blog.controllers;

import com.redkite.blog.dao.PostDao;
import com.redkite.blog.model.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class PostController {

  @Autowired
  private PostDao postDao;


  @RequestMapping("/home")
  public String home(Map<String, Object> model) {
    List<Post> posts = postDao.findAll();
    model.put("posts", posts);
    return "home";
  }
}
