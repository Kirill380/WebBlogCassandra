package com.redkite.blog.dao;

import com.redkite.blog.model.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDao extends AbstractCassandraDao<Author, String> {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  protected Class<Author> getColumnFamilyClass() {
    return Author.class;
  }

  @Override
  protected String getColumnFamilyName() {
    return "author";
  }

  @Override
  public Author save(Author entity) {
    entity.setPassword(passwordEncoder.encode(entity.getPassword()));
    return super.save(entity);
  }
}
