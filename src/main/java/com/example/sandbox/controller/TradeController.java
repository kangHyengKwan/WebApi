package com.example.sandbox.controller;

import com.example.sandbox.entity.ErrorResponse;
import com.example.sandbox.entity.TbTrade;
import com.example.sandbox.entity.TbTrade2;
import com.example.sandbox.entity.TbTrade3_1;
import com.example.sandbox.entity.TbTrade3_2;
import com.example.sandbox.entity.TbTrade4;
import com.example.sandbox.service.TbTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@RestController
public class TradeController {

  @Autowired
  private TbTradeService tbTradeService;

  /* 1번 문제 */
  @GetMapping("/api/tradeMax")
  public List<TbTrade> findMaxSumAmt() {
    return tbTradeService.findMaxSumAmt();
  }

  /* 2번 문제 */
  @GetMapping("/api/tradeNon")
  public List<TbTrade2> findNonTrade() {
    return tbTradeService.findNonTrade();
  }

  /* 3번 문제 */
  @GetMapping("/api/tradeMaxBkr")
	public JSONArray findTradeMaxBkr() {
    
    List<TbTrade3_1> TTrade3_1= tbTradeService.findBkrMaxYear();
    List<TbTrade3_2> TTrade3_2= tbTradeService.findBkrMaxData();

    String jsonStr = "[";
    for(int i = 0; i < TTrade3_1.size(); i++)
    {
      String sYear = TTrade3_1.get(i).year.toString();

      jsonStr += "{";
      jsonStr += "\"year\":" + TTrade3_1.get(i).year.toString() + ",";
      jsonStr += "\"list\" : [";
      
      for(int j = 0; j < TTrade3_2.size(); j++)
      {
        String sTrDate = TTrade3_2.get(j).TrDate.toString();
        
        if(sYear.equals(sTrDate) == true)
        {
          jsonStr += "{";
          jsonStr += "\"brCode\":\"" + TTrade3_2.get(j).BkrCd.toString() + "\",";
          jsonStr += "\"brName\":\"" + TTrade3_2.get(j).BkrNm.toString() + "\",";
          jsonStr += "\"sumAmt\":\"" + TTrade3_2.get(j).SumAmt.toString() + "\"";
          jsonStr += "},";
        }
      }
      
      jsonStr += "]";
      jsonStr += "},";
    }
    jsonStr += "]";
    
    JSONParser parser = new JSONParser();
    JSONArray obj = new JSONArray();
    try
    {
      obj = (JSONArray)parser.parse( jsonStr );
    }
    catch(ParseException e) { }
    
    return obj;
  }

  /* 4번 문제 */
  @GetMapping("/api/tradeBkr")
  public List<TbTrade4> findBkrTrade(@RequestBody Map<String, ?> input) throws Exception {
    List<TbTrade4> TbTrade4 = tbTradeService.findBkrTrade(input.get("brName").toString());

    if(TbTrade4.size() == 0 || input.get("brName").equals("분당점") == true)
    {
      throw new Exception();
    }
    else{
      return TbTrade4;
    }
  }
  
  
  @ExceptionHandler(value = { Exception.class })
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse unKnownException(Exception ex)
  {
      return new ErrorResponse("404", "br code not found error");
  }



      
	


}
