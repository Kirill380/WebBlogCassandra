package com.redkite.blog.model;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table(name = "post")
public class Post {

  @PartitionKey
  @Column
  private UUID id;

  @Column
  private String title;

  @Column(name = "post_body")
  private String body;

  @Column
  private String author;

  @Column(name = "publish_date")
  private Date publishDate;

  @Column
  private List<String> tags = new ArrayList<>();

  @Column
  private List<Comment> comments = new ArrayList<>();

  @Column
  private List<Vote> votes = new ArrayList<>();


  public int getVoteScore() {
    return  votes != null && !votes.isEmpty() ? votes.stream().mapToInt( v -> v.getPositive() ? 1 : -1).sum() : 0;
  }

}
