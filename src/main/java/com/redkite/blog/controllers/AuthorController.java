package com.redkite.blog.controllers;

import com.redkite.blog.dao.AuthorDao;
import com.redkite.blog.model.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class AuthorController {

  @Autowired
  AuthorDao authorDao;

  @RequestMapping("/profiles")
  public String authorProfiles(Map<String, Object> model) {
    List<Author> authors = authorDao.findAll();
    model.put("authors", authors);
    return "authors_profiles";
  }
}
