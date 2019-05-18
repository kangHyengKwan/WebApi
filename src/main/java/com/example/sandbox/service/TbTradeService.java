package com.example.sandbox.service;

import com.example.sandbox.entity.TbTrade;
import com.example.sandbox.entity.TbTrade2;
import com.example.sandbox.entity.TbTrade3_1;
import com.example.sandbox.entity.TbTrade3_2;
import com.example.sandbox.entity.TbTrade4;
import com.example.sandbox.repository.TbTradeRepository;
import com.example.sandbox.repository.TbTrade2Repository;
import com.example.sandbox.repository.TbTrade3_1Repository;
import com.example.sandbox.repository.TbTrade3_2Repository;
import com.example.sandbox.repository.TbTrade4Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional
public class TbTradeService {

  @Autowired
  private TbTradeRepository tbTradeRepository;

  @Autowired
  private TbTrade2Repository tbTrade2Repository;

  @Autowired
  private TbTrade3_1Repository tbTrade3_1Repository;

  @Autowired
  private TbTrade3_2Repository tbTrade3_2Repository;

  @Autowired
  private TbTrade4Repository tbTrade4Repository;


  public List<TbTrade> findMaxSumAmt(){
    return tbTradeRepository.fildMaxSumAmt();
  }

  public List<TbTrade2> findNonTrade(){
    return tbTrade2Repository.findNonTrade();
  }

  public List<TbTrade3_1> findBkrMaxYear(){
    return tbTrade3_1Repository.findBkrMaxYear();
  }

  public List<TbTrade3_2> findBkrMaxData(){
    return tbTrade3_2Repository.findBkrMaxData();
  }

  public List<TbTrade4> findBkrTrade(String brName){
    return tbTrade4Repository.findBkrTrade(brName);
  }
  
}