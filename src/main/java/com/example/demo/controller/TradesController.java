package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Trades;
import com.example.demo.exception.NotFoundException;
import com.example.demo.service.TradesService;

@RestController
@RequestMapping("/trades")
public class TradesController {

	@Autowired
	TradesService tradesservice;

	@GetMapping("/get")
	public List<Trades> getTrades() {
		return tradesservice.getTrades();
	}

	@PostMapping("/update")
	public List<Trades> updateTrades(@RequestBody Trades trades) throws Exception {
		if (trades == null || trades.getTradesPK() == null || trades.getTradesPK().getTrade_Id() == null
				|| trades.getTradesPK().getTrade_Id() == "" || trades.getTradesPK().getVersion() == null
				|| trades.getTradesPK().getVersion() < 0) {
			throw new NotFoundException();
		}
		return tradesservice.updateTrades(trades);
	}

}
