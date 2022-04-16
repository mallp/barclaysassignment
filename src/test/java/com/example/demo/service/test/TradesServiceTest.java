package com.example.demo.service.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Trades;
import com.example.demo.entity.TradesPK;
import com.example.demo.repository.TradesRepository;
import com.example.demo.service.TradesService;

@RunWith(SpringRunner.class)
public class TradesServiceTest {
	
	@InjectMocks
	TradesService tradesService;
	
	@Mock
	TradesRepository tradesRepository;
	
	@Test
	public void getTradesTest() {
		tradesService.getTrades();
	}
	
	@Test
	public void updateTradesNotFoundExceptionTest() {
		try {
			tradesService.updateTrades(getTrades());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	@Test
	public void NotFoundExceptionforEmptyTradesListTest() {
		try {
			Mockito.when(tradesRepository.findAll()).thenReturn(getTradesList());
			tradesService.updateTrades(getTrades());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	
	@Test
	public void isMaturityDateBeforeTodayTest() {
		try {
			Mockito.when(tradesRepository.findAll()).thenReturn(getTradesList());
			Trades t =getTrades();
			t.setMaturity_Date(new java.sql.Date(System.currentTimeMillis()));
			tradesService.updateTrades(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	
	@Test
	public void LowerVersionFoundExceptionTest() {
		try {
			Mockito.when(tradesRepository.findAll()).thenReturn(getTradesList());
			Trades t =getTrades();
			TradesPK tradesPK =new TradesPK();
			tradesPK.setVersion(0);
			t.setTradesPK(tradesPK);
			t.setMaturity_Date(new java.sql.Date(System.currentTimeMillis()));
			tradesService.updateTrades(t);
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
	
	private List<Trades> getTradesList() {
		List<Trades> tradesList = new ArrayList<>();
		Trades t = new Trades();
		t.setBook_id("B1");
		t.setCounter_Party_Id("CP-1");
		t.setCreated_Date(new Date(1L));
		t.setExpired("N");
		t.setMaturity_Date(new Date(1L));
		t.setTradesPK(new TradesPK("T1", 1));
		tradesList.add(t);
		return tradesList;

	}

}
