package com.example.sandbox.repository;

import com.example.sandbox.entity.TbTrade3_2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TbTrade3_2Repository extends JpaRepository<TbTrade3_2, Long> {

    @Query(value=
    "SELECT row_number() OVER(ORDER BY TR_DATE, BKR_NM, BKR_CD) as id "+
    "     , TR_DATE "+
    "     , BKR_NM "+
    "     , BKR_CD "+
    "     , SUM(SUM_AMT) as SUM_AMT "+
    "  FROM ( SELECT year(a.TR_DATE) as TR_DATE "+
    "              , TR_AMT - TR_FEE as SUM_AMT "+
    "              , c.BKR_CD "+
    "              , c.BKR_NM "+
    "           FROM TB_TRADE a "+
    "              , TB_INFO_ACCT b "+
    "              , TB_INFO_BKR c "+
    "          WHERE a.CANCEL_YN ='N' "+
    "            AND a.ACCT_NO = b.ACCT_NO "+
    "            AND b.BKR_CD = c.BKR_CD "+
    "        ) t1 "+
    "  GROUP BY TR_DATE, BKR_NM, BKR_CD "+
    "  ORDER BY TR_DATE, BKR_NM, BKR_CD ", nativeQuery = true)
    List<TbTrade3_2> findBkrMaxData();
}


