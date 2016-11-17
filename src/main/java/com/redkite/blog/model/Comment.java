package com.redkite.blog.model;

import lombok.Data;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.UDT;

import java.sql.Timestamp;
import java.util.Date;

@Data
@UDT(name = "comment")
public class Comment {

  @Field(name = "comment_body")
  private String commentBody;

  @Field(name = "publish_date")
  private Date publishDate;

  @Field
  private String email;

}
