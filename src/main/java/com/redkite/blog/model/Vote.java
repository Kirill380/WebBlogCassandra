package com.redkite.blog.model;

import lombok.Data;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.UDT;

@Data
@UDT(name = "vote")
public class Vote {

  @Field
  private Boolean positive;

  @Field(name = "author_email")
  private String authorEmail;

}
