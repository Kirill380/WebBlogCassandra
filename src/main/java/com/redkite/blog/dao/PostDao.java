package com.redkite.blog.dao;

import com.redkite.blog.model.Comment;
import com.redkite.blog.model.Post;
import com.redkite.blog.model.Vote;
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


  public Post create(Post post) {
    return super.save(post);
  }

  public void addVote(Long id, Vote vote) {

  }

  public void  addComment(Long id, Comment comment) {

  }

}
