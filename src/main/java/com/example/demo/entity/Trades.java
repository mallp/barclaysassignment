package com.example.demo.entity;

import java.sql.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Trades {

	@EmbeddedId
	TradesPK tradesPK;

	String Counter_Party_Id;

	String Book_id;

	Date Maturity_Date;

	Date Created_Date;

	String Expired;

	public TradesPK getTradesPK() {
		return tradesPK;
	}

	public void setTradesPK(TradesPK tradesPK) {
		this.tradesPK = tradesPK;
	}

	public String getCounter_Party_Id() {
		return Counter_Party_Id;
	}

	public void setCounter_Party_Id(String counter_Party_Id) {
		Counter_Party_Id = counter_Party_Id;
	}

	public String getBook_id() {
		return Book_id;
	}

	public void setBook_id(String book_id) {
		Book_id = book_id;
	}

	public Date getMaturity_Date() {
		return Maturity_Date;
	}

	public void setMaturity_Date(Date maturity_Date) {
		Maturity_Date = maturity_Date;
	}

	public Date getCreated_Date() {
		return Created_Date;
	}

	public void setCreated_Date(Date created_Date) {
		Created_Date = created_Date;
	}

	public String getExpired() {
		return Expired;
	}

	public void setExpired(String expired) {
		Expired = expired;
	}

	@Override
	public String toString() {
		return "Trades [tradesPK=" + tradesPK + ", Counter_Party_Id=" + Counter_Party_Id + ", Book_id=" + Book_id
				+ ", Maturity_Date=" + Maturity_Date + ", Created_Date=" + Created_Date + ", Expired=" + Expired + "]";
	}

}
