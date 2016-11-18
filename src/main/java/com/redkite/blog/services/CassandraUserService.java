package com.redkite.blog.services;


import com.redkite.blog.dao.AuthorDao;
import com.redkite.blog.model.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Component
public class CassandraUserService implements UserDetailsService {

  @Autowired
  private AuthorDao authorDao;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    try {
      Author author = authorDao.find(email);
      if (author == null) {
        return null;
      }
      return new User(author.getEmail(), author.getPassword(), new ArrayList<>());
    }
    catch (Exception e){
      throw new UsernameNotFoundException("User not found");
    }
  }

}
