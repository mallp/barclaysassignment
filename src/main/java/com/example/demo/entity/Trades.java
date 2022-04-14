package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Trades {
	
	@EmbeddedId
	TradesPK tradesPK;
	
	String Counter_Party_Id;

	String Book_id;

	Date Maturity_Date;

	Date Created_Date;

	String Expired;

}
