package com.example.sandbox.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Entity
@JsonPropertyOrder({ "year", "name", "acctNo", "sumAmt" })
public class TbTrade {
  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @JsonProperty
  @Column(name = "TR_DATE", nullable = false)
  private String year;

  @JsonProperty
  @Column(name = "ACCT_NM", nullable = false)
  private String name;

  @JsonProperty
  @Column(name = "ACCT_NO", nullable = false)
  private String acctNo;

  @JsonProperty
  @Column(name = "SUM_AMT", nullable = false)
  private Long sumAmt;
}

