package com.jpa.sample.entity;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * This class represent the composite key for employee class.
 *
 * @author SAM
 */
@NoArgsConstructor
public class CompositeKey implements Serializable {

  /**
   * Serial version ID.
   */
  private static final long serialVersionUID = 1997735360278978635L;

  private int id;

  private LocalDate dateCreated;


}
