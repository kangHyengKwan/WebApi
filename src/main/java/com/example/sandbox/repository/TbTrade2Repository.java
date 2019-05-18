package com.example.sandbox.repository;

import com.example.sandbox.entity.TbTrade2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TbTrade2Repository extends JpaRepository<TbTrade2, Long> {

    @Query(value=
    "SELECT row_number() OVER(ORDER BY YEAR, ACCT_NO) as id " +
    "     , t1.YEAR " +
    "     , t1.ACCT_NM " +
    "     , t1.ACCT_NO " +
    "  FROM ( " +
    "           SELECT b.YEAR " +
    "                , a.ACCT_NM  " +
    "                , a.ACCT_NO  " +
    "             FROM TB_INFO_ACCT a " +
    "                , ( SELECT distinct year(TR_DATE) as YEAR " +
    "                      FROM TB_TRADE ) b " +
    "        ) t1 " +
    " WHERE NOT EXISTS ( SELECT year(t2.TR_DATE) as YEAR " +
    "                         , t2.ACCT_NO " +
    "                      FROM TB_TRADE t2 " +
    "                     WHERE year(t2.TR_DATE) = t1.YEAR " +
    "                       AND t2.ACCT_NO       = t1.ACCT_NO " +
    "                       AND t2.cancel_yn     = 'N' " +
    "                     GROUP BY year(t2.TR_DATE) " +
    "                            , t2.ACCT_NO ) " +
    " ORDER BY YEAR, ACCT_NO ", nativeQuery = true)
    List<TbTrade2> findNonTrade();
}

