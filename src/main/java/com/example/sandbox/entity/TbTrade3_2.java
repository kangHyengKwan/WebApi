package com.example.sandbox.entity;

import javax.persistence.*;


@Entity
public class TbTrade3_2 {
  @Id
  @Column(name = "id", nullable = false)
  public Long id;

  @Column(name = "TR_DATE", nullable = false)
  public String TrDate;
  
  @Column(name = "BKR_NM", nullable = false)
  public String BkrNm;

  @Column(name = "BKR_CD", nullable = false)
  public String BkrCd;

  @Column(name = "SUM_AMT", nullable = false)
  public Long SumAmt;
}
