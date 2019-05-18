package com.example.sandbox.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Entity
@JsonPropertyOrder({ "brName", "brCode", "sumAmt" })
public class TbTrade4 {
  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @JsonProperty
  @Column(name = "BKR_CD", nullable = false)
  private String brCode;
  
  @JsonProperty
  @Column(name = "BKR_NM", nullable = false)
  private String brName;

  @JsonProperty
  @Column(name = "SUM_AMT", nullable = false)
  private Long sumAmt;
}
