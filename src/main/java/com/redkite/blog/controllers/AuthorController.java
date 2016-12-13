package com.redkite.blog.controllers;

import com.redkite.blog.dao.AuthorDao;
import com.redkite.blog.model.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class AuthorController {

  @Autowired
  AuthorDao authorDao;

  @RequestMapping("/profile")
  public String authorProfiles(Map<String, Object> model) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    Author author = authorDao.getAuthor(auth.getName());
    model.put("author", author);
    return "author_profile";
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String signIn() {
    return "sign_in";
  }

}
