package com.example.demo.controller.test;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.controller.TradesController;
import com.example.demo.entity.Trades;
import com.example.demo.entity.TradesPK;
import com.example.demo.exception.NotFoundException;
import com.example.demo.service.TradesService;

@RunWith(SpringRunner.class)
public class TradersControllerTest {

	@InjectMocks
	TradesController tradesController;

	@Mock
	TradesService tradesService;
	
	@Test
	public void getTradesTest() {
		tradesController.getTrades();
	}

	@Test
	public void updateTradesTest() throws Exception {
		Mockito.when(tradesService.updateTrades(Mockito.any(Trades.class))).thenReturn(Mockito.anyList());
		tradesController.updateTrades(getTrades());
	}
	
	@Test
	public void updateTradesNullTest(){
		try {
			Mockito.when(tradesController.updateTrades(null)).thenThrow(NotFoundException.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	
	@Test
	public void updateTradesPKNullTest(){
		try {
			Trades t = getTrades();
			t.setTradesPK(null);
			Mockito.when(tradesController.updateTrades(t)).thenThrow(NotFoundException.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	
	@Test
	public void updateTradesPKVision0Test(){
		try {
			Trades t = getTrades();
			t.getTradesPK().setVersion(-1);
			Mockito.when(tradesController.updateTrades(t)).thenThrow(NotFoundException.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	
	@Test
	public void updateTradesPKVisionNullTest(){
		try {
			Trades t = getTrades();
			t.getTradesPK().setVersion(null);
			Mockito.when(tradesController.updateTrades(t)).thenThrow(NotFoundException.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	@Test
	public void updateTradesPKTradesIdEmptyTest(){
		try {
			Trades t = getTrades();
			t.getTradesPK().setTrade_Id("");
			Mockito.when(tradesController.updateTrades(t)).thenThrow(NotFoundException.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	
	@Test
	public void updateTradesPKTradesIdNULLTest(){
		try {
			Trades t = getTrades();
			t.getTradesPK().setTrade_Id(null);
			Mockito.when(tradesController.updateTrades(t)).thenThrow(NotFoundException.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	

	private Trades getTrades() {
		Trades t = new Trades();
		t.setBook_id("B1");
		t.setCounter_Party_Id("CP-1");
		t.setCreated_Date(new Date(1L));
		t.setExpired("N");
		t.setMaturity_Date(new Date(1L));
		t.setTradesPK(new TradesPK("T1", 1));
		return t;

	}
}
