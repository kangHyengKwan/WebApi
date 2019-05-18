package com.example.sandbox.repository;

import com.example.sandbox.entity.TbTrade4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TbTrade4Repository extends JpaRepository<TbTrade4, Long> {

    @Query(value=
    "SELECT row_number() OVER(ORDER BY BKR_CD, BKR_NM) as id " +
    "     , BKR_CD " +
    "     , BKR_NM " +
    "     , SUM(sum_amt) as SUM_AMT " +
    "  FROM (  SELECT CASE WHEN c.BKR_CD = 'B' THEN 'A' ELSE c.BKR_CD END      as BKR_CD " +
    "               , CASE WHEN c.BKR_NM = '분당점' THEN '판교점' ELSE c.BKR_NM END as BKR_NM " +
    "               , a.TR_AMT - a.TR_FEE as sum_amt " +
    "            FROM TB_TRADE a " +
    "               , TB_INFO_ACCT b " +
    "               , TB_INFO_BKR c " +
    "           WHERE a.CANCEL_YN = 'N' " +
    "             AND a.ACCT_NO   = b.ACCT_NO " +
    "             AND b.BKR_CD    = c.BKR_CD " +
    "       ) t1 " +
    " WHERE BKR_NM = ?1 " +
    " GROUP BY BKR_CD, BKR_NM ", nativeQuery = true)
    List<TbTrade4> findBkrTrade(String brName);
}

