package com.example.sandbox.repository;

import com.example.sandbox.entity.TbTrade3_1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TbTrade3_1Repository extends JpaRepository<TbTrade3_1, Long> {

    @Query(value=
    "SELECT DISTINCT year(TR_DATE) as YEAR "+
    "  FROM TB_TRADE "+
    " ORDER BY year(TR_DATE) ", nativeQuery = true)
    List<TbTrade3_1> findBkrMaxYear();

}


