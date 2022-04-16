package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Trades;
import com.example.demo.entity.TradesPK;

@Repository
public interface TradesRepository extends JpaRepository<Trades, TradesPK> {

}
