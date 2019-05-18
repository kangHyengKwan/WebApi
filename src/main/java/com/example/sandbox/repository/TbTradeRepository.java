package com.example.sandbox.repository;

import com.example.sandbox.entity.TbTrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TbTradeRepository extends JpaRepository<TbTrade, Long> {
    @Query(value=
    "SELECT row_number() OVER(ORDER BY t1.TR_DATE, t1.RowIdx) as id " +
    "     , t1.TR_DATE " +
    "     , t2.ACCT_NM " +
    "     , t1.ACCT_NO " +
    "     , SUM_AMT " +
    "  FROM ( " +
    "           SELECT YEAR(TR_DATE) as TR_DATE " +
    "                , ACCT_NO " +
    "                , TR_AMT - TR_FEE as SUM_AMT " +
    "                , ROW_NUMBER() OVER(PARTITION BY YEAR(TR_DATE) ORDER BY TR_AMT - TR_FEE DESC) as RowIdx " +
    "             FROM TB_TRADE " +
    "            WHERE CANCEL_YN = 'N' " +
    "       ) t1, TB_INFO_ACCT t2 " +
    "  WHERE t1.ROWIDX = 1 " +
    "    AND t1.acct_no = t2.acct_no " +
    "  ORDER BY t1.TR_DATE, t1.RowIdx ", nativeQuery = true)
    List<TbTrade> fildMaxSumAmt();
}

