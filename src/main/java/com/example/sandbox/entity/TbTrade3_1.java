package com.example.sandbox.entity;

import javax.persistence.*;


@Entity
public class TbTrade3_1 {
  @Id
  @Column(name = "YEAR", nullable = false)
  public String year;
}
