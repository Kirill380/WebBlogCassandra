package com.redkite.blog.dao;

import com.redkite.blog.model.Author;

import org.springframework.stereotype.Repository;

@Repository
public class AuthorDao extends AbstractCassandraDao<Author, String> {

  @Override
  protected Class<Author> getColumnFamilyClass() {
    return Author.class;
  }

  @Override
  protected String getColumnFamilyName() {
    return "author";
  }

}
