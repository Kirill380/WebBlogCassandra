package com.redkite.blog.model;

import lombok.Data;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Data
@Table(name = "author")
public class Author {

  @PartitionKey
  @Column
  private String email;

  @Column(name = "user_name")
  private String userName;

  @Column
  private String password;
}
