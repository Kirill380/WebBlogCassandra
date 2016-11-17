package com.redkite.blog.dao;

import com.redkite.blog.model.Post;

import org.springframework.stereotype.Repository;

@Repository
public class PostDao  extends AbstractCassandraDao<Post, Long> {

  @Override
  protected Class<Post> getColumnFamilyClass() {
    return Post.class;
  }

  @Override
  protected String getColumnFamilyName() {
    return "post";
  }
}
