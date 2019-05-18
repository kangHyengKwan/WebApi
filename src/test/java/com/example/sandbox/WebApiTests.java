package com.example.sandbox;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebApiTests {

    @Autowired
    protected TestRestTemplate restTemplate;
    
    @LocalServerPort
    private int port;
    
    /* /api/tradeMax */
    @Test
    public void testTradeMax() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:" + port + "/api/tradeMax/", HttpMethod.GET, entity, String.class);
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
    }

    /* /api/tradeNon */
    @Test
    public void testTradeNon() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:" + port + "/api/tradeNon/", HttpMethod.GET, entity, String.class);
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
    }

    /* /api/tradeMaxBkr */
    @Test
    public void testTradeMaxBkr() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:" + port + "/api/tradeMaxBkr/", HttpMethod.GET, entity, String.class);
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
    }

    /* /api/tradeBkr 판교점 */
    @Test
    public void testTradeBkr() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        String bodyTesting = "{ \"brName\": \"판교점\" }";
        HttpEntity<String> entity = new HttpEntity<String>(bodyTesting, headers);
        
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:" + port + "/api/tradeBkr/", HttpMethod.GET, entity, String.class);
        assertEquals(HttpStatus.NOT_FOUND, exchange.getStatusCode());
    }

    /* /api/tradeBkr2 분당점 */
    @Test
    public void testTradeBkr2() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        String bodyTesting = "{ \"brName\": \"분당점\" }";
        HttpEntity<String> entity = new HttpEntity<String>(bodyTesting, headers);
        
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:" + port + "/api/tradeBkr/", HttpMethod.GET, entity, String.class);
        assertEquals(HttpStatus.NOT_FOUND, exchange.getStatusCode());
    }

}