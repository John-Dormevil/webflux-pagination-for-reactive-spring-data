package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Cimblo.com
 * @version 2.0.0
 * @since 2.0.0 (22 Sep 2018)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "basic")
public class Basic implements Serializable {

  private String id;
  private String name;
  private String address;
  private Date createdDate;
}
