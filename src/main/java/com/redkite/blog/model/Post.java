package com.redkite.blog.model;

import lombok.Data;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "post")
public class Post {

  @PartitionKey
  @Column
  private Long id;

  @Column
  private String title;

  @Column(name = "post_body")
  private String body;

  @Column
  private String author;

  @Column(name = "publish_date")
  private Date publishDate;

  @Column
  private List<String> tags;

  @Column
  private List<Comment> comments;

  @Column
  private List<Vote> votes;


  public int getVoteScore() {
    return votes.stream().mapToInt( v -> v.getPositive() ? 1 : -1).sum();
  }

}
