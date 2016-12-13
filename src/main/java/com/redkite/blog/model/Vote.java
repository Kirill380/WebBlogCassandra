package com.redkite.blog.model;

import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.UDT;
import lombok.Data;

@Data
@UDT(name = "vote")
public class Vote {

  @Field
  private Boolean positive;

  @Field(name = "author_email")
  private String authorEmail;


  public Vote(Boolean positive, String authorEmail) {
    this.positive = positive;
    this.authorEmail = authorEmail;
  }

  public Vote() {
  }
}
