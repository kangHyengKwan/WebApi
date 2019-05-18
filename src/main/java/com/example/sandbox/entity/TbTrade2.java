package com.example.sandbox.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Entity
@JsonPropertyOrder({ "year", "name", "acctNo" })
public class TbTrade2 {
  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @JsonProperty
  @Column(name = "YEAR", nullable = false)
  private String year;
  
  @JsonProperty
  @Column(name = "ACCT_NM", nullable = false)
  private String name;

  @JsonProperty
  @Column(name = "ACCT_NO", nullable = false)
  private String acctNo;
}
