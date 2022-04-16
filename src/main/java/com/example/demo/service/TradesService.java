package com.example.demo.service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Trades;
import com.example.demo.exception.LowerVersionFoundException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.TradesRepository;

@Service
public class TradesService {

	@Autowired
	TradesRepository tradesRepository;

	public List<Trades> getTrades() {
		return tradesRepository.findAll();
	}

	public List<Trades> updateTrades(Trades trades) throws Exception {
		boolean lowerVersion = true;
		Trades localTrades = null;
		List<Trades> tradesList = tradesRepository.findAll();
		if (tradesList.isEmpty() || tradesList == null) {
			throw new NotFoundException();
		}
		lowerVersion = tradesList.stream()
				.allMatch(t -> t.getTradesPK().getVersion() > trades.getTradesPK().getVersion());

		// throw error if version is lower for given Trade_id in database record
		if (lowerVersion == true) {
			throw new LowerVersionFoundException();
		}

		// store or update after validating the logic i.e MaturityDate should come after
		// Todays Date
		localTrades = createTrades(trades);

		// update all the record Expired flag to "Y" for MaturityDate should come after
		// Todays Date
		List<Trades> tradesListstream = tradesList.stream().filter(t -> isMaturityDateBeforeToday(t))
				.collect(Collectors.toList());
		Iterator<Trades> itr = tradesListstream.stream().iterator();
		while (itr.hasNext()) {
			itr.next().setExpired("Y");
		}
		tradesRepository.saveAll(tradesListstream);
		tradesListstream.add(localTrades);
		return tradesListstream;
	}

	private Trades createTrades(Trades trades) {
		Trades localtrades = null;
		if (!isMaturityDateBeforeToday(trades)) {
			localtrades = tradesRepository.save(trades);
		}
		return localtrades;
	}

	private boolean isMaturityDateBeforeToday(Trades trades) {
		boolean isMaturityDateBeforeTodayDate = false;
		if (java.time.LocalDate.now().isAfter(trades.getMaturity_Date().toLocalDate())) {
			isMaturityDateBeforeTodayDate = true;
		}
		return isMaturityDateBeforeTodayDate;
	}
}
